package com.mk.onevone.entity;

import java.util.Date;

/**
 * @author 01436296
 */
public class WeddingGroup {
    private Integer id;

    private String name;

    private String photoUrl;

    private String introduction;

    private String type;

    private Integer status;

    private Date createTime;

    private String[] types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String[] getTypes() {
        if(type != null){
            return type.split(",");
        }
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }
}