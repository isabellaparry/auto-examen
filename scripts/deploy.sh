#!/bin/bash

set -e

JAR="target/auto-examen-1.0-SNAPSHOT.jar"

STAGING="deploy/staging/app.jar"

BACKUP="deploy/backup/app.jar"

echo "Iniciando despliegue..."

if [ -f "$STAGING" ]; then

    echo "Respaldando version anterior..."

    cp "$STAGING" "$BACKUP"
fi

echo "Copiando nueva version..."

cp "$JAR" "$STAGING"

echo "Despliegue completado."