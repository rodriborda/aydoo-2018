


# Informe de Ejercicio Fibo4

Se realiza el análisis del código recibido teniendo en cuenta las siguiente cuestiones:

### 1: ¿cumple con la consigna fibo3?

Si bien el código entregado cumple con parte de la consigna, este presenta varios errores.
Estos serían:
-   A todas las respuestas les falta un salto de línea al final.
    
-   En el caso que solo haya un número sin opciones, si se ingresa algo que no es un número el programa lanza error en lugar de devolver “Opciones no válidas”.

-   No hay validación del parámetro “-m”, al ingresar un valor inválido sólo ignora la opción.
    
-   Si no se ingresa ningún numero lanza error en lugar de “Opciones no válidas”.
    
-   Al guardar en archivo, tanto la impresión de la secuencia en horizontal como la impresión de la suma hacen un salto de línea de más.

Teniendo esto en cuenta, aun cuando el programa calcula correctamente la secuencia, no genera una respuesta adecuada ni valida correctamente las opciones. Por lo tanto la resolución estaría incompleta

### 2: ¿tiene suficientes tests?

La entrega cuenta únicamente con 2 tests, los cuales están ignorados, además tienen código comentado y si se intentan correr no compilan ya que nunca declara un objeto Fibonacci y están llamando a un metodo inexistente de esta clase.
Faltan test para otras funcionalidades, los test que hay aunque no corren solo prueban devolver una lista normal. Faltaria probar la suma, la lista tanto horizontal como vertical, y si es inversa o directa.
Tampoco prueba la validación de las opciones, ni los casos de excepción.

Por lo tanto considero que a la entrega le falta realizar mayor cantidad de tests.

### 3: ¿respeta la convenciones Java?

En la clase Opciones hay código duplicado, ya que getArchivo y getNombreArchivo hacen exactamente lo mismo, también por esto el método getArchivo no se lo llama nunca.
El atributo “opcionValida” se inicializa en true lo cual es redundante pues luego se le vuelve a dar otro valor.
En varias partes se podría reutilizar código, como al llamar a la carátula tanto al imprimir en consola o al guardar en archivo.
En el método escribir, si debe hacerlo de forma vertical fracciona el texto para escribirlo linea por linea, esto es redundante cuando el texto que recibe ya tiene el formato correcto para ser guardado en el archivo.
El método imprimir parece redundante y recibe como parámetro la orientación pero nunca la usa.
La clase Fibonacci tiene un constructor vacío que podría quitarse.

La reutilizacion de codigo podría mejorar el diseño de la entrega, pero el código duplicado o redundante es un problema un poco más serio a tener en cuenta.

### 4: ¿respecta los principio SOLID?

-   **Single Responsibility Principle**: no lo cumple, casi toda la lógica del programa está en la clase Fibonacci: calcular el fibonacci en secuencia, calcular la suma, generar el resultado directo o inverso, imprimir resultado o guardarlo en un archivo. En cambio la clase opciones si se podría decir que cumple con este principio ya que se encarga de una sola responsabilidad que podría ser “manejo de opciones” por ejemplo.
    
-   **Open/Close Principle**: tampoco lo cumple, al usar tantos if/else anidados resulta complicado intentar extender el código si aparece una nueva opción, se debería cambiar mucho código ya existente tanto en Fibonacci como en Opciones.
    
-   **Liskov Substitution Principle**: Al no haber herencia realmente no se puede decir si cumple o no con este principio.
    
-   **Interface Segregation Principle**: Tampoco hace uso de interfaces por lo que no se puede decir que cumple o no con este principio.
    
-   **Dependency Inversion Principle**: Casi toda la lógica del programa esta agrupada en la clase principal, incluyendo la forma de guardar el resultado en un archivo. Ademas en un determinado caso debe setear el valor de las opciones desde Fibonacci, lo que implica saber que valores puede devolver la clase Opciones para una situación similar. Teniendo esto en cuenta casi no hay abstracción entre la clases.

En general los principios no se respetan, lo que provoca que el código no solo este concentrado en una sola clase, sino que ademas hace difícil la extensión de la implementacion. 
  

## Conclusión:

Hay varias cosas del diseño que podrían cambiarse para mejorar el código, como separar en clases para dividir las responsabilidades, reutilizar código y eliminar código innecesario.

Sin embargo, si bien el código entregado calcula correctamente la secuencia de números, no cumple con las consignas de entrega en cuanto a la devolución del resultado, ya sea por consola o guardándolo en un archivo, ni a la validación de las opciones. Tampoco se respetan los principios SOLID y además los test entregados son lo mismo que nada, pues están ignorados y si no lo estuvieran ni siquiera compilan.

En mi opinión la entrega no estaría aprobada, debería ir a reentrega o directamente desaprobar.
