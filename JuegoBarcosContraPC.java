//Juego de Barcos V4

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JuegoBarcosContraPC {
    public static void main(String[] args) {
        Cuadricula jugador = new Cuadricula();
        Cuadricula pc = new Cuadricula();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Colocar el barco del jugador
        System.out.println("Coloca tu barco:");
        System.out.print("Fila: ");
        int filaBarco = sc.nextInt();
        System.out.print("Columna: ");
        int columnaBarco = sc.nextInt();
        jugador.depositarBarco(filaBarco, columnaBarco);

        // Colocar el barco de la computadora
        int filaBarcoPC = rand.nextInt(10);
        int columnaBarcoPC = rand.nextInt(10);
        pc.depositarBarco(filaBarcoPC, columnaBarcoPC);

        // Jugar hasta que alguien gane
        boolean ganaJugador = false;
        boolean ganaPC = false;
        while (!ganaJugador && !ganaPC) {
            // Turno del jugador
            System.out.println("Tu turno:");
            jugador.visualizacion();
            System.out.println("Dispara:");
            System.out.print("Fila: ");
            int filaDisparo = sc.nextInt();
            System.out.print("Columna: ");
            int columnaDisparo = sc.nextInt();
            if (pc.disparar(filaDisparo, columnaDisparo)) {
                ganaJugador = true;
                break;
            }

            // Turno de la computadora
            System.out.println("Turno de la PC:");
            int filaDisparoPC = rand.nextInt(10);
            int columnaDisparoPC = rand.nextInt(10);
            System.out.println("Dispara en " + filaDisparoPC + ", " + columnaDisparoPC);
            if (jugador.disparar(filaDisparoPC, columnaDisparoPC)) {
                ganaPC = true;
                break;
            }
        }

        // Mostrar el resultado del juego
        System.out.println("Jugador:");
        jugador.visualizacion();
        System.out.println("PC:");
        pc.visualizacion();
        if (ganaJugador) {
            System.out.println("¡Ganaste!");
        } else if (ganaPC) {
            System.out.println("¡Perdiste!");
        } else {
            System.out.println("Empate");
        }
    }
}

class Cuadricula2 {
    private char[][] tabla;
    private final char AGUA = '-';
    private final char BARCO = 'B';
    private final char TOCADO = 'X';
    private final char HUNDIDO = 'O';

    public Cuadricula2() {
        tabla = new char[10][10];
        for (char[] fila : tabla) {
            Arrays.fill(fila, AGUA);
        }
    }

    public void depositarBarco(int fila, int columna) {
        tabla[fila][columna] = BARCO;
    }

    public boolean disparar(int fila, int columna) {
        if (tabla[fila][columna] == BARCO) {
            tabla[fila][columna] = TOCADO;
            if (barcoHundido()) {
                return true;
            }
        } else if (tabla[fila][columna] == AGUA)
            tabla[fila][columna] = 'M';
        return false;
    }

    public boolean barcoHundido() {
        for (char[] fila : tabla) {
            for (char celda : fila) {
                if (celda == BARCO) {
                    return false;
                }
            }
        }
        return true;
    }

    public void visualizacion() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j] == BARCO || tabla[i][j] == AGUA) {
                    System.out.print(tabla[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
