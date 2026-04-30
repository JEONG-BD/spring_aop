package com.example.trace.template;

import com.example.trace.TraceStatus;
import com.example.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
        TraceStatus status = null;

        try{
            status = trace.begin(message);
            T result = call();
            return result;
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
