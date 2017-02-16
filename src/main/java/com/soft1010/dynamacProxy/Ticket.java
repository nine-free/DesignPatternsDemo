package com.soft1010.dynamacProxy;

import java.math.BigDecimal;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 15:03
 * @Description:
 */
public class Ticket {

    private String IDCard;
    private BigDecimal money;
    private BigDecimal fee;
    private String ticketNo;

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "IDCard='" + IDCard + '\'' +
                ", money=" + money +
                ", fee=" + fee +
                ", ticketNo='" + ticketNo + '\'' +
                '}';
    }
}
