//Juego de dados
import java.util.Random;

public class ejercicio1 {
    private int numCaras;
    private int ultimaCara;

    // Constructor que crea un dado de seis caras
    public ejercicio1() {
        this.numCaras = 6;
        this.ultimaCara = 1;
    }

    // Constructor que recibe como argumento el número de caras para el dado a crear
    public ejercicio1(int numCaras) {
        this.numCaras = numCaras;
        this.ultimaCara = 1;
    }

    // Métodos getter para los dos atributos
    public int getNumCaras() {
        return numCaras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    // Método setter solo para cambiar el número de caras
    public void setNumCaras(int numCaras) {
        this.numCaras = numCaras;
    }

    // Método de instancia que permite simular la tirada de los dados
    public int tirarDado() {
        Random rand = new Random();
        ultimaCara = rand.nextInt(numCaras) + 1;
        return ultimaCara;
    }
}

// Algoritmo principal para crear tres dados y lanzarlos hasta que la suma de los dados sea mayor o igual a veinte
class Main {
    public static void main(String[] args) {
        ejercicio1 dado1 = new ejercicio1();
        ejercicio1 dado2 = new ejercicio1(10);
        ejercicio1 dado3 = new ejercicio1(12);

        int sumaDados = 0;
        while (sumaDados < 20) {
            int valorDado1 = dado1.tirarDado();
            int valorDado2 = dado2.tirarDado();
            int valorDado3 = dado3.tirarDado();
            sumaDados = valorDado1 + valorDado2 + valorDado3;
            System.out.println("Dado 1: " + valorDado1 + " | Dado 2: " + valorDado2 + " | Dado 3: " + valorDado3);
        }
        System.out.println("La suma de los dados es mayor o igual a 20");
    }
}
