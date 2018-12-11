package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Project Name:hibernate-cascade
 * File Name:CrossingStateModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:道口状态
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "crossing_state", schema = "hibernate_cascade")
public class CrossingStateModel {

    private String id;  //主键
    private String crossingState;  //道口状态
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
    @Column(name = "crossing_state")
    public String getCrossingState() {
        return crossingState;
    }

    public void setCrossingState(String crossingState) {
        this.crossingState = crossingState;
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

        CrossingStateModel that = (CrossingStateModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (crossingState != null ? !crossingState.equals(that.crossingState) : that.crossingState != null)
            return false;
        return crossingModel != null ? crossingModel.equals(that.crossingModel) : that.crossingModel == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (crossingState != null ? crossingState.hashCode() : 0);
        result = 31 * result + (crossingModel != null ? crossingModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CrossingStateModel{" +
                "id='" + id + '\'' +
                ", crossingState='" + crossingState + '\'' +
                ", crossingModel=" + crossingModel +
                '}';
    }
}
