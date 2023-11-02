package org.example.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class WorkThread extends Thread {
    private int myTaskCount = 0;

    private final ArrayBlockingQueue<Task> tasks;

    private final String name;

    public WorkThread(String name, ArrayBlockingQueue<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + " 等待任务");
                Task runner = tasks.take();
                runner.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myTaskCount++;
            System.out.println(name + " 完成任务 " + myTaskCount);
        }
    }
}
