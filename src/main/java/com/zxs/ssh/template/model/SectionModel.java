package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Project Name:hibernate-cascade
 * File Name:SectionModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:阶段信息
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "section", schema = "hibernate_cascade")
public class SectionModel {
    private String id;  //主键
    private String sectionName;  //阶段名称
    private String sectionState;  //阶段状态

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "section_name")
    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Basic
    @Column(name = "section_state")
    public String getSectionState() {
        return sectionState;
    }

    public void setSectionState(String sectionState) {
        this.sectionState = sectionState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionModel that = (SectionModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sectionName != null ? !sectionName.equals(that.sectionName) : that.sectionName != null) return false;
        return sectionState != null ? sectionState.equals(that.sectionState) : that.sectionState == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sectionName != null ? sectionName.hashCode() : 0);
        result = 31 * result + (sectionState != null ? sectionState.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SectionModel{" +
                "id='" + id + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", sectionState='" + sectionState + '\'' +
                '}';
    }
}
