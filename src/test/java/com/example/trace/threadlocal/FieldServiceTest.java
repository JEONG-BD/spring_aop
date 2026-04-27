package com.example.trace.threadlocal;

import com.example.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field(){
        log.info("main Start");
        Runnable userA = () ->{
            fieldService.login("userA");
        };

        Runnable userB = () ->{
            fieldService.login("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread B");

        threadA.start();
        //sleep(2000); // 동시성 문제 발생 X
        sleep(1000); // 동시성 문제 발생 X
        threadB.start();
        sleep(2000);
        log.info("main exit");

    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
