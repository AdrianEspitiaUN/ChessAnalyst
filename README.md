# Consideraciones para el funcionamiento

## Modificar rutas de stockfish en las clases

Modificar las rutas del archivo stockfish-windows-x86-64.exe en las siguientes clases:

### Stockfish
En la clase Model/Stockfish.java en la linea 22 reemplazar la ruta de acceso al archivo de stockfish, el cual se encuentra en la siguiente ruta del repositorio:\
OneDrive\Documentos\NetBeansProjects\ChessAnalysisApp1\src\resources\stockfish
![ruta stockfish](https://github.com/user-attachments/assets/110a61f9-22f6-4f2e-a5ce-676f7fa56178)

### GameAnalysis
En la clase Model/GameAnalysis en la linea 47 realizar el mismo procedimiento anterior 
![image](https://github.com/user-attachments/assets/9eaeadc1-dcd9-4561-91bb-8cf8286ade3b)

## Configurar FirebaseServices
Configurar la siguiente ruta relativa en la consola de la base de datos en tiempo real de Firebase:
/users
![image](https://github.com/user-attachments/assets/9e53d1b4-9dbe-442c-9d88-90d4b1af0f86)

Descargar token en formato JSON para el acceso a la base de datos de Firebase y cambiar la ruta del token a la ruta del archivo descargado en la clase Model/FirebaseServices.java en las lineas 37 y 46

![image](https://github.com/user-attachments/assets/a582651f-344c-4ace-b8eb-feb2a14cd148)

Cambiar la url de la base de datos en linea 47 del archivo anterior por la ruta de su base de datos de Firebase

## Token de Lichess
Crear una cuenta en lichess.org y crear un token de la siguiente manera
1. Dirigirse a esta ruta https://lichess.org/account/oauth/token
2. Dar click en generar nuevo token
3. Cambiar el token en la clase Model/LichessAPI.java por el token generado
   ![image](https://github.com/user-attachments/assets/0149b1a3-0676-41f6-9836-df511de7f737)

## Ruta del archivo eco.pgn
En la clase Model/OpeningHistogram.java en la linea 31 cambiar la ruta del archivo eco.pgn el cual se encuentra en el repositorio en OneDrive\Documentos\NetBeansProjects\ChessAnalysisApp1\src\resources

![image](https://github.com/user-attachments/assets/6438bd71-1742-479c-b5b4-c7551b8b26c0)


# Manual de Usuario

Autenticación del usuario: El usuario ve como primer pantalla la vista de autenticación, donde deberá hacer los siguiente:

Registrarse si no tiene cuenta.\
Iniciar sesión si ya tiene cuenta.

![ChessAnalyst imagenes/autenticacion.png](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/autenticacion.png)

## Menú principal
Después de la autenticación del usuario, el menú principal se despliega y el usuario tiene la posibilidad de seleccionar desde qué fuente cargará los juegos, si desea realizar ejercicios de práctica o si desea ver recursos para el aprendizaje:
![menu principal](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/menuPrincipal.png)


## Cargar Juegos desde Lichess.org
Si el usuario tiene una cuenta en lichess.org puede cargar los juegos directamente desde la plataforma, seleccionando la opción Cargar juegos desde Lichess.org:
![menu principal](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/cargarJuegosLichess.png)


Aquí el usuario ingresa su nombre de usuario en lichess.org y oprime el botón Cargar Juegos. Alternativamente, el usuario puede cargar los juegos desde un archivo .png que tenga en su equipo seleccionando la opción Cargar Archivo png en el menú principal.

## Cargar Juegos desde un archivo .png
En esta ventana el usuario puede navegar en el sistema de archivos de su computador y seleccionar un archivo .png en el que estén los juegos que desea analizar
![pgn](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/cargarJuegosPgn.png)

Una vez cargados los juegos se despliega una ventana con las opciones del análisis. 
![estadistica](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/estadisticasAnalizarJuegos.png)

## Estadísticas
La opción Estadísticas permite al usuario ver una gráfica con las principales aperturas que aparecen dentro de sus juegos y la proporción de victorias según el color de piezas que el usuario tiene:

![estadisticas](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/estadisticas.png)

## Analizar un juego
Si el usuario escoge la opción analizar un juego se despliega una ventana con una lista de los juegos contenidos en el archivo .png o recuperados desde la plataforma lichess.org:

![escoger juego](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/seleccionarJuego.png)

El usuario selecciona un juego dentro de la lista y da click en el botón Analizar! A continuación se muestra un tablero de ajedrez y los botones para avanzar o retroceder en los movimientos del juego seleccionado, los cuales se muestran en el tablero. 

![ver oportunidads](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/verOportunidades.png)


## Ver oportunidades tácticas
Cuando el usuario da click en el botón ver oportunidades tácticas se despliega una lista con las posiciones en las que el usuario tiene la oportunidad de conseguir una ventaja considerable debido a que su oponente cometió un error en la jugada inmediatamente anterior a dicha posición. Cada elemento de la lista muestra el cambio en la evaluación del juego (en centi peones abreviado cp) debido al error del contrincante, lo cual da una medida de la ventaja que el usuario ahora puede explotar para ganar el juego. Entre mayor sea el número de centi peones mayor es la ventaja que el usuario ha ganado. El propósito de esta dinámica es permitirle al usuario practicar la detección de oportunidades tácticas basándose en sus propios juegos. 

![selectops](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/seleccionarOportunidades.png)

Cuando el usuario selecciona un elemento de la lista y da click en Solucionar! se muestra la posición seleccionada en el tablero y un campo para que el usuario ingrese el movimiento que considera es el mejor para aprovechar la oportunidad táctica:

![solprobl](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/solucionarProblema.png)

Si el usuario ingresa el mejor movimiento en la posición, el cuál se obtuvo durante el análisis del juego efectuado con Stockfish, aparece un mensaje indicando que dicho movimiento es acertado, de lo contrario aparece un mensaje señalando que la selección del usuario es incorrecta y mostrando el verdadero mejor movimiento:

![solcorr](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/solucionarCorrecto.png)

## Ejercicios de ajedrez

En el menú principal, al dar click en la opción Ejercicios de Práctica, se despliega la pantalla de ejercicios, donde el usuario podrá interactuar con cada ejercicio propuesto y analizar una posición configurada libremente por él.

![ejj1](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios1.png)

Se muestran los ejercicios específicos del modo que elige el usuario:

![ejj2](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios2.png)

El usuario selecciona un ejercicio en específico y se muestra en el tablero:

![ejj2](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios3.png)

nota: como adición al caso de uso, se coloca la opción de juego libre! para que el usuario pueda crear una posición cualquiera y recibir retroalimentación.

![ejj4](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/Ejercicios4.png)


El usuario hace la jugada que considera correcta en la posición arrastrando la pieza desde el tablero y recibe retroalimentación de la mejor jugada y de la evaluación numérica de la posición:

![ejj4](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios5.png)

El usuario navega a la pantalla de resources mediante el menú de la parte superior de la pantalla, dando clic en navegación y eligiendo la vista:

![ejj4](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios6.png)

el usuario ve la vista de recursos de ajedrez en cada de navegar a esa vista:

![ejj4](https://github.com/AdrianEspitiaUN/ChessAnalyst/blob/master/ChessAnalyst%20imagenes/ejercicios7.png)
