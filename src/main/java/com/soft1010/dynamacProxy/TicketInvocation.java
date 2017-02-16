package com.soft1010.dynamacProxy;

import java.math.BigDecimal;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 16:13
 * @Description:
 */
public class TicketInvocation {

    private String IDCard;
    private BigDecimal money;

    public TicketInvocation(String IDCard, BigDecimal money) {
        this.IDCard = IDCard;
        this.money = money;
    }

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
}
