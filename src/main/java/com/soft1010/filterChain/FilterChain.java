package com.soft1010.filterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangjifu
 * @Create time: 2016/9/23 11:23
 * @Description:
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    private int index = 0;

    public void doFilter(Request request,Response response){
        if(index>= filters.size()){
            return ;
        }
        Filter filter = filters.get(index++);
        filter.doFiler(request,response,this);
    }

}
