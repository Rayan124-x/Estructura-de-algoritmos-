/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasenlazadas;

/**
 *
 * @author Usuario
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

class ListaEnlazadaSimple {

    Nodo cabeza;

    // Crear lista vacía
    public ListaEnlazadaSimple() {
        cabeza = null;
    }

    // Insertar al inicio
    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        System.out.println("Insertado al inicio: " + dato);
    }

    // Insertar al final
    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            // Recorrer hasta el último nodo
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        System.out.println("Insertado al final: " + dato);
    }

    // Insertar después de un valor específico
    public void insertarDespues(int valorBuscado, int nuevoDato) {

        Nodo actual = cabeza;

        while (actual != null && actual.dato != valorBuscado) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Valor no encontrado");
            return;
        }

        Nodo nuevo = new Nodo(nuevoDato);

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;

        System.out.println("Insertado " + nuevoDato +
                           " después de " + valorBuscado);
    }

    // Eliminar al inicio
    public void eliminarInicio() {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        System.out.println("Eliminado: " + cabeza.dato);

        cabeza = cabeza.siguiente;
    }

    // Eliminar por valor
    public void eliminar(int dato) {

        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        // Si el dato está en el primer nodo
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            System.out.println("Eliminado: " + dato);
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null &&
               actual.siguiente.dato != dato) {

            actual = actual.siguiente;
        }

        // Si no existe
        if (actual.siguiente == null) {
            System.out.println("Dato no encontrado");
            return;
        }

        actual.siguiente = actual.siguiente.siguiente;

        System.out.println("Eliminado: " + dato);
    }

    // Buscar elemento
    public boolean buscar(int dato) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.dato == dato) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar lista
    public void mostrar() {

        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza;

        System.out.print("Lista: ");

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("NULL");
    }
}

public class ListasEnlazadas {

    public static void main(String[] args) {

        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // Insertar elementos
        lista.insertarInicio(10);
        lista.insertarInicio(5);

        lista.insertarFinal(20);
        lista.insertarFinal(30);

        lista.mostrar();

        // Insertar después
        lista.insertarDespues(20, 25);

        lista.mostrar();

        // Buscar elemento
        if (lista.buscar(25)) {
            System.out.println("25 sí existe");
        } else {
            System.out.println("25 no existe");
        }

        // Eliminar elementos
        lista.eliminarInicio();

        lista.mostrar();

        lista.eliminar(20);

        lista.mostrar();
    }
}
