Ejercicio 0
===========


Este proyecto es un ejemplo para tomar como base para los distintos proyecto de la materia.
El proyecto está basado en Maven 3 y ya cuenta con un conjunto de herramientas preconfiguradas:

* JUnit
* Cucumber-JVM
* Cobertura
* PMD
* CheckStyle

Comandos:

* Para compilar y correr los tests: _mvn clean test_
* Para generar un paquete jar ejecutable: _mvn clean package_. El package resultante se encontrará en el directorio target con el nombre que haya sido especificado en el finalName del pom.xml.
* Para correr los tests y medir la cobertura: _mvn clean cobertura:cobertura_. El reporte resultante se encontrará en target/site/cobertura/index.html.
* Para verificar el estilo con CheckStyle: _mvn clean checkstyle:checkstyle_. El reporte resultante se encontrará en target/site/checkstyle.html
