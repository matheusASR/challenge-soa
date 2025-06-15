#!/bin/bash

echo "Iniciando o microserviço Spring Boot..."

# Navega até o diretório do microserviço
cd microservice-api

# Verifica se o Maven está instalado
if ! [ -x "$(command -v mvn)" ]; then
  echo 'Erro: Maven não está instalado. Instale com: sudo apt install maven' >&2
  exit 1
fi

# Compila e inicia a aplicação
mvn clean install
mvn spring-boot:run
