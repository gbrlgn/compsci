void setup()
{
  // Inicializa os pinos.
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(A0, INPUT);
  pinMode(7, OUTPUT);
}

void loop()
{
  // Liga os LEDs do Arduino.
  digitalWrite(LED_BUILTIN, HIGH);
  delay(1000);
  digitalWrite(LED_BUILTIN, LOW);
  delay(1000);
  
  // Atribui o valor emitido pelo TMP36
  // à variável sensor.
  int sensor = analogRead(A0);
  
  // Cria uma variável de voltagem
  // dividindo-se o valor do sensor
  // por duas constantes.
  float volt = (sensor / 1023.0) * 5.0; 
  
  // Faz o mesmo para uma variável de
  // temperatura a partir da voltagem.
  float temp = (volt - 0.5) * 100;
  
  // Intervalo de ativação do botão.
  float min = 37.0;
  float max = 38.0;
  
  // Checagem da temperatura de entrada
  // contra o intervalo estipulado.
  if (temp > min && temp < max) {
    
    // Saída de energia para o botão.
    digitalWrite(7, HIGH);

  }
}