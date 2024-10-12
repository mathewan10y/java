import java.util.Random;

public class multithread {
    public static void main(String args[]) {
        Randomthread r = new Randomthread();
        r.start();

    }

}

class Randomthread extends Thread {
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int n = r.nextInt(100);// gets value between 1 and 100
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
        System.out.println("square of " + num + " is " + num * num);
    }
}

class Odd extends Thread {
    private int num;

    public Odd(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("cube of " + num + " is " + num * num * num);
    }
}