package com.soft1010.filterChain;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 13:22
 * @Description:
 */
public class TestFilter1 implements Filter {

    @Override
    public void doFiler(Request request, Response response, FilterChain filterChain) {
        System.out.println("testFilter1---------");
        response.setResponse(response.getResponse()+" | test1");
        filterChain.doFilter(request,response);
    }
}
