# 💱 Conversor de Moedas em Java

Este é um projeto desenvolvido em **Java** que realiza conversões entre diferentes moedas utilizando a **API ExchangeRate**. A aplicação é executada no terminal e permite ao usuário escolher entre diferentes pares de moedas, digitando o valor que deseja converter.

## 🧠 Funcionalidades

- Conversão em tempo real com base em valores atualizados pela API ExchangeRate.
- Registro automático de cada conversão realizada.
- Registro de erros em log caso haja falha na comunicação com a API.
- Interface de linha de comando simples e interativa.

## 🔁 Moedas disponíveis

1. USD -> ARS (Dólar para Peso Argentino)  
2. ARS -> USD (Peso Argentino para Dólar)  
3. USD -> BRL (Dólar para Real Brasileiro)  
4. BRL -> USD (Real Brasileiro para Dólar)  
5. USD -> COP (Dólar para Peso Colombiano)  
6. COP -> USD (Peso Colombiano para Dólar)  

## 🛠️ Tecnologias utilizadas

- **Java 11+**
- **Gson** (para leitura e manipulação de JSON)
- **API ExchangeRate** ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/))
- Escrita de arquivos com `FileWriter`
- Tratamento de exceções
- Uso de datas e horas com `LocalDateTime`

