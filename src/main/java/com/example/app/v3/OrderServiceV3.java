package com.example.app.v3;

import com.example.trace.TraceId;
import com.example.trace.TraceStatus;
import com.example.trace.hellotrace.HelloTraceV2;
import com.example.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.OrderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw  e;
        }
    }
}
