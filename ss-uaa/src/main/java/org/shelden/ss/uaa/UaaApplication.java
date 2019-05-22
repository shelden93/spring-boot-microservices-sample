package org.shelden.ss.uaa;

import org.shelden.ss.base.BaseApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{
                BaseApplication.class,
                UaaApplication.class
        }, args);
    }

}
