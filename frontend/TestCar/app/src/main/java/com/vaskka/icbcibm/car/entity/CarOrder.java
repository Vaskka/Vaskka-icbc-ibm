package com.vaskka.icbcibm.car.entity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CarOrder {

    // 订单id
    private String orderId;

    // 集合位置
    private String location;

    // 发起人姓名
    private String name;

    // 发车时间
    private Date startTime;

    // 等待时间
    private int waitTime;

    // 到达地点
    private String destination;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // 发起人联系方式
    private String tel;

    public int getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(int currentPeople) {
        this.currentPeople = currentPeople;
    }

    // 当前人数(默认为0)
    private int currentPeople = 0;

    public CarOrder(String orderId, String location, String name, Date startTime, int waitTime, String destination, String tel) {
        this.orderId = orderId;
        this.location = location;
        this.name = name;
        this.startTime = startTime;
        this.waitTime = waitTime;
        this.destination = destination;
        this.tel  = tel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime(String format) {
        return (new SimpleDateFormat(format).format(startTime));
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
