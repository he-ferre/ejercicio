
import java.util.Random;
import java.util.Scanner;

public class TPF{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int arrLong = 25;

        int [] tablero = tableros.cargarTablero(arrLong);
        int [] tableroEventos = tableros.inicializarEventos(arrLong);
        tableros.cargarEventos(arrLong, tableroEventos);

        logicaDeJuego.correrJuego(tablero, tableroEventos,arrLong,scanner,random);
    }
}
class dado{
        public static int tirarDado(Scanner scanner, Random random){

        //Scanner scanner = new Scanner(System.in);

        
            System.out.println("Presiona ENTER para tirar el dado:");
            scanner.nextLine();
            int numero = numeroRandom.numeroDado(random);
            System.out.print("Dado: ");
            System.out.println(numero);
        
        return numero;
    }
}
class numeroRandom{
    public static int numeroDado(Random random){
        // Random random = new Random();
        int limiteSuperior = 7; // Genera numeros del 0 al 6

        int numeroAleatorio = random.nextInt(1,limiteSuperior);
        return  numeroAleatorio;
    }
}
class tableros{
    public static int [] cargarTablero(int arrLong){

        int [] tablero = new int [arrLong];

        for(int i = 0; i < arrLong ; i++){
            tablero[i] = 0;
        }

        // posiciones especiales 
        tablero[4] = 10;
        tablero[5] = 13;
        tablero[11] = 8;
        tablero[23] = 15;
        tablero[9] = 20;
        tablero[22] = 24;
        

        return  tablero;
    } 
    public static void cargarEventos(int arrLong, int [] tableroEventos){
        Random random = new Random();
        int cont = 0;
        // Cargo dos eventos 1 y dos -1
        while (cont < 4){

            int numeroRandom = random.nextInt(arrLong);
            if(cont < 2){
                if(tableroEventos[numeroRandom] == 0){
                    tableroEventos[numeroRandom] = 1;
                    cont++;
                }
            }else{
                if(tableroEventos[numeroRandom] == 0){
                    tableroEventos[numeroRandom] = -1;
                    cont++;
                }
            }
        }

    }
    public static int [] inicializarEventos(int arrLong){

        int [] tableroEventos = new int [arrLong];

        for (int i = 0; i < arrLong; i++){
            tableroEventos[i] = 0;
        }
        return tableroEventos;
    }

