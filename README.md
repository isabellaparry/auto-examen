# Automatización de Pruebas - Examen Final - Isabella Parry

## Descripción

Proyecto desarrollado para aplicar control de versiones,
automatización de pruebas, integración continua y despliegue automatizado.

## Tecnologías

- Java 17
- Maven
- JUnit 5
- H2
- Git
- GitHub
- GitHub Actions
- Visual Studio Code

## Estrategia de ramas

Se utilizó Trunk-Based simplificado.

La rama `main` mantiene el código estable y los cambios
se desarrollan mediante ramas de corta duración.

El pipeline ejecuta:

1. Build.
2. Unit Tests.
3. Integration Tests.

Para ejecutar todas las pruebas localmente:

```bash
mvn clean verify