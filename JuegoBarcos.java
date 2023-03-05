//Juego de Barcos V3


import java.util.Arrays;
import java.util.Scanner;

class Cuadricula {
    // Tabla de 10 x 10 casillas
    private char[][] tabla;
    // Constantes para el juego
    private final char AGUA = '-';
    private final char BARCO = 'B';
    private final char TOCADO = 'X';
    private final char HUNDIDO = 'O';

    // Constructor sin argumentos, inicializa el tablero con agua
    public Cuadricula() {
        tabla = new char[10][10];
        for (char[] fila : tabla) {
            Arrays.fill(fila, AGUA);
        }
    }

    // Método para colocar un barco en una caja dada
    public void depositarBarco(int fila, int columna) {
        tabla[fila][columna] = BARCO;
    }

    // Método para disparar a una caja dada
    public boolean disparar(int fila, int columna) {
        if (tabla[fila][columna] == BARCO) {
            tabla[fila][columna] = TOCADO;
            if (barcoHundido()) {
                return true;
            }
        } else if (tabla[fila][columna] == AGUA) {
            tabla[fila][columna] = 'M';
        }
        return false;
    }

    // Método para comprobar si el barco está hundido
    private boolean barcoHundido() {
        for (char[] fila : tabla) {
            for (char caja : fila) {
                if (caja == BARCO) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para mostrar la cuadrícula de juego
    public void visualizacion() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + tabla[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
    }
}


public class JuegoBarcos {
    public static void main(String[] args) {
        Cuadricula cuadricula = new Cuadricula();
        Scanner sc = new Scanner(System.in);

        // Colocar el barco
        System.out.println("Introduce las coordenadas para colocar el barco:");
        System.out.print("Fila: ");
        int filaBarco = sc.nextInt();
        System.out.print("Columna: ");
        int columnaBarco = sc.nextInt();
        cuadricula.depositarBarco(filaBarco, columnaBarco);

        // Disparar al barco
        boolean hundido = false;
        while (!hundido) {
            System.out.println("Introduce las coordenadas para disparar:");
            System.out.print("Fila: ");
            int filaDisparo = sc.nextInt();
            System.out.print("Columna: ");
            int columnaDisparo = sc.nextInt();
            hundido = cuadricula.disparar(filaDisparo, columnaDisparo);
            cuadricula.visualizacion();
        }
        System.out.println("¡Has hundido el barco!");
    }
}



