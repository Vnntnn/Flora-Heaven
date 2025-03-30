package main.model.Threads;

public class Timer implements Runnable {
    private int sec;

    public Timer(int sec) {
        this.sec = sec;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

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