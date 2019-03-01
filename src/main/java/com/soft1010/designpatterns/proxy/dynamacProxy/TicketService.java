package com.soft1010.designpatterns.proxy.dynamacProxy;

import java.math.BigDecimal;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 15:06
 * @Description:
 */
public interface TicketService {

    public Ticket sellTicket(String IDCard, BigDecimal money);

}
