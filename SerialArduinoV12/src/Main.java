import com.fazecast.jSerialComm.SerialPort;
import gurb2k.yorku.CountdownHandler;

import java.io.IOException;
import java.util.Timer;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Main {
    public  static  final  byte  TIMER_DURATION = 10;

    public  static  void  main(String [] args) {
        //name the serial port
        var sp = SerialPort.getCommPort("/dev/cu.usbserial-0001");

        //Serial 9600 bound
        sp.setComPortParameters (9600 ,  Byte.SIZE , SerialPort.ONE_STOP_BIT , SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING , 0, 0);

        /*We open  the  serial  port. If it fails , our  program  is in an  illegal  state , and we throw an  exception.*/
        var  hasOpened = sp.openPort ();
        if (!hasOpened) {
            throw  new  IllegalStateException("Failed to open the serial/USB port.");
        }
        var  outputStream = sp.getOutputStream ();

        /*When a program  ends , it is  important  to ‘close ‘ all  resources. Because  this  program only  terminates  manually,
        we add  this  code  which  executes  when  you  terminate  the program ,which  closes  the  output  stream  and the  serial  port.*/
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
        /*This  Timer  repeats  every  1000 ms, indefinitely. Here  lies  your  challenge: Replace  ‘null ‘ with a reasonable  parameter
        to get  your  code to  function  as  expected. Hint: create a class  which  extends  ‘TimerTask .*/
        var timer = new Timer();
        var countdown = new CountdownHandler(TIMER_DURATION, timer, outputStream);

        //run the scheduler as many times as requested
        timer.schedule(countdown, 0, 1000);
    }
}
