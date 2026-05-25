/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

// ==========================
// NODO DOBLE
// ==========================
class NodoDoble {

    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

// ==========================
// LISTA DOBLEMENTE ENLAZADA
// ==========================
class ListaDoble {

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

        System.out.print("Lista Doble: ");

        if (inicio == null) {
            System.out.println("vacia");
            return;
        }

        NodoDoble aux = inicio;

        while (aux != null) {
            System.out.print(aux.dato + " <-> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }

    // Eliminar numero
    public void eliminar(int dato) {

        if (inicio == null) {
            System.out.println("Lista doble vacia");
            return;
        }

        NodoDoble aux = inicio;

        while (aux != null && aux.dato != dato) {
            aux = aux.siguiente;
        }

        if (aux == null) {
            System.out.println("Numero no encontrado");
            return;
        }

        // Si es el primero
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

        System.out.println("Numero eliminado de lista doble");
    }
}

// ==========================
// NODO CIRCULAR
// ==========================
class NodoCircular {

    int dato;
    NodoCircular siguiente;

    public NodoCircular(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// ==========================
// LISTA CIRCULAR SIMPLE
// ==========================
class ListaCircular {

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
            System.out.println("Lista circular vacia");
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

                System.out.println("Numero eliminado de lista circular");
                return;
            }

            anterior = actual;
            actual = actual.siguiente;

        } while (actual != ultimo.siguiente);

        System.out.println("Numero no encontrado");
    }
}

// ==========================
// CLASE PRINCIPAL
// ==========================
public class Doble_Circular{

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
            System.out.println("5. Mostrar listas");
            System.out.println("6. Salir");

            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese numeros separados por espacio:");
                    String numerosDoble = sc.nextLine();

                    listaDoble.insertarVarios(numerosDoble);

                    System.out.println();
                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 2:

                    System.out.print("Numero a eliminar: ");
                    int eliminarDoble = Integer.parseInt(sc.nextLine());

                    listaDoble.eliminar(eliminarDoble);

                    System.out.println();
                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 3:

                    System.out.println("Ingrese numeros separados por espacio:");
                    String numerosCircular = sc.nextLine();

                    listaCircular.insertarVarios(numerosCircular);

                    System.out.println();
                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 4:

                    System.out.print("Numero a eliminar: ");
                    int eliminarCircular = Integer.parseInt(sc.nextLine());

                    listaCircular.eliminar(eliminarCircular);

                    System.out.println();
                    listaDoble.mostrar();
                    listaCircular.mostrar();

                    break;

                case 5:

                    System.out.println();
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