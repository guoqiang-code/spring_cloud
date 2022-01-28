package com.lixiang.dao;

import com.lixiang.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/*
@author GuoQiang
@create 2022-01-16 16:43
*/

@Mapper
public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    List<Payment> findByAll(Payment payment);

    List<Payment> selectByAll(Payment payment);
}