package org.shelden.ss.logs;

import org.shelden.ss.base.BaseApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{
                BaseApplication.class,
                LogsApplication.class
        }, args);
    }

}
