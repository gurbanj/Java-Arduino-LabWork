#include  <Arduino.h>

void setup() {
  pinMode(DD6, INPUT);
  Serial.begin(9600);

}

void loop() {
  if(digitalRead(DD6) == HIGH) {
    Serial.write("Button !\n");    //  button  was  pressed
    delay (400); //  debouncing , long  presses.
  }
  else { 
    //  nothing
  }
  
  if (!Serial.available ()) { 
    return;
  }
}
