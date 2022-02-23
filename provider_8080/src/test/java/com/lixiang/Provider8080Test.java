package com.lixiang;

import static org.junit.Assert.assertTrue;

import com.lixiang.util.JsonWebTokenUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class Provider8080Test {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
//        System.out.println(JsonWebTokenUtils.createToken((long) 1001));

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()));

        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toEpochSecond(ZoneOffset.of("+8")));

        System.out.println(new Date(1645495031481L));

        System.out.println(LocalDateTime.now().with(LocalTime.MAX).toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.ofInstant(new Date(1645545599999L).toInstant(),ZoneOffset.systemDefault())));

    }
    @Test
    public void test1(){
        Calendar nowTime = Calendar.getInstance();
        System.out.println(nowTime.getTime());
        nowTime.add(Calendar.DATE,1);
        System.out.println(nowTime);
        Date expiresDate = nowTime.getTime();
        System.out.println(expiresDate);
    }

}
