package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Project Name:hibernate-cascade
 * File Name:RecordModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:过车记录
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "record", schema = "hibernate_cascade")
public class RecordModel {

    private String id;  //主键
    private String recordState;  //过车记录状态
    private List<SectionModel> sectionModels;  //阶段信息列表
    private CrossingModel crossingModel;  //道口

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
    @Column(name = "record_state")
    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<SectionModel> getSectionModels() {
        return sectionModels;
    }

    public void setSectionModels(List<SectionModel> sectionModels) {
        this.sectionModels = sectionModels;
    }

    @ManyToOne
    @JoinColumn(name = "crossing_id", referencedColumnName = "id")
    public CrossingModel getCrossingModel() {
        return crossingModel;
    }

    public void setCrossingModel(CrossingModel crossingModel) {
        this.crossingModel = crossingModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordModel that = (RecordModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recordState != null ? !recordState.equals(that.recordState) : that.recordState != null) return false;
        if (sectionModels != null ? !sectionModels.equals(that.sectionModels) : that.sectionModels != null)
            return false;
        return crossingModel != null ? crossingModel.equals(that.crossingModel) : that.crossingModel == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recordState != null ? recordState.hashCode() : 0);
        result = 31 * result + (sectionModels != null ? sectionModels.hashCode() : 0);
        result = 31 * result + (crossingModel != null ? crossingModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecordModel{" +
                "id='" + id + '\'' +
                ", recordState='" + recordState + '\'' +
                ", sectionModels=" + sectionModels +
                ", crossingModel=" + crossingModel +
                '}';
    }
}
