package gurb2k.yorku;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownHandler extends TimerTask {
    private byte n;
    private final OutputStream outputStream;
    private final Timer timer;
    public CountdownHandler(byte timerDuration, Timer timer, OutputStream outputStream) {
        this.n = timerDuration;
        this.outputStream = outputStream;
        this.timer = timer;
    }
    @Override
    public void run() {
        try {
            if(this.n > 0) {
                this.outputStream.write(this.n);
                this.n = (byte)(this.n-1);
            }
            else {
                this.outputStream.write(-1);
                this.timer.cancel();
            }
        }
        catch(IOException e) {
            System.out.println("Problem inside the countdownHandler run method");
            e.printStackTrace();
        }
    }
}
