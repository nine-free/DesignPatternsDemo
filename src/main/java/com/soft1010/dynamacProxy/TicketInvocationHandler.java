package com.soft1010.dynamacProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 15:11
 * @Description:
 */
public class TicketInvocationHandler implements InvocationHandler {

    private TicketService ticketService;
    private TicketValidator ticketValidator;
    private FeeHandler feeHandler;

    public TicketInvocationHandler(TicketService ticketService,TicketValidator ticketValidator,FeeHandler feeHandler) {
        this.ticketService = ticketService;
        this.ticketValidator = ticketValidator;
        this.feeHandler = feeHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TicketInvocation ticketInvocation = new TicketInvocation((String)args[0],(BigDecimal) args[1]);
        if(!ticketValidator.validate(ticketInvocation)){
            return null;
        }
        Ticket ticket = (Ticket) method.invoke(ticketService,args);
        feeHandler.handle(ticket);
        return ticket;
    }
}
