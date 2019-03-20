package com.flybd.hvideo;

import com.common.executor.AppExecutors;

public class AppExecutorManager {

    public static AppExecutors getInstance() {
        return Inner.sAppExecutors;
    }

    private static class Inner {
        private static AppExecutors sAppExecutors = new AppExecutors();
    }
}
