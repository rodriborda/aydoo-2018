Ejercicio Fibonacci 2
===========

Partiendo del ejercicio Fibonacci, copiarlo en otra carpeta llamada Fibo2 y a partir de eso realizar las modificaciones necesarias para soportar las siguientes opciones:

Orientación: horizontal (h) o vertical (h)
Dirección: directa (d) o inversa (i)
Si es especifica una opción no válida debe indicarse "Opción no válida".

El programa puede invocarse sin la opción "-o" en cuyo caso el comportamiento debe ser por default hd.



# Ejemplo 1 vertical 7 directa

java -jar fibo.jar -o=vd 5

fibo<5>:

0

1

1

2

3

# Ejemplo 2 horizontal e inversa

java -jar fibo.jar -o=hi 8

fibo<8>: 13 8 5 3 2 1 1 0

# Ejemplo 3 vertical e inversa

java -jar fibo.jar -o=vi 8

fibo<8>:

13

8

5

3

2

1

1

0

# Ejemplo 3 opción no valida
java -jar fibo.jar -o=xy 8
Opciones no validas.

# Ejemplo 4, sin -o

java -jar fibo.jar 8

fibo<8>: 0 1 1 2 3 5 8 13