package com.soft1010.designpatterns.proxy.staticProxy;

import java.math.BigDecimal;

/**
 * Created by bjzhangjifu on 2019/3/1.
 */
public class Test {

    public static void main(String[] args) {
        User user = new User("123456", "三明");
        UserService userService = new UserServiceImpl();
        HuangNiuUserProxy huangNiuUserProxy = new HuangNiuUserProxy(userService);
        Ticket ticket = huangNiuUserProxy.buyTicket(user, new BigDecimal(234.0));
        System.out.println(ticket.toString());
    }
}
