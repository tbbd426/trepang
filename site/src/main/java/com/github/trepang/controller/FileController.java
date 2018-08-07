package com.github.trepang.controller;

import com.github.trepang.controller.support.JsonResult;
import com.typesafe.config.ConfigFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Base64;
import java.util.Random;

/**
 * @author tianbing
 */
@Controller
@RequestMapping("/file")
@Slf4j
public class FileController extends BaseController {

    private String baseFolder;

    @PostConstruct
    public void init() {
        baseFolder = ConfigFactory.load().getString("file.baseFolder");
    }

    private Random random = new Random();

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam String source,
                             @RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String suffix = parseSuffix(fileName);
        if (StringUtils.isEmpty(suffix)) {
            return fail("file type unknown");
        }

        if (StringUtils.isBlank(source) || StringUtils.isBlank(fileName)) {
            return fail("source or fileName cannot be blank");
        }
        String filePathName = generateFilePathName(source, fileName);
        File parentFile = new File(filePathName).getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                return fail("failed to mkdirs");
            }
        }
        String fullPathNmae = getFullPathNmae(filePathName);
        try (FileOutputStream output = new FileOutputStream(fullPathNmae)) {
            IOUtils.write(file.getBytes(), output);
        }
        return ok(new UploadResp(filePathName));
    }

    private String generateFilePathName(String source, String fileName) {
        log.info("source = {}, fileName = {}", source, fileName);
        String suffix = parseSuffix(fileName);
        return source + "/" + randomName() + suffix;
    }

    private String randomName() {
        byte[] bytes = new byte[8];
        random.nextBytes(bytes);
        String fullPath = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return fullPath;
    }

    private String parseSuffix(String fileName) {
        if (fileName == null) {
            return "";
        }
        int index = fileName.lastIndexOf('.');
        if (index >= 0) {
            return fileName.substring(index);
        }
        return "";
    }

    @RequestMapping(value = "/{source:.+}/{fileName:.+}", method = RequestMethod.GET)
    public ResponseEntity show(HttpServletRequest request,
                               @PathVariable String source,
                               @PathVariable String fileName) {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(fileName)) {
            return responseEntity("source or fileName cannot be null");
        }
        String pathName = buildPathName(source, fileName);
        long ifModifiedSince = request.getDateHeader((HttpHeaders.IF_MODIFIED_SINCE));
        String fullPathNmae = getFullPathNmae(pathName);
        Path path = FileSystems.getDefault().getPath(fullPathNmae);
        Path sourceDirPath = FileSystems.getDefault().getPath(getFullPathNmae(source));
        if (path.getParent().compareTo(sourceDirPath) != 0) {
            log.info("文件路径不在source目录中，source dir:{} file path: {}", sourceDirPath, path);
            return responseEntity("file ");
        }
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            long lastModifiedTime = attributes.lastModifiedTime().toMillis();
            if (ifModifiedSince > 0 && lastModifiedTime <= ifModifiedSince) {
                return new ResponseEntity(HttpStatus.NOT_MODIFIED);
            }
            try (FileInputStream fileInputStream = new FileInputStream(fullPathNmae)) {
                byte[] bytes = IOUtils.toByteArray(fileInputStream);
                HttpHeaders headers = new HttpHeaders();
                headers.setLastModified(lastModifiedTime);
                headers.setContentLength(bytes.length);
                return new ResponseEntity(bytes, headers, HttpStatus.OK);
            }
        } catch (FileNotFoundException | AccessDeniedException | NoSuchFileException e) {
            log.warn("file  path = " + fullPathNmae, e);
            return responseEntity(fail("文件不存在"));
        } catch (IOException e) {
            log.error("read file failed: " + fullPathNmae, e);
            throw new RuntimeException(e);
        }
    }


    private String buildPathName(String source, String fileName) {
        return source + "/" + fileName;
    }

    private String getFullPathNmae(String filePath) {
        return baseFolder + File.separator + filePath;
    }

    @Data
    private static class UploadResp {
        private final String URI;
    }

}
