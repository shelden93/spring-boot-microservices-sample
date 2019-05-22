package org.shelden.ss.logs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shelden.ss.base.BaseApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles(profiles = "tests")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        BaseApplication.class,
        LogsApplication.class
})
public class LogsApplicationTests {

    @Test
    public void contextLoads() {
    }

}
