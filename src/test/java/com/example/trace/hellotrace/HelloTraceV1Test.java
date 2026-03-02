package com.example.trace.hellotrace;

import com.example.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    public void begin_end (){
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    public void begin_exception(){
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        //when
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());

        //then
    }
}