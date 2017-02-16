package com.soft1010.filterChain;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 11:22
 * @Description:
 */
public interface Filter {
    public void doFiler(Request request,Response response,FilterChain filterChain);
}
