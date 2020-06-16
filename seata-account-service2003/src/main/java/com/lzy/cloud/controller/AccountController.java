package com.lzy.cloud.controller;

import com.lzy.cloud.entities.CommonResult;
import com.lzy.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 上午 9:34
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/decrease/account")
    public CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decreaseMoney(userId, Integer.parseInt(money.toString()));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"扣款成功");
    }
}
