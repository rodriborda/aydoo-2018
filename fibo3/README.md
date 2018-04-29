Ejercicio Fibonacci 3
=====================

Partiendo del ejercicio Fibonacci2, copiarlo en otra carpeta llamada Fibo3 y a partir de eso realizar las modificaciones necesarias para soportar las siguientes opciones:

-f=xxxxxx: escribe la salida en el archivo cuyo nombre se especifique
-m=s: donde m define el modo de funcionamiento, el cual puede ser "l" o "s", "l" significa "lista", lo cual es el comportamiento actual en fibo2. "s"  significa "sumatoria" y significa que el programa debe calcular la sumatoria de los items de la secuencia de fibonacci del número especificado.
El programa puede invocarse sin la opción "-m" en cuyo caso el comportamiento debe ser por default debe ser el de fibo2.

# Ejemplo 1 salida a archivo
java -jar fibo.jar -o=vd -f=salida.txt 5
fibo<5> guardado en salida.txt
# Y el archivo salida.txt debe tener el siguiente contenido
fibo<5>:
0
1
1
2
3

# Ejemplo 2 con opción s
java -jar fibo.jar -o=hd -m=s 5
fibo<5>s: 7

# Ejemplo 3 salida a archivo con opción s
java -jar fibo.jar -o=vd -f=salida.txt -m=s 5
fibo<5> guardado en salida.txt
# Y el archivo salida.txt debe tener el siguiente contenido
fibo<5>s:
7