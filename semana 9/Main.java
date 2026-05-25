/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keler
 */
// ==========================
// CLASE Main.java
// ==========================
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaDoble listaDoble = new ListaDoble();
        ListaCircular listaCircular = new ListaCircular();

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Agregar numeros Lista Doble");
            System.out.println("2. Eliminar numero Lista Doble");
            System.out.println("3. Agregar numeros Lista Circular");
            System.out.println("4. Eliminar numero Lista Circular");
            System.out.println("5. Mostrar todas las listas");
            System.out.println("6. Salir");

            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese numeros separados por espacio:");
                    String numerosDoble = sc.nextLine();

                    listaDoble.insertarVarios(numerosDoble);

                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 2:

                    System.out.print("Numero a eliminar: ");
                    int eliminarDoble = Integer.parseInt(sc.nextLine());

                    listaDoble.eliminar(eliminarDoble);

                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 3:

                    System.out.println("Ingrese numeros separados por espacio:");
                    String numerosCircular = sc.nextLine();

                    listaCircular.insertarVarios(numerosCircular);

                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 4:

                    System.out.print("Numero a eliminar: ");
                    int eliminarCircular = Integer.parseInt(sc.nextLine());

                    listaCircular.eliminar(eliminarCircular);

                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 5:

                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 6:

                    System.out.println("Programa terminado");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6);

        sc.close();
    }
}