import java.util.Random;
import java.util.Scanner;

public class TPF{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        final int arrLong = 25;

        int [] tablero = tableros.cargarTablero(arrLong);
        int [] tableroEventos = tableros.inicializarEventos(arrLong);
        //tableros.cargarEventos(arrLong, tableroEventos);


        //imprimir(tableroEventos, arrLong);

        tirarDado(scanner);
    }
    private static void imprimir(int [] tablero, int arrLong){
        for(int i = 0; i < arrLong; i++){
            System.out.print(tablero[i] + "|");
        }
    }
    private static void tirarDado(Scanner scanner){
        while(true){
            System.out.println("Presiona enter para tirar el dado");
            scanner.nextLine();
            int numero = numeroRamdom.numeroDado();
            System.out.println(numero);
        }
    }

}
class numeroRamdom{
    public static int numeroDado(){
        Random random = new Random();
        int limiteSuperior = 7; // Genera numeros del 0 al 6

        int numeroAleatorio = random.nextInt(1,limiteSuperior);
        return  numeroAleatorio;
    }
}
class tableros{
    public static int [] cargarTablero(int arrLong){

        int [] tablero = new int [arrLong];

        for(int i = 0; i < arrLong ; i++){
            tablero[i] = i;
        }
        return  tablero;
    } 
    public static void cargarEventos(int arrLong, int [] tableroEventos){
        Random random = new Random();

        // Cargo dos eventos 1 y dos -1
        for(int i = 0; i < 4; i++){

            int numeroRandom = random.nextInt(arrLong);
            if(i < 2){
                if(tableroEventos[numeroRandom] == 0){
                    tableroEventos[numeroRandom] = 1;
                }
            }else{
                if(tableroEventos[numeroRandom] == 0){
                    tableroEventos[numeroRandom] = -1;
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
}

