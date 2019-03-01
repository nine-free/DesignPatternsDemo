package com.soft1010.designpatterns.proxy.staticProxy;

import java.math.BigDecimal;

/**
 * Created by bjzhangjifu on 2019/3/1.
 */
public class HuangNiuUserProxy implements UserService{

    private UserService userService;

    public HuangNiuUserProxy(UserService userService) {
        this.userService = userService;
    }

    public Ticket buyTicket(User user, BigDecimal price) {
        System.out.println("熬夜排队.....");
        Ticket ticket = userService.buyTicket(user, price);
        BigDecimal fee = new BigDecimal(100);
        ticket.setPrice(ticket.getPrice().add(fee));
        System.out.println("在原有费用基础上添加手续费" + fee.doubleValue() + "  总共花费" + ticket.getPrice().doubleValue());
        return ticket;
    }
}
