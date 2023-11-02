package org.example.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MiniPool miniPool = new MiniPool(12);
        for (int i = 0; i < 30; i++) {
            Task runner = () -> {
                Random random = new Random();
                TimeUnit.MILLISECONDS.sleep(1000 + random.nextInt(3000));
            };
            miniPool.execute(runner);
        }
    }
}