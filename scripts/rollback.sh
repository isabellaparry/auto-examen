#!/bin/bash

set -e

STAGING="deploy/staging/app.jar"

BACKUP="deploy/backup/app.jar"

if [ -f "$BACKUP" ]; then

    echo "Ejecutando rollback..."

    cp "$BACKUP" "$STAGING"

    echo "Rollback completado."

else

    echo "No existe una version anterior."
fi