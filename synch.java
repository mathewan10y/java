public class synch {
    public static void main(String args[]) {

        Display d = new Display();
        Synceg t1 = new Synceg(d, "hello");

        Synceg t2 = new Synceg(d, "World");

        t1.start();
        t2.start();
    }

}

class Display {
    public synchronized void println(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("]");
    }
}

class Synceg extends Thread {
    private Display d;
    private String msg;

    public Synceg(Display d, String msg) {
        this.d = d;
        this.msg = msg;
    }

    public void run() {
        d.println(msg);

    }
}