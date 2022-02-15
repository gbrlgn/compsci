// Incluir biblioteca LCD
#include <LiquidCrystal.h>

// Instanciar objeto com pinos necessários
LiquidCrystal lcd(9, 8, 7, 6, 5, 4);

void setup()
{
  // Inicializar serial
  Serial.begin(9600);
  Serial.println("Teste");
  // Inicializar tela LCD
  lcd.begin(16, 2);
  lcd.print("Teste");
}

void loop()
{
  // Criar variável a partir da leitura do pino
  // analógico A0, convertendo-a para graus
  // Celsius com as operações necessárias
  int celsius = round(
    ((analogRead(A0) * 0.00488) - 0.5) * 100
  );

  // Imprimir na primeira linha da tela
  lcd.setCursor(0, 0);
  lcd.print("Temperatura:");
  // Imprimir na segunda linha da tela
  lcd.setCursor(0, 1);
  lcd.print(celsius);
  lcd.print(" graus Celsius");
  // Atualizar a tela LCD com nova leitura
  Serial.println(celsius);
  delay(1000);
  lcd.clear();
}