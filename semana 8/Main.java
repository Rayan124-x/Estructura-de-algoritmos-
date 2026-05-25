/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keler
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaSimple lista1 = new ListaSimple();
        ListaSimple lista2 = new ListaSimple();

        int opcion;

        do {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Agregar lista");
            System.out.println("2. Agregar numero");
            System.out.println("3. Eliminar numero");
            System.out.println("4. Mostrar listas");
            System.out.println("5. Fusionar listas");
            System.out.println("6. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =========================
                // AGREGAR LISTA
                // =========================

                case 1:

                    System.out.print("A que lista? (1 o 2): ");
                    int listaAgregar = sc.nextInt();
                    sc.nextLine();

                    System.out.println(
                            "Ingrese numeros separados por espacios:");

                    String linea = sc.nextLine();

                    String[] numeros = linea.split(" ");

                    for (String num : numeros) {

                        int dato = Integer.parseInt(num);

                        if (listaAgregar == 1) {
                            lista1.agregar(dato);
                        } else {
                            lista2.agregar(dato);
                        }
                    }

                    mostrarListas(lista1, lista2);

                    break;

                // =========================
                // AGREGAR NUMERO
                // =========================

                case 2:

                    System.out.print("A que lista? (1 o 2): ");
                    int listaNum = sc.nextInt();

                    System.out.print("Ingrese numero: ");
                    int nuevo = sc.nextInt();

                    if (listaNum == 1) {
                        lista1.agregar(nuevo);
                    } else {
                        lista2.agregar(nuevo);
                    }

                    mostrarListas(lista1, lista2);

                    break;

                // =========================
                // ELIMINAR NUMERO
                // =========================

                case 3:

                    System.out.print("De que lista? (1 o 2): ");
                    int listaEliminar = sc.nextInt();

                    System.out.print("Numero a eliminar: ");
                    int eliminar = sc.nextInt();

                    if (listaEliminar == 1) {
                        lista1.eliminar(eliminar);
                    } else {
                        lista2.eliminar(eliminar);
                    }

                    mostrarListas(lista1, lista2);

                    break;

                // =========================
                // MOSTRAR LISTAS
                // =========================

                case 4:

                    mostrarListas(lista1, lista2);

                    break;

                // =========================
                // FUSIONAR LISTAS
                // =========================

                case 5:

                    ListaSimple fusionada =
                            ListaSimple.fusionar(lista1, lista2);

                    System.out.println("\nLista fusionada:");
                    fusionada.mostrar();

                    ListaSimple fusionadaInversa =
                            fusionada.copiar();

                    fusionadaInversa.invertir();

                    System.out.println(
                            "Lista fusionada inversa:");

                    fusionadaInversa.mostrar();

                    break;

                case 6:

                    System.out.println("Programa finalizado");

                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6);

        sc.close();
    }

    // Metodo para mostrar listas e inversas
    public static void mostrarListas(
            ListaSimple lista1,
            ListaSimple lista2) {

        System.out.println("\nLista 1:");
        lista1.mostrar();

        ListaSimple inversa1 = lista1.copiar();
        inversa1.invertir();

        System.out.println("Lista 1 inversa:");
        inversa1.mostrar();

        System.out.println("\nLista 2:");
        lista2.mostrar();

        ListaSimple inversa2 = lista2.copiar();
        inversa2.invertir();

        System.out.println("Lista 2 inversa:");
        inversa2.mostrar();
    }
}