package com.github.trepang.generated.model;

import java.util.Date;

public class Talk {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.id
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.author
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.last_update_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private Date lastUpdateAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.updated_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private Date updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.created_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column talks.talk
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    private String talk;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.id
     *
     * @return the value of talks.id
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.id
     *
     * @param id the value for talks.id
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.author
     *
     * @return the value of talks.author
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.author
     *
     * @param author the value for talks.author
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.last_update_at
     *
     * @return the value of talks.last_update_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.last_update_at
     *
     * @param lastUpdateAt the value for talks.last_update_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.updated_at
     *
     * @return the value of talks.updated_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.updated_at
     *
     * @param updatedAt the value for talks.updated_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.created_at
     *
     * @return the value of talks.created_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.created_at
     *
     * @param createdAt the value for talks.created_at
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column talks.talk
     *
     * @return the value of talks.talk
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public String getTalk() {
        return talk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column talks.talk
     *
     * @param talk the value for talks.talk
     *
     * @mbg.generated Sun Jul 08 18:56:41 CST 2018
     */
    public void setTalk(String talk) {
        this.talk = talk == null ? null : talk.trim();
    }
}