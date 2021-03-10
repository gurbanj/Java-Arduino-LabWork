import com.fazecast.jSerialComm.SerialPort;
import gurb2k.yorku.TimerScheduleHandler;

import java.io.IOException;
import java.util.Timer;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Main {
    public  static  void  main(String [] args) {
        long timeStart = System.currentTimeMillis();

        var sp = SerialPort.getCommPort("/dev/cu.usbserial-0001");
        sp.setComPortParameters (9600, Byte.SIZE , SerialPort.ONE_STOP_BIT , SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING , 0, 0);

        var  hasOpened = sp.openPort ();
        if (!hasOpened) {
            throw  new  IllegalStateException("Failed to open the serial/USB port.");
        }
        var  outputStream = sp.getOutputStream ();

        Runtime.getRuntime().addShutdownHook(new  Thread (()  -> {
            try {
                outputStream.close ();
            }
            catch(IOException e) {
                System.out.println("We had a problem shutting down the program.");
                e.printStackTrace ();
            }
            sp.closePort ();
        }));

        var timer = new Timer();
        var timedSchedule = new TimerScheduleHandler(timeStart, (byte) 10, timer, outputStream);

        sp.addDataListener(timedSchedule);

        System.out.println("Listen: " + timedSchedule.getListeningEvents());
        timer.schedule(timedSchedule, 0, 1000);
    }
}
