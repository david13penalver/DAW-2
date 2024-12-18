#!/usr/bin/env bash

pwd

source ./entornos/develop.env

echo $USER_NAME

ssh ${USER_NAME}@$IP_SERVER "cd /home/${USER_NAME}/davidpn_deploy"

ssh ${USER_NAME}@$IP_SERVER "git clone https://github.com/shengye472/DAWEjercicio.git"

ssh ${USER_NAME}@$IP_SERVER "cd mi-proyecto"

ssh ${USER_NAME}@$IP_SERVER "git fetch --prune"

ssh ${USER_NAME}@$IP_SERVER "git switch develop & git merge"

ssh ${USER_NAME}@$IP_SERVER "mvn clean install"

ssh ${USER_NAME}@$IP_SERVER "export JAVA_HOME=$(pwd)/jdk-21.0.5+11 && $JAVA_HOME/bin/java -D server.port=${APP_PORT} -jar facturas.jar"

sleep 1
echo "Ejecutando desplegamiento"
echo "."
sleep 1
echo "Deploy realizado."
