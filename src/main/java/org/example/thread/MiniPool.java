package org.example.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class MiniPool {
    private final ArrayBlockingQueue<Task> tasks;

    private final List<WorkThread> workThreads;

    public MiniPool(int count) {
        tasks = new ArrayBlockingQueue<>(count * 3);
        workThreads = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            WorkThread innerThread = new WorkThread("工作线程" + i, tasks);
            workThreads.add(innerThread);
            innerThread.start();
        }
        System.out.println("MiniPool:预置线程" + count + " ok");
    }

    public void execute(Task task) {
        synchronized (tasks) {
            tasks.add(task);
        }
    }
}
