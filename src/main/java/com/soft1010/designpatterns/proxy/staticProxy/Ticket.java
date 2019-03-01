package com.soft1010.designpatterns.proxy.staticProxy;

import java.math.BigDecimal;

/**
 * Created by bjzhangjifu on 2019/3/1.
 */
public class Ticket {

    private String userId;//用户姓名
    private String userName;//用户名字
    private String location; //座位
    private BigDecimal price;//价格

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }
}
