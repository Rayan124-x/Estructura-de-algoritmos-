/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Registro {

    // ARREGLO DINÁMICO de todos los clientes
    private ArrayList<Cliente> todos = new ArrayList<>();

    // LISTA de denegados
    private List<Cliente> denegados = new LinkedList<>();

    // ARREGLO ESTÁTICO contador por operacion
    private int[] contadorOperaciones = new int[3];

    private int contador = 1;

    public Cliente crearCliente(String nombre, int edad, String operacion) {
        Cliente c = new Cliente(nombre, edad, operacion, contador++);

        todos.add(c);

        switch (operacion) {
            case "Deposito":  contadorOperaciones[0]++; break;
            case "Retiro":    contadorOperaciones[1]++; break;
            case "Consulta":  contadorOperaciones[2]++; break;
        }

        if (c.getTipoAtencion().equals("DENEGADO")) {
            denegados.add(c);
        }

        return c;
    }

    public void mostrarTodos() {
        System.out.println("\n------------------------------------------");
        System.out.println("|       TODOS LOS CLIENTES REGISTRADOS  |");
        System.out.println("------------------------------------------");
        if (todos.isEmpty()) {
            System.out.println("| Sin registros aun.                     |");
        } else {
            for (int i = 0; i < todos.size(); i++) {
                Cliente c = todos.get(i);
                System.out.printf("| %d. %-10s | %-10s | %-8s |%n",
                        i + 1, c.getNombre(), c.getOperacion(), c.getTipoAtencion());
            }
        }
        System.out.println("------------------------------------------\n");
    }

    public void mostrarDenegados() {
        System.out.println("\n------------------------------------------");
        System.out.println("|          CLIENTES DENEGADOS            |");
        System.out.println("------------------------------------------");
        if (denegados.isEmpty()) {
            System.out.println("| Ninguno.                               |");
        } else {
            for (Cliente c : denegados) {
                System.out.printf("| %-20s | Menor de edad  |%n", c.getNombre());
            }
        }
        System.out.println("------------------------------------------\n");
    }

    public int totalRegistrados()  { return todos.size(); }
    public int totalDenegados()    { return denegados.size(); }
    public int[] getContadores()   { return contadorOperaciones; }
}