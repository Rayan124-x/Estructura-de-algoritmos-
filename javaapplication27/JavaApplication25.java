/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication27;
import java.util.Scanner;

public class JavaApplication25 {

    public static void main(String[] args) {

        Scanner sc       = new Scanner(System.in);
        Registro reg     = new Registro();
        ColaTurnos cola  = new ColaTurnos();
        Historial hist   = new Historial();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("------------------------------");
            System.out.println("|      BANCO NACIONAL        |");
            System.out.println("------------------------------");
            System.out.println("| 1. Registrar cliente       |");
            System.out.println("| 2. Llamar siguiente turno  |");
            System.out.println("| 3. Deshacer ultimo turno   |");
            System.out.println("| 4. Ver todos los clientes  |");
            System.out.println("| 5. Ver historial atendidos |");
            System.out.println("| 6. Ver denegados           |");
            System.out.println("| 7. Ver reporte final       |");
            System.out.println("| 8. Salir                   |");
            System.out.println("------------------------------");
            System.out.print("Seleccione una opcion: ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("! Ingrese un numero valido.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("| 1. Deposito  2. Retiro  3. Consulta |");
                    System.out.print("Seleccione operacion: ");
                    String operacion;
                    try {
                        int op = Integer.parseInt(sc.nextLine().trim());
                        switch (op) {
                            case 1: operacion = "Deposito"; break;
                            case 2: operacion = "Retiro";   break;
                            case 3: operacion = "Consulta"; break;
                            default: System.out.println("! Opcion no valida.\n"); continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("! Ingrese un numero valido.\n");
                        continue;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("! Nombre vacio.\n");
                        continue;
                    }

                    System.out.print("Edad: ");
                    int edad;
                    try {
                        edad = Integer.parseInt(sc.nextLine().trim());
                        if (edad < 0 || edad > 120) {
                            System.out.println("! Edad invalida.\n");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("! Ingrese una edad valida.\n");
                        continue;
                    }

                    // Registro crea al cliente
                    Cliente c = reg.crearCliente(nombre, edad, operacion);
                    c.mostrarTicket();

                    // Cola lo agrega si no es denegado
                    if (!c.getTipoAtencion().equals("DENEGADO")) {
                        cola.agregar(c);
                    }
                    break;

                case 2:
                    Cliente atendido = cola.llamarSiguiente();
                    if (atendido != null) {
                        hist.apilar(atendido);  // Pila guarda al atendido
                        System.out.println("\n>> LLAMANDO: "
                                + atendido.getTurno() + " - " + atendido.getNombre());
                    } else {
                        System.out.println("\n! No hay clientes en espera.");
                    }
                    break;

                case 3:
                    Cliente devuelto = hist.desapilar();  // Pila devuelve el ultimo
                    if (devuelto != null) {
                        cola.devolverCliente(devuelto);   // Cola lo readmite
                        System.out.println("\n>> Deshecho: "
                                + devuelto.getTurno() + " - " + devuelto.getNombre());
                    } else {
                        System.out.println("\n! No hay turnos para deshacer.");
                    }
                    break;

                case 4: reg.mostrarTodos();     break;
                case 5: hist.mostrarHistorial(); break;
                case 6: reg.mostrarDenegados(); break;

                case 7:
                    int[] cont = reg.getContadores();
                    System.out.println("\n------------------------------------------");
                    System.out.println("|             REPORTE FINAL              |");
                    System.out.println("------------------------------------------");
                    System.out.printf("| %-22s : %-14s |%n", "Total registrados",  reg.totalRegistrados());
                    System.out.printf("| %-22s : %-14s |%n", "Atendidos",          hist.total());
                    System.out.printf("| %-22s : %-14s |%n", "Espera Preferencial",cola.totalEsperaPreferencial());
                    System.out.printf("| %-22s : %-14s |%n", "Espera Normal",      cola.totalEscperaNormal());
                    System.out.printf("| %-22s : %-14s |%n", "Denegados",          reg.totalDenegados());
                    System.out.println("------------------------------------------");
                    System.out.printf("| %-22s : %-14s |%n", "Depositos",  cont[0]);
                    System.out.printf("| %-22s : %-14s |%n", "Retiros",    cont[1]);
                    System.out.printf("| %-22s : %-14s |%n", "Consultas",  cont[2]);
                    System.out.println("------------------------------------------\n");
                    break;

                case 8:
                    System.out.println("Sistema cerrado. Hasta luego!");
                    ejecutando = false;
                    break;

                default:
                    System.out.println("! Opcion no valida.\n");
            }
        }
        sc.close();
    }
}