package com.hirain.pojo;

import java.util.Date;

public class User {
    private Long id;

    private String username;

    private String password;

    private String token;

    private Date createtime;

    private Long addPerson;

    private Date updateTime;

    private Long updatePerson;

    private String locked;

    private String credentialsalt;

    private String deletestatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getAddPerson() {
        return addPerson;
    }

    public void setAddPerson(Long addPerson) {
        this.addPerson = addPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Long updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }

    public String getCredentialsalt() {
        return credentialsalt;
    }

    public void setCredentialsalt(String credentialsalt) {
        this.credentialsalt = credentialsalt == null ? null : credentialsalt.trim();
    }

    public String getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(String deletestatus) {
        this.deletestatus = deletestatus == null ? null : deletestatus.trim();
    }
}