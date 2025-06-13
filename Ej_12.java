public class Ej_12{

    static final int FILAS = 8;
    static final int COLUMNAS = 10;

    public static void main(String [] agrs){

    // Cargar la matriz 
    char [][] matriz = carMatriz();

    imprimirMatriz(matriz, FILAS, COLUMNAS);

    // iniciar Array
    char [] secuencias = new char[FILAS * COLUMNAS];

    inicializarSecuencias(secuencias);

    contarSecuencias(matriz, FILAS, COLUMNAS, secuencias);

    // Mostrar array 
    for(int i = 0; i < (FILAS * COLUMNAS); i++){
        System.out.print(secuencias[i] + "|");
    }

    }

    public static char [][] carMatriz(){
       
        char[][] matriz = {
            {' ', 'a', 'c', 'g', ' ', ' ', 'p', 'a', 'b', ' '},
            {' ', 'x', ' ', 'x', 'x', 'y', ' ', 'x', ' ', ' '},
            {' ', 'm', 'n', ' ', 'o', 'p', ' ', 'm', 'n', ' '},
            {' ', 'q', 'r', ' ', 'q', 'r', ' ', 's', 't', ' '},
            {' ', 'h', 'i', ' ', 'h', 'i', ' ', 'h', 'i', ' '},
            {' ', 'u', 'v', ' ', 'w', 'x', ' ', 'u', 'v', ' '},
            {' ', 'a', 'a', ' ', 'b', 'b', ' ', 'b', 'b', ' '},
            {' ', 'z', 'z', ' ', 'z', 't', ' ', 'z', 'z', ' '}
        };
        return matriz;
    }
    public static void contarSecuencias(char [][] matriz,int FILAS, int COLUMNAS, char [] secuencias){
        int inicioMAX = 0;
        int finMAX = 0;
        int ocurrenciasMaximas = 0;

        int ocurrencias = 0;
        // Recorro la matriz
        for(int i = 0; i < FILAS; i++){
            inicioMAX = 0;
            finMAX = 0;
            ocurrenciasMaximas = 0;
            
            for(int k = 0; k < COLUMNAS; k++){

                int contLongitud = 0;
                int inicio = -1;
                
                // Reconozco donde comienza la secuencia
                while(matriz[i][k] != ' '){
                    if(inicio == -1){
                        inicio = k;
                    }
                    contLongitud++;
                    k++;
                }
                int fin = inicio + contLongitud-1;
                
                // Comparo con las secuencias de la columna
                if(contLongitud != 0){

                    ocurrencias = 0;

                    for(int j = 0; j < COLUMNAS; j++){

                        int cont = 0;
                        int t = inicio;


                        while((matriz[i][j] == matriz[i][t]) && (matriz[i][j] != ' ') && (t <= fin)){
                            cont++;
                            t++; 
                            j++;   
                        }
                        if(cont == contLongitud){
                            ocurrencias++;
                        }
                    }
                    if(ocurrencias > ocurrenciasMaximas){
                        ocurrenciasMaximas = ocurrencias;
                        inicioMAX = inicio;
                        finMAX = fin;
                    }
                }
            }
            agregarSecuencia(matriz,secuencias, inicioMAX, finMAX, ocurrenciasMaximas, i);
        }
    }
    public static void imprimirMatriz(char [][] matriz, int FILAS, int COLUMNAS){
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void agregarSecuencia(char[][] matriz,char [] secuencias, int inicioMAX, int finMAX, int ocurrenciasMaximas, int i){
        // Agregar secuencia al arreglo 
        int fila = i;
        for(int t = inicioMAX; t <= finMAX; t++){
            int p = 0;
            while(secuencias[p] != ' '){
                p++;
            } // salto las secuencias ya agregadas
            secuencias[p] = matriz[fila][t];
        }
    }
    public static void inicializarSecuencias(char [] secuencias){
        // Inicializo el array con espacios
        for(int i = 0; i < (FILAS * COLUMNAS); i++){
            secuencias[i] = ' ';
        }
    }
}