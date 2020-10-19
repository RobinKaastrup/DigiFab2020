

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  int pot1 = analogRead(A0);
  int pot2 = analogRead(A1);

  Serial.write(map(pot1, 0, 1023, 0, 255));
  Serial.write(map(pot2, 0, 1023, 0, 255));
  delay(10);
}
