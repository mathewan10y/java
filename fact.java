import java.util.Random;

class FactorialRunnable implements Runnable {
    private int number;

    public FactorialRunnable(int number) {
        this.number = number;
        Thread t = new Thread(this); // Create a new thread with this Runnable
        t.start(); // Start the thread
        try {
            t.join(); // Ensure the main thread waits for this thread to complete
        } catch (InterruptedException e) {
            System.out.println("Factorial calculation interrupted.");
        }
    }

    @Override
    public void run() {
        try {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
                Thread.sleep(500); // Pause for 0.5 seconds between calculations
            }
            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (InterruptedException e) {
            System.out.println("Factorial calculation interrupted.");
        }
    }
}

class SumRunnable implements Runnable {
    private int number;

    public SumRunnable(int number) {
        this.number = number;
        Thread t = new Thread(this); // Create a new thread with this Runnable
        t.start(); // Start the thread
        try {
            t.join(); // Ensure the main thread waits for this thread to complete
        } catch (InterruptedException e) {
            System.out.println("Sum calculation interrupted.");
        }
    }

    @Override
    public void run() {
        try {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
                Thread.sleep(500); // Pause for 0.5 seconds between additions
            }
            System.out.println("Sum of numbers from 1 to " + number + " is: " + sum);
        } catch (InterruptedException e) {
            System.out.println("Sum calculation interrupted.");
        }
    }
}

public class fact {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10) + 1; // Generates a random number between 1 and 10
        System.out.println("Generated Number: " + number);

        if (number % 2 == 0) {
            new FactorialRunnable(number); // This starts the thread and ensures completion with join
        } else {
            new SumRunnable(number); // This starts the thread and ensures completion with join
        }

        System.out.println("Main thread finished execution.");
    }
}
