import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/14 15:23
 */

public class MyTest {
    @Test
    public void test1() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);
        System.out.println(System.currentTimeMillis());
    }
}
