package com.soft1010.designpatterns.filterChain;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 13:22
 * @Description:
 */
public class TestFilter1 implements Filter {

    public void doFiler(Request request, Response response, FilterChain filterChain) {
        System.out.println("testFilter1---------");
        response.setResponse(response.getResponse()+" | test1");
        filterChain.doFilter(request,response);
    }
}
