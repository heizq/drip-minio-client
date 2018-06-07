package com.baiter.test.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by lenovo on 2018/2/2.
 */
public class MaintainSign implements Serializable {

    private String id;

    private String lastMaintainDate;

    private String maintainDate;

    private String elevId;

    private String useRegCode;

    private String maintainUser;

    private String roomImg;

    private String wellholeImg;

    private String carImg;

    private String pitImg;

    private String maintainCoordinate;

    private String sign;

    private String distance;

    public MaintainSign() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastMaintainDate() {
        return lastMaintainDate;
    }

    public void setLastMaintainDate(String lastMaintainDate) {
        this.lastMaintainDate = lastMaintainDate;
    }

    public String getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(String maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getElevId() {
        return elevId;
    }

    public void setElevId(String elevId) {
        this.elevId = elevId;
    }

    public String getUseRegCode() {
        return useRegCode;
    }

    public void setUseRegCode(String useRegCode) {
        this.useRegCode = useRegCode;
    }

    public String getMaintainUser() {
        return maintainUser;
    }

    public void setMaintainUser(String maintainUser) {
        this.maintainUser = maintainUser;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public String getWellholeImg() {
        return wellholeImg;
    }

    public void setWellholeImg(String wellholeImg) {
        this.wellholeImg = wellholeImg;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getPitImg() {
        return pitImg;
    }

    public void setPitImg(String pitImg) {
        this.pitImg = pitImg;
    }

    public String getMaintainCoordinate() {
        return maintainCoordinate;
    }

    public void setMaintainCoordinate(String maintainCoordinate) {
        this.maintainCoordinate = maintainCoordinate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


}
