package com.example.app.v4;

import com.example.trace.TraceStatus;
import com.example.trace.logtrace.LogTrace;
import com.example.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4{

    private final LogTrace trace;

    public void save(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("Exception 발생");
                }
                sleep(1000);
                return null;
            }
        };
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
