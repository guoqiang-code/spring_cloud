package com.lixiang;

import static org.junit.Assert.assertTrue;

import com.lixiang.util.JsonWebTokenUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(JsonWebTokenUtils.createToken((long) 1001));
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
