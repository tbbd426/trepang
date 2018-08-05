package com.github.trepang.generated.mapper;

import com.github.trepang.generated.model.Talk;
import com.github.trepang.generated.model.TalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TalkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    long countByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    int deleteByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    int insert(Talk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    int insertSelective(Talk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    List<Talk> selectByExampleWithRowbounds(TalkExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    List<Talk> selectByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") Talk record, @Param("example") TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated Mon Aug 06 00:58:11 CST 2018
     */
    int updateByExample(@Param("record") Talk record, @Param("example") TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsert(Talk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertByExample(@Param("record") Talk record, @Param("example") TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertByExampleSelective(@Param("record") Talk record, @Param("example") TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talks
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertSelective(Talk record);
}