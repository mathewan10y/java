
public class Prio {
    public static void main(String[] args) {
        PriorityThread lowPriorityThread = new PriorityThread("Low Priority Thread");
        PriorityThread normalPriorityThread = new PriorityThread("Normal Priority Thread");
        PriorityThread highPriorityThread = new PriorityThread("High Priority Thread");

        // Set priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // 1
        normalPriorityThread.setPriority(Thread.NORM_PRIORITY); // 5
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10

        // Start the threads
        lowPriorityThread.start();
        normalPriorityThread.start();
        highPriorityThread.start();
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // Displaying the initial priority of the thread
        System.out.println(getName() + " has priority: " + getPriority());

        // Simulate some work
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " is running with priority " + getPriority());
            try {
                Thread.sleep(100); // Sleep for a short time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
