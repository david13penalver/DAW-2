#!/usr/bin/env bash

pwd

source ./entornos/develop.env

echo $USER_NAME

cd ..

rm -r -f Facturas

git clone https://github.com/shengye472/Facturas.git

cd Facturas

git switch develop

mvn clean install

scp target/*.jar ${USER_NAME}@${IP_SERVER}:/home/${USER_NAME}/davidpn_deploy

ssh ${USER_NAME}@$IP_SERVER "cd /home/${USER_NAME}/davidpn_deploy"

echo "Antes java -jar"

# ssh ${USER_NAME}@$IP_SERVER "export JAVA_HOME=$(pwd)/jdk-21.0.5+11 && $JAVA_HOME/bin/java -D server.port=${APP_PORT} -jar *.jar"

ssh ${USER_NAME}@$IP_SERVER "jdk-21.0.5+11/bin/java -D server.port=${APP_PORT} -jar *.jar"

echo "Después java -jar"

sleep 1
echo "Ejecutando desplegamiento"
echo "."
sleep 1
echo "Deploy realizado."
