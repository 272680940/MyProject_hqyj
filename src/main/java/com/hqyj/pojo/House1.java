package com.hqyj.pojo;

public class House1  extends  Page{
    private Integer hId;

    private String hName;

    private Integer hAmount;

    private Double hPrice;

    private Integer floorId;

    private Integer hState;

    private Integer customerId;

    private String hInfo;

    private Floor1 floor;

    public Floor1 getFloor() {
        return floor;
    }

    public void setFloor(Floor1 floor) {
        this.floor = floor;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Integer gethAmount() {
        return hAmount;
    }

    public void sethAmount(Integer hAmount) {
        this.hAmount = hAmount;
    }

    public Double gethPrice() {
        return hPrice;
    }

    public void sethPrice(Double hPrice) {
        this.hPrice = hPrice;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer gethState() {
        return hState;
    }

    public void sethState(Integer hState) {
        this.hState = hState;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String gethInfo() {
        return hInfo;
    }

    public void sethInfo(String hInfo) {
        this.hInfo = hInfo;
    }

    @Override
    public String toString() {
        return "House1{" +
                "hId=" + hId +
                ", hName='" + hName + '\'' +
                ", hAmount=" + hAmount +
                ", hPrice=" + hPrice +
                ", floorId=" + floorId +
                ", hState=" + hState +
                ", customerId=" + customerId +
                ", hInfo='" + hInfo + '\'' +
                '}';
    }
}