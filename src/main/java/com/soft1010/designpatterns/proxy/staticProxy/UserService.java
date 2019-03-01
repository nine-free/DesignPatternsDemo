package com.soft1010.designpatterns.proxy.staticProxy;

import java.math.BigDecimal;

/**
 * Created by bjzhangjifu on 2019/3/1.
 */
public interface UserService {

    Ticket buyTicket(User user, BigDecimal price);
}
