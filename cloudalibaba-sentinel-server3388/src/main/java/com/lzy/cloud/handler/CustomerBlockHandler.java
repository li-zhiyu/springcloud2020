package com.lzy.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author:lizhiyu
 * @Date:2020-06-11 下午 5:05
 */
public class CustomerBlockHandler {
    public static String handlerException(BlockException excp){
        return "自定义Handler";
    }
}
