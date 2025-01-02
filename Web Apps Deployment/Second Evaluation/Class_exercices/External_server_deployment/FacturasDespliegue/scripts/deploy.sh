#!/usr/bin/env bash

source $1

cd ..

rm -r -f Facturas

git clone https://github.com/shengye472/Facturas.git

cd Facturas

git switch $BRANCH

mvn clean install

scp target/*.jar ${USER_NAME}@${IP_SERVER}:/home/${USER_NAME}/davidpn_deploy

# ssh ${USER_NAME}@$IP_SERVER "export JAVA_HOME=/home/${USER_NAME}/davidpn_deploy/jre21 && $JAVA_HOME/bin/java -D server.port=${APP_PORT} -jar *.jar"

echo "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"

# ssh ${USER_NAME}@$IP_SERVER "export JAVA_HOME=/home/alumno/davidpn_deploy && echo aaa'$JAVA_HOME'bbbbb && echo 'hola mundo'"

# ssh ${USER_NAME}@$IP_SERVER "/home/${USER_NAME}/davidpn_deploy/jre21/bin/java -jar /home/${USER_NAME}/davidpn_deploy/mi-proyecto-0.0.1-SNAPSHOT.jar" &

cd ../FacturasDespliegue/scripts

pwd

scp server.sh $USER_NAME@$IP_SERVER:/home/alumno/davidpn_deploy

ssh ${USER_NAME}@$IP_SERVER "./server.sh"

sleep 1
echo "Ejecutando despliegue"
echo "."
sleep 1
echo "Deploy realizado."
