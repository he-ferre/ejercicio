// importo el scanner
import java.util.Scanner;


public class tPs{
    public static void main(String [] args){

        //inicio el scanner
        Scanner scanner = new Scanner(System.in);


        //TP 1.1 

        //cargo arreglos 
        char [] arr1 = {'c','h','t','e','g','o'};
        //invertirChar(arr1);

        // TP 1.2

        //Cargo arreglos de numeros
        int [] arr2 = {1,2,3,4,5,2,7,8,2,10};
        //obtenerPares(arr2);

        // TP 1.3

        //Cargo arreglo de caracteres 
        char [] arr3 = {'h','o','l','a','l','h','h'};
        //verCapicua8(arr3);

        // TP 1.4 

        // Uso el arr2
        //corrimientoIz(arr2,scanner);

        // TP 1.5

        //uso el arr1
        //reemplazoCor(arr1,scanner);

        // TP 1.6
        
        // uso el arr2
        //encontrarValor(arr2,scanner);

        // TP 1.7

        //eliminarNum(arr2,scanner);

        // TP 1.8

        // char [] secuencias = {'a','b','c','b','c','d','b','c','b','a','b','c'};
        // char [] arrP = {'a','b','c'};
        // contarSec(secuencias,arrP);

        //TP 1.9

        //int [] arr4 = {1,2,2,0,0,0,2,2,2,1,3,0};
        //moverAlFinal(arr4);

        // TP 2.1
        int [] arr5 = {0,2,4,6,8,10,12,14,0};
        //insertarNum(arr5,scanner);

        // TP 2.2
        int [] arr6 = {0,2,8,9,5,7,6,1,0};
        //ordenarIntervalo(arr6,scanner);
        
        // TP 2.3
        // Declaro los arreglos
        int[] arrDes = {10,4,11,9};
        int [] arrOrd = {3,6,14,15};
        //insertarEnOrden(arrDes,arrOrd);

        // TP 2.4
        //Declaro arreglos

        int [] arr7 = {0,0,1,2,0,4,0,0,4,5,2,0,9,1,8};
        //sumarSec(arr7);

        // Tp 2.5
        // Declaro el arreglo

        char []  arr8 = {' ',' ','a','b',' ',' ',' ','a','a',' ','b',' ',' ','a','c',' '};
        //buscarAnteultima(arr8);

        //Tp 2.6
        char [] arr9 = {' ','a','b',' ',' ',' ','a','a','b',' ',' ','a','c',' '};
        //eliminarSecuencia(arr9, scanner);

        //Tp 2.7
        int[] arrOriginal = {0,0,1,2,0,4,0,0,4,5,2,0,9,1,0};
        int [] arrNuevo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //llenarNuevo(arrOriginal, arrNuevo, scanner);

        //Tp 2.8
        int [] arrOriginal1 = {0,0,1,2,0,4,0,0,1,2,0,0,9,1,0};
        int [] secuencia2 = {0,1,2,0,0,0,0,0,0,0,0,0,0,0,0};
        eliminarSecuencia2(arrOriginal1, secuencia2);

        //Tp 2.9
        ejercicio_9();

    }
    private static void invertirChar(char [] arr1){
        boolean valido = false;
        int cont = 0;
        int cont1 = arr1.length - 1;
        char aux = ' ';
        while(!valido){
            if(cont >= cont1){
                valido = true;
            }else{
                aux = arr1[cont];
                arr1[cont] = arr1[cont1];
                arr1[cont1] = aux;
            }
            cont++;
            cont1--;
        }
        


        //imprimo el arreglo
        for(int k  = 0; k < arr1.length;k++){
            System.out.print(arr1[k]);
        }
    }
    private static void obtenerPares(int [] arr2){
        int i = 0;
        int cont = 0;
        while(i < arr2.length){
            if(arr2[i]%2 == 0){
                cont++;
                i++;
            }else{
                i++;
            }
        }
        System.out.print("La cantidad de numeros pares es: " + cont);
    }
    private static void verCapicua8(char [] arr3){
        char [] aux1 = new char[arr3.length];

        for(int i = 0; i < arr3.length; i++){
            aux1[i] = arr3[i];
        }

        boolean variable = false;
        int cont = 0;
        int cont2 = arr3.length - 1;
        char aux = ' ';
        while(!variable){
            if(cont >= cont2){
                variable = true;
            }else{
                aux = arr3[cont];
                arr3[cont] = arr3[cont2];
                arr3[cont2] = aux;
            }
            cont++;
            cont2--;
        }
        //System.out.print(aux1);
        
        // comparo arreglos
        boolean variable2 = false;
        int i = 0;
        while(!variable2){
            if((arr3[i] == aux1[i]) && (i < arr3.length)){
                if (i >= arr3.length - 1) {
                    System.out.print("La palabra  SI es capicua.");
                    variable2 = true;
                }
                i++;

            }else{
                System.out.print("La palabra no es capicua");
                variable2 = true;
            }

        }


    }
    private static void corrimientoIz(int [] arr2, Scanner scanner){
        //boolean variable = false;
        int posicion = -1;
        while(true){
            try {
                System.out.println("Ingrese la posición: ");
                posicion = scanner.nextInt();

                if((posicion < 0 )||(posicion >= arr2.length)){
                    throw new IllegalArgumentException("numero fuera de rango. Intente de nuevo");
                }
                break;

            } catch (Exception e) {

                System.out.println("Valor incorrecto vuelva a intentarlo: " + e.getMessage());
                scanner.nextLine();
            }
        }



        //int i = posicion + 1;
        if((posicion >= 0) && (posicion < arr2.length)){
            for(int k = posicion; k < arr2.length;k++){
                if((k+1) < arr2.length){
                    arr2[k] = arr2[k + 1];
                }
            }
        }else{
            System.out.print("Valor incorrecto");
        }
        //imprimir arreglo
        for(int t = 0; t < arr2.length ; t++){
            System.out.print(arr2[t] + "|");
        }

    }
    private static void reemplazoCor(char [] arr1, Scanner scanner){
        char caracter = ' ';
        while(true){
            try{
            System.out.print("Ingrese un caracter: ");
            String input = scanner.nextLine();

            if(input.length() > 1){
                throw new IllegalArgumentException("Debe ingresar una letra: ");
            }
            caracter = input.charAt(0);
            break;
            }catch(Exception e) {
                System.out.print("Error " + e.getMessage());

            }
        }
        //Corrimiento 
        int i = arr1.length - 1;
        while(true){
            if(i>0) {
                arr1[i] = arr1[i- 1];
                i--;
            }else{
                break;
            }
        }
        arr1[0] = caracter;
        // imprimo arreglo
        System.out.print(arr1);
    }
    private static void encontrarValor(int [] arr2, Scanner scanner){
        int numero = 0;
        try {
           System.out.println("Ingrese el numero a buscar: "); 
            numero = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("Error: El valor ingresado es incorrecto.");
            scanner.nextLine(); // Limpia el buffer del scanner;
            return; // evita continuar con valores incorrectos
        }

        int i = 0;
        int posicion = 0;
        //System.out.println(posicion);
        while(true){
            if(i >= arr2.length){
                System.out.print("no se encontro el valor.");
                break;
            }
            else if (arr2[i] == numero) {
                //corrimiento a izquierda
                posicion = i;
                for(int k = i; k +1 < arr2.length; k++){
                    arr2[k] = arr2[k+1];
                }break;
            }
            else{
                i++;
            }
        }
        for(int t = 0; t < arr2.length; t++){
            System.out.print(arr2[t] + "|");
        }
        System.out.println(" ");
        System.out.print(posicion);
    }
    private static void eliminarNum(int [] arr2, Scanner scanner){

        int numero = 0;
        while(true){
            try {
                System.out.print("Ingrese un numero: ");
                numero = scanner.nextInt();

                break;
            } catch (Exception e) {
                System.out.println("Error : Ingrese un numero valido. ");
                scanner.nextLine();
            }
        }

        //elimino el numero si existe
        //int i = 0;
        int coincidencias = 0;
        // while(i < arr2.length){
        //     if(arr2[i] == numero){
        //         arr2[i] = 0;
        //         coincidencias++;
        //     }
        //     i++;
        // }
        // if(coincidencias == 0){
        //     System.out.println("El numero no se encontro");
        // }
        for(int i = 0; i < arr2.length; i ++){
            if(arr2[i] == numero){
                coincidencias++;
                for(int j = i; j < arr2.length - 1;j++){
                    arr2[j] = arr2[j+1];
                }
                arr2[arr2.length - 1] = 0;
                i--; // Para no saltear indices
            }
        }

        if(coincidencias > 0){
            System.out.println("Se elimino el numero " + numero + " . " + coincidencias + " la veces. ");
        }else{
            System.out.print("El numero no se encontro.");
        }
        //imprimo el arreglo
        for(int t = 0; t < arr2.length; t++){
            System.out.print(arr2[t] + "|");
        }
    }    
    private static void contarSec(char [] secuencias, char [] arrP){
        int cont = 0;
        for(int i = 0; i <= secuencias.length - arrP.length; i++){ // recorro el arrglo solo hasta donde la secuencia podria entrar
            int j = 0; // reinicio j para cada posible coincidencia
            while((j < arrP.length) && (secuencias[i + j] == arrP[j])){
                j++;
            }
            if(j == arrP.length){
                cont++;
            }

        }  
        System.out.print("La secuencia se repite " + cont + " veces.");
    }
    private static void moverAlFinal(int [] arr4){
        int i = 0;
        int cont = 0;
        int ocurrenciasMax = 0;
        int inicio = 0;
        while(i < arr4.length - cont){
        if((arr4[i] == arr4[i +1])){
            cont = 2; // reinicio cont cada vez que encuentra una nueva secuencia
            i++;
            while(arr4[i] == arr4[i + 1 ]){ // entro en el bucle si se cumple la condicion , sumo cont e i 
                cont++;
                i++;
            }
            if(ocurrenciasMax <= cont){ // verifico el historial de ocurrencias si este es menor a cont actual quiere decir que hay una nueva serie que se repite mas veces
                ocurrenciasMax = cont;
                inicio = i - cont + 1;  
                i++;          
            }
            else{
                i++;
            }
        }else{
            i++;
        }
    }

        int num = arr4[inicio];
        int posInsertar = arr4.length - cont;
        // corrimiento a izquierda
        for(int t = inicio; t < arr4.length - cont ; t ++){
            arr4[t] = arr4[t + cont];
        }
            
        
         //inserto los valores al final
        for(int k = posInsertar; k  < arr4.length;k++){
            arr4[k] = num;
        }

        //Ayudas para entender el codigo
        System.out.println(num);
        System.out.println(inicio);
        System.out.println(ocurrenciasMax);  
        System.out.println(cont);
            for(int k = 0; k < arr4.length; k++){
               System.out.print(arr4[k] + "|");
        }
    }
    private static void insertarNum(int [] arr5, Scanner scanner){
       
        // pido el numero 
        int numero = 0;
        while(true){
            try {
                System.out.print("Ingrese un numero: ");
                numero = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("error, ingrese un numero valido: " );
                scanner.next();
            }
        }
        int i = 0;
        while(true){
            if((i >= arr5.length - 1) || (arr5[i] >= numero)){
                for(int j = arr5.length -1; j > i; j--){
                    arr5[j] = arr5[j - 1];
                }
                arr5[i] = numero;
                break;
            }else{
                i++;
            }
        }
        for(int k = 0; k < arr5.length ; k++){
        System.out.print(arr5[k] + "|");
        }
    }
    private static void ordenarIntervalo(int [] arr6, Scanner scanner){
        // Ingreso de posiciones
        int posIn = 0;
        int posFin = 0;
        while (true) { 
            try {
                System.out.print("Ingrese la posicion inicial: ");
                posIn = scanner.nextInt();
                System.out.print("Ingrese la posicion final: ");
                posFin = scanner.nextInt();
                if((posFin >= arr6.length) || (posIn >= arr6.length) || (posIn < 0)){
                    throw new IllegalArgumentException("hola ");
                }
                break;
                

                        
            } catch (Exception e) {
                System.out.println("Error dato invalido. ");
                scanner.next(); // limpio el scanner
                continue;

            }
        }
        //Ordenamiento del arreglo
        int num = posFin - posIn;
        int i = posIn;
        int k = 0;
        while(k < num){
            while ((i < posFin) && (i  < arr6.length)) { 
                if(arr6[i + 1] < arr6[i]){
                    int aux = arr6[i];
                    arr6[i] = arr6[i + 1];
                    arr6[i + 1] = aux;
                    i++;
                }else{
                    i++;
                }
            }
            i = posIn;
            k++;
        }
        for(int j = 0; j < arr6.length; j++){
            System.out.print(arr6[j] + "|");
        }

    }
    private static void insertarEnOrden(int [] arrDes, int [] arrOrd){
        for(int i = arrDes.length - 1; i >= 0; i--){
            int j = arrOrd.length - 1;
            while(j >= 0){
                if(arrOrd[j] > arrDes[i]){
                    // corrimieno a derecha
                    arrOrd[j] = arrOrd[j -1];
                    j--;
                }
                    // si j no cambia y es igual a arrOrd.length - 1 quiere decir que en la ultima posicion del arrOrd no es mayor a arrDes[i]. Por eso el break
                else if(j == arrOrd.length -1){
                    break;
                }
                else{
                    //inserto el valor 
                    arrOrd[j+1] = arrDes[i];
                    break;
                }
            }
        }
        
        //imprimo arrOrd
        for(int k = 0; k < arrDes.length; k++){
            System.out.print(arrOrd[k] + "|");
        }

        //Otra forma de hacerlo

        // for(int i = 0; i < arrDes.length; i++){
        //     int j = arrOrd - 1;
             
        //     //Desplazo los valores a la derecha
        //     while(j > 0 && arrOrd[j -1] > arrDes[i]){
        //         arrOrd[j] = arrOrd[j - 1];
        //         j--;
        //     }

        //     // inserto el valor en su posicion correcta
        //     arrOrd[j] = arrDes[i];
        // }
    }
    private static void sumarSec(int [] arr7){
        
        int sumaDeSecuencia = 0;
        int i = 0;
        int inicio = 0;

        while(i < arr7.length){
            if(arr7[i] != 0){ // encuentro la secuencia
                int valorMax = 0;
                int cont = 0;
                for(int k = i ;(k < arr7.length ); k++){
                    if(arr7[k] == 0){
                        break;
                    }
                    cont++;
                    valorMax += arr7[k];

                }
                //comparo
                if(valorMax > sumaDeSecuencia){
                    sumaDeSecuencia = valorMax;
                    inicio = i ;
                }
                //me aseguro de no iterar dos veces por un mismo valor
                i += cont;
            }else{
                i++;
            }
        }
        System.out.print("La secuencia cuya suma mayor es " + sumaDeSecuencia + " y su posicion comienza en el valor " + inicio);


    }
    private static void buscarAnteultima(char  [] arr8){
        int i = arr8.length - 1 ;
        int cont = 0;
        int inicio = 0;
        int contarsecuencia = 0;
        while(i >= 0){
            if(cont == 2){
                inicio = i + contarsecuencia;
                System.out.print("La anteultima secuencia comienza en el indice " + inicio);
                break;
            }
            else if (arr8[i] != ' ') {
                contarsecuencia = 0;
                for(int k = i; k >= 0; k--){
                    if(arr8[k] == ' '){
                        break;
                    }
                    contarsecuencia++;
                }
                i -= contarsecuencia;
                cont++;
            }else{
                i--;
            }
        }
    }
    private static void eliminarSecuencia(char arr9[], Scanner scanner){

        //imprimo secuencias sin modificar
        for(char i : arr9){
            System.out.print(i + "|");
        }
        System.err.println("");

        int numero = 0;
        int i =  arr9.length-1;
        int cont = 0;
        //pido numero de secuencia
        System.out.print("Ingrese el numero que debe tener la secuencia: ");
        numero = scanner.nextInt();

        while(i >= 0){
            // Elimino la secuencia si se cumple la condicion
            if(cont == numero){
                int inicioSec = i +1;
                for(int k = inicioSec; k <= (inicioSec + (numero -1));k++){
                    arr9[k] = ' ';
                }
                cont = 0;
                i--;
            }//Encontrar y contar secuencia
            else if(arr9[i] != ' '){
                // reinicio cont
                cont = 0;
                for(int j = i; (arr9[j] != ' ') && (j >= 0); j--){
                    if(arr9[j] == ' '){
                        break;
                    }
                    cont++;
                }
                i -= cont;
            }else{
                i--;
            }
        }

        //imprimo secuencia modificada
        for(char j : arr9){
            System.out.print(j + "|");
        }
    }
    private static void llenarNuevo(int [] arrOriginal, int [] arrNuevo, Scanner scanner){
        //Declaro variables
        int i = 0;
        int cont = 0;
        int inicio = 0;
        int h = 0;
        int numero = 0;

        System.out.print("ingrese el numero de secuencia: ");
        numero = scanner.nextInt();



        while (i >= 0) { 
            if(cont == numero){
                inicio = i - cont;
                //System.out.print(inicio);
                for(int j = inicio; (j < arrNuevo.length -1) && (j < inicio + numero);j++){
                    arrNuevo[h] = arrOriginal[j];
                    h++;
                }
                //reinicio cont
                cont = 0;
            }else if ((i < arrOriginal.length)&&(arrOriginal[i] != 0)){
                cont = 0;
                // cuento la secuencia
                for(int k = i;arrOriginal[k] != 0; k++ ){
                    if(arrOriginal[k] == 0 ){
                        break;
                    }
                    cont++;
                }    
                i += cont;           
            }else{
                i++;
            }
        }
        for(int j : arrOriginal){
            System.out.print(j);
        }
        System.out.println("");
        for(int k : arrNuevo){
            System.out.print(k);
        }

    }

