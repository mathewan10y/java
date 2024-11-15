package lab;

import java.util.Random;

public class ex {
    public static void main(String[] args) {
        Rand rn = new Rand();
        try {
            rn.t.join(); // Wait for the random number generator thread to complete
        } catch (InterruptedException i) {
            System.out.println("Random thread interrupted");
        }
        int l = rn.a;

        Eveni e = new Eveni(l);
        Oddi o = new Oddi(l);

        try {

            if (e.t != null)
                e.t.join(); // Wait for even thread to complete
            if (o.t != null)
                o.t.join(); // Wait for odd thread to
        } catch (InterruptedException i) {

        }
        System.out.println("main thread terminated");
    }
}

class Rand implements Runnable {
    int a;
    Thread t;

    Rand() {
        t = new Thread(this);
        t.start();

    }

    public void run() {
        System.out.println("random thread started");

        Random r = new Random();
        a = r.nextInt(100);
        System.out.println("the random number is :" + a);
        try {
            Thread.sleep(100);

        } catch (InterruptedException ie) {
            System.out.println("caught");
        }
        System.out.println("random thread terminated");

    }

    public int getr() {
        return a;
    }

}

class Eveni implements Runnable {
    Thread t;
    int a;

    Eveni(int a) {
        this.a = a;

        t = new Thread(this);

        t.start();

    }

    public void run() {

        if (a % 2 == 0) {
            System.out.println("even thread started");

            for (int i = 0; i < a; i = i + 2) {
                System.out.println(i);
            }
            System.out.println("even thread terminated");

        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            System.out.println("caught");
        }
    }
}

class Oddi implements Runnable {
    Thread t;
    int a;

    Oddi(int a) {
        this.a = a;
        t = new Thread(this);

        t.start();

    }

    public void run() {

        if (a % 2 != 0) {
            System.out.println("odd thread started");

            for (int i = 1; i < a; i = i + 2) {
                System.out.println(i);
            }
            System.out.println("odd thread terminated");

        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            System.out.println("caught");
        }
    }

}
