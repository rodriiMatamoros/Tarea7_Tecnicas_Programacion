/*Para las necesidades de un sitio de venta online de libros de informática, ediciones ENI por
 ejemplo, se pide crear una clase que permita modelizar a un cliente. Todos los clientes tienen
  un nombre y se les debe asignar un número de cliente. También se pide escribir un algoritmo 
  de prueba para capturar y mostrar clientes. */

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int contadorClientes = 0;

        while (opcion != 3) {
            System.out.println("-- Menú --");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear un cliente");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-- Clientes --");
                    for (Cliente cliente : listaClientes) {
                        System.out.println(cliente);
                    }
                    break;

                case 2:
                    sc.nextLine(); // Limpiar buffer de entrada
                    System.out.print("¿Nombre del cliente? ");
                    String nombreCliente = sc.nextLine();
                    contadorClientes++;
                    Cliente nuevoCliente = new Cliente(contadorClientes, nombreCliente);
                    listaClientes.add(nuevoCliente);
                    System.out.println("Cliente n.°" + contadorClientes + " [" + nombreCliente + "] añadido");
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
        sc.close();
    }
}

class Cliente {
    private int numeroCliente;
    private String nombreCliente;

    public Cliente(int numeroCliente, String nombreCliente) {
        this.numeroCliente = numeroCliente;
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String toString() {
        return "Cliente n.°" + numeroCliente + " [" + nombreCliente + "]";
    }
}
