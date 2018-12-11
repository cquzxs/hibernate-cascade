package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Project Name:hibernate-cascade
 * File Name:CrossingModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:道口
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "crossing", schema = "hibernate_cascade")
public class CrossingModel {
    private String id;  //主键
    private String crossingName;  //道口名称
    private ParkModel parkModel;  //停车场


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
    @Column(name = "crossing_name")
    public String getCrossingName() {
        return crossingName;
    }

    public void setCrossingName(String crossingName) {
        this.crossingName = crossingName;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "park_id", referencedColumnName = "id")
    public ParkModel getParkModel() {
        return parkModel;
    }

    public void setParkModel(ParkModel parkModel) {
        this.parkModel = parkModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrossingModel that = (CrossingModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (crossingName != null ? !crossingName.equals(that.crossingName) : that.crossingName != null) return false;
        return parkModel != null ? parkModel.equals(that.parkModel) : that.parkModel == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (crossingName != null ? crossingName.hashCode() : 0);
        result = 31 * result + (parkModel != null ? parkModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CrossingModel{" +
                "id='" + id + '\'' +
                ", crossingName='" + crossingName + '\'' +
                ", parkModel=" + parkModel +
                '}';
    }
}
