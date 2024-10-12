import java.util.Random;

public class Multsynch {
    public static void main(String[] args) {
        RandomThread r = new RandomThread();
        r.start();
    }

    public static synchronized void print(String message) {
        System.out.println(message);
    }
}

class RandomThread extends Thread {
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int n = r.nextInt(100);
            if (n % 2 == 0) {
                new Even(n).start();
            } else {
                new Odd(n).start();
            }
        }
    }
}

class Even extends Thread {
    private int num;

    public Even(int num) {
        this.num = num;
    }

    public void run() {
        Multsynch.print("Square of " + num + " is " + (num * num));
    }
}

class Odd extends Thread {
    private int num;

    public Odd(int num) {
        this.num = num;
    }

    public void run() {
        Multsynch.print("Cube of " + num + " is " + (num * num * num));
    }
}
