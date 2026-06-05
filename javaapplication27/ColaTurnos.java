/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;
import java.util.LinkedList;
import java.util.Queue;

class ColaTurnos {

    // COLA preferencial y normal
    private Queue<Cliente> colaPreferencial = new LinkedList<>();
    private Queue<Cliente> colaNormal       = new LinkedList<>();

    public void agregar(Cliente c) {
        if (c.getTipoAtencion().equals("PREFERENCIAL")) {
            colaPreferencial.add(c);
        } else if (c.getTipoAtencion().equals("NORMAL")) {
            colaNormal.add(c);
        }
    }

    public Cliente llamarSiguiente() {
        if (!colaPreferencial.isEmpty()) return colaPreferencial.poll();
        if (!colaNormal.isEmpty())       return colaNormal.poll();
        return null;
    }

    public void devolverCliente(Cliente c) {
        if (c.getTipoAtencion().equals("PREFERENCIAL")) {
            colaPreferencial.add(c);
        } else {
            colaNormal.add(c);
        }
    }

    public int totalEsperaPreferencial() { return colaPreferencial.size(); }
    public int totalEscperaNormal()      { return colaNormal.size(); }
}