package com.lzy.cloud.service;

import com.lzy.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:lizhiyu
 * @Date:2020-06-15 下午 5:00
 */
@Service
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/decrease/account")
    CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