    public static int saltos(int[] tablero, int posicion, int arrLong, int jugador){

        int posicionJugador = posicion;

        if((posicion < arrLong) && (tablero[posicion] != 0) && (posicion < tablero[posicion]) ){
            posicionJugador = tablero[posicion]; 

            System.out.println("Se produjo un salto :");
            System.out.println("El jugador " + jugador + " avanza a la posicion: " + posicionJugador);
        }
        if((posicion < arrLong) && (tablero[posicion] != 0) && (posicion > tablero[posicion])){
            posicionJugador = tablero[posicion];
            System.out.println("Se produjo un salto :");
            System.out.println("El jugador " + jugador + " retrocede a la posicion: " + posicionJugador);
        }
        return posicionJugador;
    }
    public static void eventos(int [] tablero, int [] tableroEventos, int posicion, int jugador, int arrLong,int posDos,int jugadordos){

        if((posicion < arrLong)&&(tableroEventos[posicion] == 1)){
            // Modifico tablero eventos donde habia un 1 , De esta manera ya no se puede usar el evento 
            tableroEventos[posicion] = 0;
            for(int i = posicion + 1; i < arrLong - 1 ; i++){
                if(tablero[i] != 0){
                    tablero[i + 1] = tablero[i];
                    tablero[i] = 0;
                    i++;
                }if(i == arrLong -1 ){
                    while(tablero[i] == 0){
                        i--;
                    }
                    tablero[i] = 0; //elimino la ultima casilla de salto
                }
            }
            // if(tablero[arrLong -1 ]  != 0){
            //         tablero[arrLong - 1] = 0;
            // }

            System.out.println("El jugador " + jugador + " cayo en la posicion " + posicion + " donde hay un 1 : ");
            System.out.println("Se produjo el movimiento de los saltos posteriores 1 lugar hacia adelante y se elimino el ultimo salto:  ");
            // revisar
            impresiones.imprimirTablero(tablero, arrLong, posicion, posDos);
            System.out.println("");

        }else if((posicion < arrLong)&&(tableroEventos[posicion] == -1)){
            for(int i = posicion + 1; i < arrLong ; i++){
                if(tablero[i] != 0){
                    if(i - 1 >= 0 ){
                        tablero[i - 1] = tablero[i];
                        tablero[i] = 0;
                    }
                }
            }

            for(int i = 0 ; i < arrLong; i++){
                if(tablero[i] != 0){
                    tablero[i] = 0;
                    break;
                }
            }
            // if(tablero[arrLong -1 ]  != 0){
            //         tablero[arrLong - 1] = 0;
            // }
            System.out.println("El jugador " + jugador + " cayo en la posicion " + posicion + " donde hay un -1 : ");
            System.out.println("Se produjo el movimiento de los saltos posteriores 1 lugar hacia atras y se elimno el primer salto:  ");

            impresiones.imprimirTablero(tablero, arrLong, posicion, posDos);
            System.out.println("");
        }
    }
    public static boolean victoria(int arrLong, int posicion, int jugador){
        // revisar
        if(posicion == (arrLong - 1)){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("FELICIDADES GANO EL JUGADOR " + jugador );
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return true;
        }else if(posicion >= arrLong){

            return false;
        }else{
            return false;
        }
    }
    public static int posicionExcedida(int posJugador, int numeroDado,int arrLong,int jugador){
        if(posJugador >= arrLong){
            posJugador -= numeroDado;
            System.out.println("Jugador " + jugador + " excedio los limites. Vuelve a su posicion antes de tirar el dado: " );
            return posJugador;
        }else{
            return posJugador;
        }
    }
}
class impresiones{
    public static void imprimir(int [] tableroEventos, int arrLong){
        for(int i = 0; i < arrLong; i++){
            System.out.print( "[ "+ tableroEventos[i] + " ]");
        }
    }
    public static void imprimirTablero(int [] tablero, int arrLong, int posUno, int posDos){

        if(posUno == posDos){
            for(int i = 0; i < arrLong; i++){
                if(posUno == i){
                    System.out.print("[ " + tablero[i] + " (P1)(P2)]");
                } else{
                    System.out.print("[ " + tablero[i] + " ]");
                }    
            }
        }else if((posUno > posDos) || (posUno < posDos)){
            for(int i = 0; i < arrLong; i++){
                if(posUno == i){
                System.out.print("[ "  + tablero[i] + " (P1)]");
                }else if(posDos == i){
                System.out.print("[ "  + tablero[i] + " (P2)]");
                }else{
                System.out.print("[ "  + tablero[i] + " ]");
                }
            }
        }
    }
}
class logicaDeJuego{
    public static void correrJuego(int [] tablero,int [] tableroEventos,int arrLong, Scanner scanner, Random random){

        boolean ganador = false;
        int jugadorUno = 1, jugadorDos = 2;
        int posJugadorUno = 0, posJugadorDos = 0, numeroDado = 0;

        //impresiones.imprimirTablero(tablero, arrLong, posJugadorUno, posJugadorDos);
        System.out.println("======================");
        System.out.println("QUE COMIENCE EL JUEGO ");
        System.out.println("======================");

        System.out.println("");
        System.out.println("=====>  AMBOS JUGADORES COMIENZAN EN LA POSICION 0.");
        System.out.println("=====>  (J1) = JUGADOR UNO.");
        System.out.println("=====>  (J2) = JUGADOR DOS.");
        System.out.println("NUMEROS DISTINTOS DE 0 EN EL TABLERO INDICAN SALTOS A DICHA POSICION.");
        System.out.println("");

        System.out.println("TABLERO:");
        System.out.println("========================================================================================================================================");
        impresiones.imprimirTablero(tablero, arrLong, posJugadorUno, posJugadorDos);
        System.out.println("");
        System.out.println("========================================================================================================================================");
       
        System.out.println("TABLERO DE EVENTOS:");
        System.out.println("========================================================================================================================================");
        impresiones.imprimir(tableroEventos, arrLong);
        System.out.println("");
        System.out.println("========================================================================================================================================");

        while(!ganador){
        System.out.println("~~ TURNO DEL JUGADOR UNO: ~~ ");
        numeroDado = dado.tirarDado(scanner,random);
        posJugadorUno += numeroDado;

        // verificar salto
        posJugadorUno = tableros.saltos(tablero, posJugadorUno,arrLong,jugadorUno);

        // // Verificar victoria
        // ganador = tableros.victoria(arrLong,posJugadorUno,jugadorUno);

        // verificar eventos  --------> REVISAR EVENTOS!!!!!!!!!!!!!
        tableros.eventos(tablero, tableroEventos, posJugadorUno, jugadorUno, arrLong,posJugadorDos,jugadorDos);     // revisar eventos>>> 
        System.out.println("");
        // System.out.println(posJugadorUno);
        

        //Verifico si se excede la posicion final
        posJugadorUno = tableros.posicionExcedida(posJugadorUno,numeroDado,arrLong,jugadorUno);
        System.out.println("El jugador " + jugadorUno + " esta en la posicion " + posJugadorUno);

        // // Verificar victoria
        ganador = tableros.victoria(arrLong,posJugadorUno,jugadorUno);
        //fuerzo la victoria
        if(ganador == true){
            break;
        }


        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println("~~ TURNO DEL JUGADOR DOS: ~~ ");
        numeroDado = dado.tirarDado(scanner, random);
        posJugadorDos += numeroDado;

        // verificar salto
        posJugadorDos = tableros.saltos(tablero, posJugadorDos,arrLong,jugadorDos);

        // // Verificar victoria
        // ganador = tableros.victoria(arrLong,posJugadorDos,jugadorDos);

        // verificar eventos  --------> REVISAR EVENTOS!!!!!!!!!!!!!
        tableros.eventos(tablero, tableroEventos, posJugadorDos, jugadorDos, arrLong,posJugadorUno,jugadorUno);     // revisar eventos>>> 
        System.out.println("");

        

        //Verifico si se excede la posicion final
        posJugadorDos = tableros.posicionExcedida(posJugadorDos,numeroDado,arrLong,jugadorDos);
        System.out.println("El jugador " + jugadorDos + " esta en la posicion " + posJugadorDos);

        // // Verificar victoria
        ganador = tableros.victoria(arrLong,posJugadorDos,jugadorDos);

        //Fuerzo la victoria
        if(ganador == true){
            break;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        }
    }
}

