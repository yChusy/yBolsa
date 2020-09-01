# yBolsa

## Config
```
Bolsa:
   Min: 70
   Max: 150
   Delay: 30 #em segundos
   
Mensagens:
   Valorizou:
    - ''
    - '&aA bolsa de valores subiu! :d'
    - '&eValor antigo: &c{antigo}'
    - '&eValor atual: &a{novo}'
    - ''
   Desvalorizou:
    - ''
    - '&aA bolsa de valores desceu! :c'
    - '&eValor antigo: &a{antigo}'
    - '&eValor atual: &c{novo}'
    - ''
```

## Placeholders
- ```%ybolsa_bolsa%``` - Mostra o valor atual da bolsa.

## API
### Gerir o valor da bolsa.
```int valor = yBolsaAPI.ybolsa.getBolsaValor();```