        private static void eliminarSecuencia2(int[] arr, int[] secuencia) {
            // Extraer la secuencia real (ignorando ceros)
            int inicioSec = -1, longitud = 0;
            for (int i = 0; i < secuencia.length; i++) {
                if (secuencia[i] != 0) {
                    if (inicioSec == -1) {
                        inicioSec = i;
                    }
                    longitud++;
                }
            }
    
            // Si no hay secuencia válida, salir
            if (longitud == 0) return;
    
            // Guardar la secuencia válida en un arreglo temporal
            int[] secuenciaReal = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                secuenciaReal[i] = secuencia[inicioSec + i];
            }
    
            // Buscar y eliminar todas las ocurrencias de la secuencia en arr
            int i = 0;
            while (i <= arr.length - longitud) {
                boolean match = true;
                for (int j = 0; j < longitud; j++) {
                    if (arr[i + j] != secuenciaReal[j]) {
                        match = false;
                        break;
                    }
                }
    
                if (match) {
                    // Hacer corrimiento a la izquierda
                    for (int k = i; k < arr.length - longitud; k++) {
                        arr[k] = arr[k + longitud];
                    }
                    // Rellenar con ceros al final
                    for (int k = arr.length - longitud; k < arr.length; k++) {
                        arr[k] = 0;
                    }
                    // No aumentar i para revisar si hay otra ocurrencia inmediata
                } else {
                    i++;
                }
            }
        }
    
    private static void ejercicio_9(){

        // Arreglos necesarios
        String [] arrDado = {" ","m","b","m"," ","r","a","r","b","b"," "," ","d","c","d"};
        String [] arrAlfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
        int [] arrContador = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        //encontrar inicio de secuencia
        int i = 0;
        int inicio = 0;
        int cont = 0;
        int masRepetida = 0;
        while(i < arrDado.length){
            if(arrDado[i] != " "){
                inicio = 0;
                for(int j = 0; j < 27; j++){
                    if(arrDado[i] == arrAlfabeto[j]){
                        arrContador[j] += 1;
                        cont++;
                        break;
                    }
                }
                i++;

            }else{
        
                inicio = i - cont;
                // Si cont es distinto de 0  averiguo cual letra se repite mas;
                if(cont != 0){
                    masRepetida = 0;
                    for(int  t = 0; t < 27 ; t ++){
                        if(arrContador[masRepetida] <= arrContador[t]){
                            masRepetida = t;
                        }
                    }
                }

                // reemplazo letra mas repetida en secuencia
                for(int k = inicio; k < inicio + cont; k++){
                    arrDado[k] = arrAlfabeto[masRepetida];
                }

                // reinicio arrContador
                for(int t = 0; t < 27; t++){
                    arrContador[t] = 0;
                }
                cont = 0;
                i++;
            }
        }




        // Manejar secuencia final si no terminó con " "
        if (cont != 0) {
            inicio = i - cont;
            masRepetida = 0;
            for (int j = 0; j < arrAlfabeto.length; j++) {
                if (arrContador[j] >= arrContador[masRepetida]) {
                    masRepetida = j;
                }
            }
            for (int k = inicio; k < i; k++) {
            arrDado[k] = arrAlfabeto[masRepetida];
            }
        }
        // imprimo resultado
        for(String k : arrDado){
            System.out.print(k + "|");
        }
    }
}
    



