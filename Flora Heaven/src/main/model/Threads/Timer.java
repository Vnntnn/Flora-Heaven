package main.model.Threads;

public class Timer extends Thread {
    private int sec;
    private boolean running;

    public Timer(int sec) {
        this.sec = sec;
        this.running = true;
    }

    public int getSec() {
        return sec;
    }

    public void stopTimer() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running && sec > 0) {
            try {
                Thread.sleep(1000);
                sec--;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isTimeUp() {
        return sec <= 0;
    }
}