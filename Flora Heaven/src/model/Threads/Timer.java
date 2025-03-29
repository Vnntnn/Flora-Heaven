package model.Threads;

public class Timer implements Runnable {
    private int sec = 54000;

    @Override
    public void run() {
        while (true) {
            if (sec == 0) {
                break;
            }
            sec--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}