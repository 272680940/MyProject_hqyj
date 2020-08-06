package com.hqyj.pojo;

import java.util.Date;

public class Enter1 extends Page{
    private Integer eId;

    private Integer houseId;

    private Integer customerId;

    private String customerInfo;

    private Date startTime;

    private Date endTimeEstimate;

    private Date endTimeActual;

    private Integer orderCustomerId;

    private Double feeTotal;

    private Integer userId;

    private Integer eState;

    private Double ePrice;

    private Customer1 customer;

    private User1 user;

    private House1 house;

    public Customer1 getCustomer() {
        return customer;
    }

    public void setCustomer(Customer1 customer) {
        this.customer = customer;
    }

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public House1 getHouse() {
        return house;
    }

    public void setHouse(House1 house) {
        this.house = house;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTimeEstimate() {
        return endTimeEstimate;
    }

    public void setEndTimeEstimate(Date endTimeEstimate) {
        this.endTimeEstimate = endTimeEstimate;
    }

    public Date getEndTimeActual() {
        return endTimeActual;
    }

    public void setEndTimeActual(Date endTimeActual) {
        this.endTimeActual = endTimeActual;
    }

    public Integer getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(Integer orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }

    public Double getFeeTotal() {
        return feeTotal;
    }

    public void setFeeTotal(Double feeTotal) {
        this.feeTotal = feeTotal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public Double getePrice() {
        return ePrice;
    }

    public void setePrice(Double ePrice) {
        this.ePrice = ePrice;
    }

    public Enter1() {
    }

    @Override
    public String toString() {
        return "Enter1{" +
                "eId=" + eId +
                ", houseId=" + houseId +
                ", customerId=" + customerId +
                ", customerInfo='" + customerInfo + '\'' +
                ", startTime=" + startTime +
                ", endTimeEstimate=" + endTimeEstimate +
                ", endTimeActual=" + endTimeActual +
                ", orderCustomerId=" + orderCustomerId +
                ", feeTotal=" + feeTotal +
                ", userId=" + userId +
                ", eState=" + eState +
                ", ePrice=" + ePrice +
                ", customer=" + customer +
                ", user=" + user +
                ", house=" + house +
                '}';
    }

    public Enter1(Integer eId, Integer houseId, Integer customerId, String customerInfo, Date startTime, Date endTimeEstimate, Date endTimeActual, Integer orderCustomerId, Double feeTotal, Integer userId, Integer eState, Double ePrice, Customer1 customer, User1 user, House1 house) {
        this.eId = eId;
        this.houseId = houseId;
        this.customerId = customerId;
        this.customerInfo = customerInfo;
        this.startTime = startTime;
        this.endTimeEstimate = endTimeEstimate;
        this.endTimeActual = endTimeActual;
        this.orderCustomerId = orderCustomerId;
        this.feeTotal = feeTotal;
        this.userId = userId;
        this.eState = eState;
        this.ePrice = ePrice;
        this.customer = customer;
        this.user = user;
        this.house = house;
    }
}