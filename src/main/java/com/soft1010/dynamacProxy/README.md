

#####动态代理
1、定义自己的服务Interface
```
public interface TicketService {

    public Ticket sellTicket(String IDCard, BigDecimal money);

}
```
2、定义服务实现
```
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
```
3、定义代理InvocationHandler implement InvocationHandler 
    此构造函数里注入需要的bean组件
```
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
```
4、调用客户端  如果是spring bean 建议实现FactoryBean 接口 getObject返回代理对象
```
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
```