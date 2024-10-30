package my.uum;

import java.util.Scanner;

public class MyRunnable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input x: ");
        int x = scanner.nextInt();
        System.out.print("Please input y: ");
        int y = scanner.nextInt();

        Runnable oddRunnable = new OddRunnable(x, y);
        Runnable evenRunnable = new EvenRunnable(x, y);

        Thread oddThread = new Thread(oddRunnable);
        Thread evenThread = new Thread(evenRunnable);

        oddThread.start();
        evenThread.start();
    }
}

class OddRunnable implements Runnable {
    private final int x;
    private final int y;

    public OddRunnable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class EvenRunnable implements Runnable {
    private final int x;
    private final int y;

    public EvenRunnable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
