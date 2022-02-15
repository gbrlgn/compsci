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
    // Inicializa os pinos de saída RGB.
    pinMode(8, OUTPUT);
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
}

void loop()
{
    // Declara uma variável para a distância em centímetros.
    int dist = 0.01723 * readUltrasonicDistance(2, 2);

    if (dist < 30) {

        // Define o LED como vermelho caso a distância
        // seja menor que 30cm.
        digitalWrite(8, HIGH);

    } else if (dist > 30 && dist < 50) {

        // Define o LED como amarelo caso a distância
        // seja entre 30cm e 50cm.
        digitalWrite(8, HIGH);
        digitalWrite(9, HIGH);

    } else if (dist > 50 && dist < 100) {
    
        // Define o LED como verde caso a distância
        // seja entre 50cm e 100cm.
        digitalWrite(9, HIGH);

    } else if (dist > 100) {

        // Define o LED como azul caso a distância
        // seja maior que 100cm.
        digitalWrite(10, HIGH);
        
    } else {

        // Desliga o LED para qualquer outra distância.
        digitalWrite(8, LOW);
        digitalWrite(9, LOW);
        digitalWrite(10, LOW);

    }
    
    // Delay para ganhos de performance.
    delay(10);
}