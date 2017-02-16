package com.soft1010.filterChain;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 13:25
 * @Description:
 */
public class FilterChainTest {

    public static void main(String[] args){
        Filter filter1 = new TestFilter1();

        Filter filter2 = new TestFilter2();

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(filter1);
        filterChain.addFilter(filter2);
        Request request = new Request();
        request.setRequest("source");
        Response response = new Response();

        filterChain.doFilter(request,response);
        System.out.println(response.getResponse());
    }



}
