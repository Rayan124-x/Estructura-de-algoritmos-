/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listasenlazadas;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
class Nodo {
    int dato;
    Nodo siguiente;

    // Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {

    Nodo cabeza;

    // 1. Crear lista vacía
    public ListaEnlazada() {
        cabeza = null;
    }

    // 2. Insertar nodo al final
    public void insertar(int dato) {

        Nodo nuevo = new Nodo(dato);

        // Verificar si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        // Recorrer hasta el último nodo
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        // Enlazar nuevo nodo
        actual.siguiente = nuevo;
    }

    // 3. Eliminar un nodo
    public void eliminar(int dato) {

        // Verificar que la lista no esté vacía
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        // Si el nodo a eliminar es la cabeza
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;

        // Buscar el nodo anterior al que se eliminará
        while (actual.siguiente != null &&
               actual.siguiente.dato != dato) {

            actual = actual.siguiente;
        }

        // Verificar si el dato existe
        if (actual.siguiente == null) {
            System.out.println("Elemento no encontrado");
            return;
        }

        // Eliminar nodo
        actual.siguiente = actual.siguiente.siguiente;
    }

    // 4. Mostrar lista
    public void mostrar() {

        Nodo actual = cabeza;

        // Verificar puntero antes de acceder
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }
}

public class Main {

    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        // Insertar elementos
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.insertar(40);
        lista.insertar(50);
        lista.insertar(60);
        lista.insertar(70);


        System.out.println("Lista original:");
        lista.mostrar();

        // Eliminar elemento
        lista.eliminar(50);

        System.out.println("Lista despues de eliminar 50:");
        lista.mostrar();
    }
}
