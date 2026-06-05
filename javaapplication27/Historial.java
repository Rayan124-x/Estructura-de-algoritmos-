/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;
import java.util.Stack;

class Historial {

    // PILA de atendidos
    private Stack<Cliente> pila = new Stack<>();

    public void apilar(Cliente c) {
        pila.push(c);
    }

    public Cliente desapilar() {
        if (!pila.isEmpty()) return pila.pop();
        return null;
    }

    public void mostrarHistorial() {
        System.out.println("\n------------------------------------------");
        System.out.println("|         HISTORIAL DE ATENDIDOS         |");
        System.out.println("------------------------------------------");
        if (pila.isEmpty()) {
            System.out.println("| Sin atendidos aun.                     |");
        } else {
            Stack<Cliente> copia = new Stack<>();
            copia.addAll(pila);
            int pos = copia.size();
            while (!copia.isEmpty()) {
                Cliente c = copia.pop();
                System.out.printf("| %d. %-10s | Turno: %-10s |%n",
                        pos--, c.getNombre(), c.getTurno());
            }
        }
        System.out.println("------------------------------------------\n");
    }

    public int total() { return pila.size(); }
}