package com.lixiang.service;
/*
@author GuoQiang
@create 2022-01-16 16:42
*/

import com.lixiang.entity.Payment;

public interface PaymentService {

    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}

