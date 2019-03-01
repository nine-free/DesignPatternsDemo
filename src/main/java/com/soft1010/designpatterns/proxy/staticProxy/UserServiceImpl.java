package com.soft1010.designpatterns.proxy.staticProxy;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by bjzhangjifu on 2019/3/1.
 */
public class UserServiceImpl implements UserService {

    public Ticket buyTicket(User user, BigDecimal price) {
        System.out.println(user.getUserName() + "花费" + price.doubleValue() + "购买车票");
        Ticket ticket = new Ticket();
        ticket.setLocation("随机位置" + new Random(100).nextInt());
        ticket.setPrice(price);
        ticket.setUserId(user.getUserId());
        ticket.setUserName(user.getUserName());
        return ticket;
    }
}
