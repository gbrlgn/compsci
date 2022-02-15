// Inclui a biblioteca do Servo.
#include <Servo.h>

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

// Declara um novo objeto Servo.
Servo servo_3;

void setup()
{
    // Conecta o Servo ao pino 3.
    servo_3.attach(3, 500, 2500);
}

void loop()
{
    // Declara uma variável para a distância em centímetros.
    int dist = 0.01723 * readUltrasonicDistance(2, 2);

    // Checa se o valor da sitância é menor
    // ou igual a 20 centímetros.
    if (dist <= 20) {

      // Fecha a porta usando o Servo.
      servo_3.write(90);

      // Aguarda por 30 segundos e abre a porta novamente.
      delay(30000);)
      servo_3.write(90);

    }
}