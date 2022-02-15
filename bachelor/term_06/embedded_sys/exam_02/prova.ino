// Incluir biblioteca para LCD.
#include <LiquidCrystal.h>

// Instanciar objeto com pinos necessários.
LiquidCrystal lcd(9, 8, 7, 6, 5, 4);

// Função para a leitura do sensor de distância.
long readUltrasonicDistance(int triggerPin, int echoPin)
{
    // Limpa o pino de gatilho.
    pinMode(triggerPin, OUTPUT);  
    digitalWrite(triggerPin, LOW);
    delayMicroseconds(2);

    // Arma o pino de gatilho como HIGH por 10 microssegundos.
    digitalWrite(triggerPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(triggerPin, LOW);
    pinMode(echoPin, INPUT);

    // Lê o pino de eco, retornando o tempo de viagem da onda
    // de som em microssegundos.
    return pulseIn(echoPin, HIGH);
}

void setup()
{
  // Inicializar serial.
  Serial.begin(9600);
  Serial.println("Teste");
  // Inicializar tela LCD.
  lcd.begin(16, 2);
  lcd.print("Teste");
}

void loop()
{
  // Cria variável para armazenar a distância lida em cm.
  int dist = 0.01723 * readUltrasonicDistance(3, 3);

  // Imprimir na primeira linha da tela.
  lcd.setCursor(0, 0);
  lcd.print("Dist.:");

  // Imprimir na segunda linha da tela.
  lcd.setCursor(0, 1);
  lcd.print(dist);
  lcd.print(" cm");

  // Atualizar a tela LCD com nova leitura.
  Serial.println(dist);
  delay(1000);
  lcd.clear();
}