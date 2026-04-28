package com.example;

import com.example.trace.logtrace.FieldLogTrace;
import com.example.trace.logtrace.LogTrace;
import com.example.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
