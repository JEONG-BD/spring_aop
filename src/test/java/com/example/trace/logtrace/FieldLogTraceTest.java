package com.example.trace.logtrace;

import com.example.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldLogTraceTest {
    FieldLogTrace trace = new FieldLogTrace();

    @Test
    public void begin_end_level2(){
        //given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.end(status2);
        trace.end(status1);
        //when
        //thenp
    }

    @Test
    public void begin_exception_level2(){
        //given
        //given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        //when
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());

        //then
    }
}