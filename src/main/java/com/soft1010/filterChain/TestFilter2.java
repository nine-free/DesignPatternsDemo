package com.soft1010.filterChain;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 13:24
 * @Description:
 */
public class TestFilter2 implements Filter {

    @Override
    public void doFiler(Request request, Response response, FilterChain filterChain) {
        System.out.println("testFilter2------");
        response.setResponse(response.getResponse()+" | test2");
        filterChain.doFilter(request,response);
    }
}
