//  Import  libraries
#include  <Arduino.h>
#include  <U8x8lib.h>

//  Creates  an  instance  of the ‘U8X8_SSD1306_128X64_NONAME_HW_I2C ‘ class
auto  display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);

int n = 10;
int  myIntArray [10] = {0,1,2,3,4,5,6,7,8,9};

/*  -------------- Initialize  the  Grove  board  ------------- */
void setup() {
  pinMode(DD4, OUTPUT);     // Sets  the D4 pin (LED) to  output
  
  Serial.begin(9600);       //  Enables  serial  communication
  display.begin();          // start up the  OLED  display
  display.setFlipMode(1);   // set to 1 or 0, depending  on  orientation  of  board
  display.clearDisplay();
}

/*  --------------- Run  this  over  and  over  ------------------- */
void loop() {
// Set up a countdown  on the  OLED
  display.setFont(u8x8_font_profont29_2x3_r);
  display.setCursor (0, 0);
  if(n>=0) {
    display.print(myIntArray[n]);
    n=n-1;
  }
  else {
    n=10;
  }
  if(n==10) { // start again
    digitalWrite(DD4, HIGH);
    delay(1000000000);
  }
  delay(1000);
}
