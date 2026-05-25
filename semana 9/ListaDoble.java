/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keler
 */
// ==========================
// CLASE ListaDoble.java
// ==========================
public class ListaDoble {

    private NodoDoble inicio;

    // Insertar un numero
    public void insertar(int dato) {

        NodoDoble nuevo = new NodoDoble(dato);

        if (inicio == null) {
            inicio = nuevo;
        } else {

            NodoDoble aux = inicio;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
            nuevo.anterior = aux;
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

        NodoDoble aux = inicio;

        System.out.print("Lista Doble: ");

        if (inicio == null) {
            System.out.println("vacia");
            return;
        }

        while (aux != null) {
            System.out.print(aux.dato + " <-> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }

    // Eliminar nodo
    public void eliminar(int dato) {

        if (inicio == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoDoble aux = inicio;

        while (aux != null && aux.dato != dato) {
            aux = aux.siguiente;
        }

        if (aux == null) {
            System.out.println("Dato no encontrado");
            return;
        }

        // Primer nodo
        if (aux == inicio) {

            inicio = inicio.siguiente;

            if (inicio != null) {
                inicio.anterior = null;
            }

        } else {

            aux.anterior.siguiente = aux.siguiente;

            if (aux.siguiente != null) {
                aux.siguiente.anterior = aux.anterior;
            }
        }

        System.out.println("Numero eliminado");
    }
}