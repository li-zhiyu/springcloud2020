package com.lzy.cloud.service.impl;

import com.lzy.cloud.dao.AccountDao;
import com.lzy.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:lizhiyu
 * @Date:2020-06-16 上午 9:44
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public int decreaseMoney(Long userId,Integer money) {
        log.info("扣款成功");
        return accountDao.decreaseMoney(userId,money);
    }
}
