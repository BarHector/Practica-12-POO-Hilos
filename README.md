# Practica 12 POO Hilos
 
TEMA DE LA PRÁCTICA
--------------------------------------------------------------------------------------------------------------------------------------------------------
Hilos

DESCRIPCIÓN
--------------------------------------------------------------------------------------------------------------------------------------------------------
El programa realiza la suma de matrices cuadradas por medio de 4 hilos, cada uno toma una carta parte de las dos matrices para realizar la suma.

En los archivos de texto unicamente viene los números que se colocarán en cada casilla de la matriz. 

Para diferenciar a ambas matrices, las separa una linea en blanco.

ARCHIVOS INCLUIDOS
--------------------------------------------------------------------------------------------------------------------------------------------------------
Se incluyen los .txt (para las pruebas), .java, .class, .jar, .zip y .html utilizados y entregados, así como los manuales de las prácticas.

NOTAS
--------------------------------------------------------------------------------------------------------------------------------------------------------
Algo muy importante que hay que mencionar sobre el tema de hilos, es la manera en la que se ejecutan o trabajan los hilos (hablando sobre n cantidad de hilos) no sigue un orden en especifico, por lo cual si tenemos 4 hilos, nada nos asegura que el hilo #1 sea el primero en terminar y que el hilo #4 sea el último en terminar. Este tipo de programación paralela (o al menos la que se usa en el repositorio) ejecuta todos los hilos al mismo tiempo, pero no terminan de ejecutarse al mismo tiempo (como ya se mencionó anteriormente), existen algunas formas con las cuales se ejecutará una parte del código siempre y cuando todos los hilos hayan terminado de ejecutarse.

Lo anterior se menciona porque en los programas que son paralelos y en este caso en especifico, en un primer momento (versión) los resultados de las sumas eran incorrectos y correctos, dependiendo de la corrida. Como se menciona en el parrafo anterior, existen herramientas para que se ejecute cierta parte del código siempre y cuando todos los hilos hayan terminado de trabajar, pero debido a que su implementación no fue correcta, se utilizó un ciclo while (programación en serie) y por medio de otras variables, se imprimirera la matriz resultante una vez que todos los hilos han realizado sus sumas correspondientes.