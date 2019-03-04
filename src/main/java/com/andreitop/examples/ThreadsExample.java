package com.andreitop.examples;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ThreadsExample {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread());

    Runnable runnable = () -> System.out.println("Runnable: " + Thread.currentThread() + " " + Thread.currentThread().getId());
    Thread thread1 = new Thread(runnable);
    thread1.start();

    TestThread testThread = new TestThread();
    testThread.setName("main");
    testThread.start();
  }


  private static void showDump() throws InterruptedException {
    System.out.println(Thread.currentThread());
    int[][] array = new int[10000][];

    for (int i = 0; i < array.length; i++) {
      array[i] = new int[100000];
      array[i][0]++;
      TimeUnit.MILLISECONDS.sleep(30);
    }
    System.out.println(Arrays.deepToString(array));
  }

}

class TestThread extends Thread {

  @Override
  public void run() {
    System.out.println("Extends thread: " + Thread.currentThread());
  }
}
