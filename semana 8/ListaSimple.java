public class ListaSimple {

    Nodo cabeza;

    // Agregar numero
    public void agregar(int dato) {

        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo temp = cabeza;

        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {

        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }

        Nodo temp = cabeza;

        while (temp != null) {

            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }

        System.out.println("null");
    }

    // Eliminar numero
    public void eliminar(int dato) {

        if (cabeza == null) {
            return;
        }

        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo temp = cabeza;

        while (temp.siguiente != null &&
               temp.siguiente.dato != dato) {

            temp = temp.siguiente;
        }

        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    // Invertir lista
    public void invertir() {

        Nodo anterior = null;
        Nodo actual = cabeza;

        while (actual != null) {

            Nodo siguiente = actual.siguiente;

            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // Copiar lista
    public ListaSimple copiar() {

        ListaSimple copia = new ListaSimple();

        Nodo temp = cabeza;

        while (temp != null) {

            copia.agregar(temp.dato);
            temp = temp.siguiente;
        }

        return copia;
    }

    // Fusionar listas
    public static ListaSimple fusionar(
            ListaSimple l1,
            ListaSimple l2) {

        ListaSimple fusionada = new ListaSimple();

        Nodo a = l1.cabeza;
        Nodo b = l2.cabeza;

        while (a != null) {

            fusionada.agregar(a.dato);
            a = a.siguiente;
        }

        while (b != null) {

            fusionada.agregar(b.dato);
            b = b.siguiente;
        }

        return fusionada;
    }
}