package mobileapps.cse5236.cubr;

/**
 * Created by Joe on 3/31/2015.
 */
public class Timer {
    public long currentTime;
    public long elapsedTime;
    private boolean timerOn;

    public Timer () {
        currentTime = 0;
        elapsedTime = 0;
        timerOn = false;
    }

    public void start() {
        currentTime = System.currentTimeMillis();
        timerOn = true;
    }

    public void stop() {
        timerOn = false;
    }

    public boolean update() {
        if(timerOn) {
            elapsedTime += (System.currentTimeMillis() - currentTime);
            currentTime = System.currentTimeMillis();
        }

        return timerOn;
    }

    public String toString() {
        this.update();
        String returnString;
        int hour, minute, second, millisecond;
        long remainder = elapsedTime;

        hour = (int)(remainder / 3600000);
        remainder = remainder % 3600000;

        minute = (int)(remainder / 60000);
        remainder = remainder % 60000;

        second = (int)(remainder / 1000);
        remainder = remainder % 1000;

        returnString = String.format("%02d:%02d:%02d.%d", hour, minute, second, (int) (remainder/100));

        return returnString;
    }
}
