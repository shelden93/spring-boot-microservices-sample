package org.shelden.ss.uaa;

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
        UaaApplication.class
})
public class UaaApplicationTests {

    @Test
    public void contextLoads() {
    }

}
