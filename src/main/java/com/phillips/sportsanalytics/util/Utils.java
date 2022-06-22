package com.phillips.sportsanalytics.util;

public class Utils {
    @FunctionalInterface public interface RunnableExc { void run() throws Exception; }
    public static void ignoringExc(RunnableExc r) {
        try { r.run(); } catch (Exception ignored) { }
    }
}
