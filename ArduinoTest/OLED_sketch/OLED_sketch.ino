/*  ------------------------------------------------------
*   Grove_OLED_Example_Jan2021.ino  
*   Show  your  name  on  the display of  your  Grove board.
*   
*   Source: https://wiki.seeedstudio.com/Grove-Beginner-Kit-For-Arduino/
*   Source: video https://youtu.be/3-MUuKUelE0
    -------------------------------------------------------- */
//  Import  libraries
#include  <Arduino.h>
#include  <U8x8lib.h>           //  Follow  the video @ https://youtu.be/3-MUuKUelE0
//  (ugly)  Necessary function  call  for setting up  the display
U8X8_SSD1306_128X64_NONAME_HW_I2C u8x8(U8X8_PIN_NONE);
/*  -------------- Initialize the Grove board ------------- */
void  setup() {
    u8x8.begin();                 //  start up  the OLED  display
    u8x8.setFlipMode(1);    //  set to  1 or  0,  depending on  orientation of  board
}
/*  --------------- Run this  over  and over  ------------------- */
void  loop()  {
    //  Display your  name
    u8x8.setFont(u8x8_font_chroma48medium8_r);
    u8x8.setCursor(0, 0);
    u8x8.print("Gurban J.");
    delay(1000);        //  pause for 1000  ms.
    
    //  Display class name
    u8x8.setFont(u8x8_font_chroma48medium8_r);
    u8x8.setCursor(0, 10);
    u8x8.print("in  EECS  1021");
    delay(1000);        //  pause for 1000  ms.
    //  blank the screen.
    u8x8.clearDisplay();
    delay(1000);        //  pause for 1000  ms.
}
