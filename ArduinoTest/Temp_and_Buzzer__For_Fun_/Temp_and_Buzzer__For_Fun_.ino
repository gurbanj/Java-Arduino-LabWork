#include "DHT.h"
#include <Arduino.h>
#include <U8x8lib.h>

#define DHTPIN 3   //DHT sensor pin
#define DHTTYPE DHT11 //DHT Temp sensor
DHT dht(DHTPIN, DHTTYPE);

int ledPin = 4; //LED pin number
int buzzerPin = 5; //buzzer pin number 
int potPin = A0; //potentiometer pin number

U8X8_SSD1306_128x64_ALT0_HW_I2C_u8x8(/* reset=*/ U8X8_PIN_NONE); //object to control OLED

int setPoint = 0;
int alertRange = 5;
int alarmRange = 0;

void setup() {
  // put your setup code here, to run once:
pinMode(ledPin, OUTPUT);
pinMode(potPin, INPUT);
pinMode(buzzerPin, OUTPUT);
dht.begin();                    //DHT sensor
u8x8.begin();                   //OLED sensor
u8x8.setPowerSave(0);
u8x8.setFlipMode(1);

}

void loop() {
  // put your main code here, to run repeatedly:
float temp, hum;
temp = dht.readTemperature(); //read the teamp
hum = dht.readHumidity();
setPoint = map(analogRead(potPin),0,1023,0,50); //scaling to a temp range

if(temp >= setPoint+alertRange || temp <= setPoint-alertRange) {
  digitalWrite(ledPin, HIGH);
}
else {
  digitalWrite(ledPin, LOW);
}
if(temp >= setPoint+alarmRange || temp <= setPoint-alarmRange) {
  analogWrite(buzzerPin, 150);
}
else {
  analogWrite(buzzerPin, 0);
}

u8x8.setFont(u8x8_font_chroma48medium8_r);
u8x8.serCursor(0,33);
u8x8.print("T: ");
u8x8.print(int(temp));
u8x8.print("C ");
u8x8.print("H: ");
u8x8.print(int(hum));
u8x8.print("%");
u8x8.setCursor(0,50);
u8x8.print("T Set: ");
u8x8.print(setPoint);
u8x8 print("C");
u8x8.refreshDisplay();

delay(200);
}
