package multithread;

import java.util.Random;

public class Mult {

    public static void main(String[] args) {
        Display d = new Display();
        RandomThread r = new RandomThread(d);
        r.start();
    }
}

class RandomThread extends Thread {
    private Display display;

    public RandomThread(Display display) {
        this.display = display;
    }

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int n = r.nextInt(100);
            if (n % 2 == 0) {
                new Even(display, n).start();
            } else {
                new Odd(display, n).start();
            }
        }
    }
}

class Even extends Thread {
    private Display display;
    private int num;

    public Even(Display display, int num) {
        this.display = display;
        this.num = num;
    }

    public void run() {
        display.println("Square of " + num + " is " + (num * num));
    }
}

class Odd extends Thread {
    private Display display;
    private int num;

    public Odd(Display display, int num) {
        this.display = display;
        this.num = num;
    }

    public void run() {
        display.println("Cube of " + num + " is " + (num * num * num));
    }
}

class Display {
    public synchronized void println(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(100); // Simulate some processing delay
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("]");
    }
}
