package gurb2k.yorku;

import java.util.TimerTask;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduleHandler extends TimerTask implements SerialPortDataListener {

    private final long timeStart;
    private byte n;
    private final OutputStream outputStream;
    private final Timer timer;
    private byte timerDuration;
    // constructor

    public TimerScheduleHandler(long timeStart, byte timerDuration, Timer timer, OutputStream outputStream) {
        this.timeStart = timeStart;
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
            }
        }
        catch(IOException e) {
            System.out.println("Problem inside the countdownHandler run method");
            e.printStackTrace();
        }
    }

    @Override
    public int getListeningEvents() {
        System.out.println("rx!!");
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if(serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            System.out.println("Moisture Sensor is wet!!");
            this.n = timerDuration;
        }
    }
}
