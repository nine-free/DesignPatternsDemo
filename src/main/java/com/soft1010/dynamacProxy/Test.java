package com.soft1010.dynamacProxy;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 15:14
 * @Description:
 */
public class Test {

    public static void main(String[] args){

        TicketService ticketService = new TicketServiceImpl();
        TicketValidator ticketValidator = new TicketValidator() {
            @Override
            public boolean validate(TicketInvocation ticketInvocation) {
                return (ticketInvocation==null || ticketInvocation.getIDCard()==null ||
                        ticketInvocation.getMoney()==null)?false:true;
            }
        };

        FeeHandler feeHandler = new FeeHandler() {
            @Override
            public void handle(Ticket ticket) {
                if(ticket!=null){
                    ticket.setFee(new BigDecimal(10));
                }
            }
        };

        TicketInvocationHandler ticketInvocationHandler = new TicketInvocationHandler(ticketService,ticketValidator,feeHandler);
        TicketService ticketService1 = (TicketService) Proxy.newProxyInstance(
                ticketService.getClass().getClassLoader(),ticketService.getClass().getInterfaces(),ticketInvocationHandler) ;
        Ticket ticket = ticketService1.sellTicket("12345",new BigDecimal(1000));
        System.out.println(ticket.toString());
    }
}
