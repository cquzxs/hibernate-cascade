package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Project Name:hibernate-cascade
 * File Name:ParkModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:停车场
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "park", schema = "hibernate_cascade")
public class ParkModel {

    private String id;  //主键
    private String parkName;  //停车场名称

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
    @Column(name = "park_name")
    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkModel parkModel = (ParkModel) o;

        if (id != null ? !id.equals(parkModel.id) : parkModel.id != null) return false;
        return parkName != null ? parkName.equals(parkModel.parkName) : parkModel.parkName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parkName != null ? parkName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkModel{" +
                "id='" + id + '\'' +
                ", parkName='" + parkName + '\'' +
                '}';
    }
}
