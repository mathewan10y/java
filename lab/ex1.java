package lab;

import java.util.Random;

public class ex1 {
    public static void main(String[] args) {
        Rand rn = new Rand(); // Start random number generator thread
        try {
            rn.t.join(); // Wait for the random number generator thread to complete
        } catch (InterruptedException i) {
            System.out.println("Random thread interrupted");
        }

        int l = rn.a; // Get the random number

        // Start even and odd threads
        Eveni e = new Eveni(l);
        Oddi o = new Oddi(l);

        try {
            if (e.t != null)
                e.t.join(); // Wait for even thread to complete
            if (o.t != null)
                o.t.join(); // Wait for odd thread to complete
        } catch (InterruptedException i) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread terminated");
    }
}

class Rand implements Runnable {
    int a;
    Thread t;

    Rand() {
        t = new Thread(this, "Random Thread");
        t.start();
    }

    public void run() {
        System.out.println("Random thread started");

        Random r = new Random();
        a = r.nextInt(100); // Generate random number between 0 and 99
        System.out.println("The random number is: " + a);

        try {
            Thread.sleep(100); // Pause to simulate computation
        } catch (InterruptedException ie) {
            System.out.println("Random thread interrupted");
        }

        System.out.println("Random thread terminated");
    }
}

class Eveni implements Runnable {
    Thread t;
    int a;

    Eveni(int a) {
        this.a = a;

        if (a % 2 == 0) { // Start thread only if the number is even
            t = new Thread(this, "Even Thread");
            t.start();
        } else {
            t = null; // Thread not needed if the number is odd
        }
    }

    public void run() {
        System.out.println("Even thread started");

        try {
            Thread.sleep(100); // Pause to simulate computation
            for (int i = 0; i <= a; i += 2) {
                System.out.println("Even: " + i);
            }
        } catch (InterruptedException ie) {
            System.out.println("Even thread interrupted");
        }

        System.out.println("Even thread terminated");
    }
}

class Oddi implements Runnable {
    Thread t;
    int a;

    Oddi(int a) {
        this.a = a;

        if (a % 2 != 0) { // Start thread only if the number is odd
            t = new Thread(this, "Odd Thread");
            t.start();
        } else {
            t = null; // Thread not needed if the number is even
        }
    }

    public void run() {
        System.out.println("Odd thread started");

        try {
            Thread.sleep(100); // Pause to simulate computation
            for (int i = 1; i <= a; i += 2) {
                System.out.println("Odd: " + i);
            }
        } catch (InterruptedException ie) {
            System.out.println("Odd thread interrupted");
        }

        System.out.println("Odd thread terminated");
    }
}
