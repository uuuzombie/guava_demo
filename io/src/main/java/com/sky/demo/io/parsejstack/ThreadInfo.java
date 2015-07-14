package com.sky.demo.io.parsejstack;

import com.google.common.base.Objects;

/**
 * Created by rg on 15/7/12.
 */
public class ThreadInfo {

    private String threadId;
    private String threadName;
    private String threadState;

    private ThreadInfo(String threadId, String threadName, String threadState) {
        this.threadId = threadId;
        this.threadName = threadName;
        this.threadState = threadState;
    }

    private static ThreadInfo instance;

    public static synchronized ThreadInfo getInstance(String threadId, String threadName, String threadState) {
        if (instance == null) {
            instance = new ThreadInfo(threadId,threadName,threadState);
        }
        return instance;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("threadId", threadId)
                .add("threadName", threadName)
                .add("threadState", threadState)
                .toString();
    }


}
