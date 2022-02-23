import com.lixiang.enums.TestEnum;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/17 9:08
 */
public class Test1 {

    @Test
    public void test1() {
        System.out.println(0 / 1);

        long l = System.currentTimeMillis();
        l -= 1000 * 60 * 60 * 24;
        System.out.println(new Date(l));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        Date date = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24));
        Date startOfDay = getStartOfDay(date);

        System.out.println(sdf.format(startOfDay));


        Date date1 = new Date();
        date1.setYear(122);
        date1.setMonth(Calendar.FEBRUARY);
        date1.setDate(17);

        System.out.println(sdf.format(date1));
        System.out.println(getEndOfDay(date1).getTime() + "_________________" + getStartOfDay(date1).getTime());

        System.out.println(sdf.format(new Date(getStartOfDay(date1).getTime())));


        System.out.println(System.currentTimeMillis());


        System.out.println(Math.round(3.0/4));


        System.out.println((double) 7.11/20);
        System.out.println(3.0000/ 10);
        System.out.println("Math.round(5 * 1.0 / 20*100*100)/100 = " + (Math.round(1.0 * 3 / 10 * 100.0*100)));


        System.out.println((double)23453/10000);
        System.out.println(922222222);


        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(decimalFormat.format(98924*1.0/10000));
        System.out.println("98974*1.0/10000 = " + 98974f / 10000f);


        System.out.println(System.currentTimeMillis());


    }

    public Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }


    public Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

}
