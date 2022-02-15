# Explicação do projeto

## Arduino Ultrasonic Distance Sensor

O sensor utiliza o Arduino como base e tem por objetivo detectar a distância de um objeto que entre no raio de detecção por meio de um sensor de ultrassom, e logo após reportar tal distância ao Arduino, que em seguida processa os dados obtidos pelo sensor de modo a calcular a distância do objeto, em centímetros e polegadas, de acordo com o valor de tempo obtido pelo sensor, a partir da diferença entre o tempo de emissão da onda de ultrassom pelo sensor e o tempo de retorno do seu eco, possibilitando que a distância do objeto detectado seja determinada.

Após o cálculo, o Arduino envia os dados processados a um display LCD, que, a partir de um objeto de LCD criado pela biblioteca LiquidCrystal, pode ser operado e receber os dados da distância enviados pelo Arduino e expô-los na tela, mostrando a distância do objeto detectado em centímetros e polegadas. A detecção acontece em pequenos intervalos de milissegundos, uma vez que há métodos delay no loop de execução, assim como a exposição dos dados na tela.