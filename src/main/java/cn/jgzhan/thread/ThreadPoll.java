package cn.jgzhan.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoll {


  public static ThreadPoolExecutor getThreadPool() {

    //获取系统可用核心数
    int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
    var poolExecutor = new ThreadPoolExecutor(availableProcessors,
        availableProcessors,
        10000,
        TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<>(100),
        new AbortPolicy());

    return poolExecutor;
  }

}
