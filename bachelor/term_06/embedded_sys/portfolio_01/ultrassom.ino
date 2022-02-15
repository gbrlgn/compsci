#include <LiquidCrystal.h> // incluir a biblioteca LiquidCrystal

// criar um objeto LCD com os parâmetros (rs, enable, d4, d5, d6, d7)
LiquidCrystal lcd(1, 2, 4, 5, 6, 7);

const int trigPin = 9; // pino a ser usado pelo 'trigger' do sensor
const int echoPin = 10; // pino ser usado pelo 'echo' do sensor
long duration; 
int distanceCm, distanceInch; // variáveis usadas pelo display

void setup() {

    // inicializar a interface da tela LCD e 
    // especificar as dimensões do display
    lcd.begin(16,2); 
    pinMode(trigPin, OUTPUT);
    pinMode(echoPin, INPUT);

}

loop() {

    // processo de escrita dos pinos 
    // do sensor para o Arduino
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);

    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);

    digitalWrite(trigPin, LOW);

    // operação de cálculo da distância de acordo com o tempo
    // de eco do ultrassom do sensor, com constantes de acordo
    // com as medidas, neste caso centímetros e polegadas
    duration = pulseIn(echoPin, HIGH);
    distanceCm= duration*0.034/2;
    distanceInch = duration*0.0133/2;

    // processo de escrita no display
    lcd.setCursor(0,0); // coordenada de escrita do texto no display
    lcd.print("Distance: "); // imprimir palavra 'Distance" no display
    lcd.print(distanceCm); // imprimir valor da distância do sensor
    lcd.print(" cm"); // concatenar com 'cm'

    delay(10);

    // o mesmo se repete, desta vez para as polegadas
    lcd.setCursor(0,1); 
    lcd.print("Distance: ");
    lcd.print(distanceInch);
    lcd.print(" inch");

    delay(10);

}