/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keler
 */
// ==========================
// CLASE ListaCircular.java
// ==========================
public class ListaCircular {

    private NodoCircular ultimo;

    // Insertar un numero
    public void insertar(int dato) {

        NodoCircular nuevo = new NodoCircular(dato);

        if (ultimo == null) {

            ultimo = nuevo;
            ultimo.siguiente = ultimo;

        } else {

            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    // Insertar varios numeros
    public void insertarVarios(String numeros) {

        String[] datos = numeros.split(" ");

        for (String n : datos) {
            insertar(Integer.parseInt(n));
        }
    }

    // Mostrar lista
    public void mostrar() {

        System.out.print("Lista Circular: ");

        if (ultimo == null) {
            System.out.println("vacia");
            return;
        }

        NodoCircular aux = ultimo.siguiente;

        do {

            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;

        } while (aux != ultimo.siguiente);

        System.out.println("(inicio)");
    }

    // Eliminar numero
    public void eliminar(int dato) {

        if (ultimo == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoCircular actual = ultimo.siguiente;
        NodoCircular anterior = ultimo;

        do {

            if (actual.dato == dato) {

                // Solo un nodo
                if (actual == ultimo && actual == ultimo.siguiente) {
                    ultimo = null;
                }

                // Eliminar ultimo
                else if (actual == ultimo) {
                    anterior.siguiente = actual.siguiente;
                    ultimo = anterior;
                }

                // Nodo normal
                else {
                    anterior.siguiente = actual.siguiente;
                }

                System.out.println("Numero eliminado");
                return;
            }

            anterior = actual;
            actual = actual.siguiente;

        } while (actual != ultimo.siguiente);

        System.out.println("Dato no encontrado");
    }
}