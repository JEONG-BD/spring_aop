package com.example.app.v3;

import com.example.trace.TraceId;
import com.example.trace.TraceStatus;
import com.example.trace.hellotrace.HelloTraceV2;
import com.example.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3{

    private final LogTrace trace;

    public void save(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            if(itemId.equals("ex")){
                throw new IllegalStateException("Exception 발생");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw  e;
        }
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
