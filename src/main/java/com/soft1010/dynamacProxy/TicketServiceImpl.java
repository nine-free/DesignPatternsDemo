package com.soft1010.dynamacProxy;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 15:07
 * @Description:
 */
public class TicketServiceImpl implements TicketService {

    @Override
    public Ticket sellTicket(String IDCard, BigDecimal money) {
        Ticket ticket = new Ticket();
        ticket.setTicketNo(new Random().nextInt(10000) + "");
        ticket.setIDCard(IDCard);
        ticket.setMoney(money);
        return ticket;
    }
}
