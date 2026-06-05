/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Cliente {

    private String nombre;
    private int edad;
    private int numeroCliente;
    private String operacion;
    private String tipoAtencion;
    private String turno;

    public Cliente(String nombre, int edad, String operacion, int numero) {
        this.nombre = nombre;
        this.edad = edad;
        this.operacion = operacion;
        this.numeroCliente = numero;
        this.tipoAtencion = clasificarCliente();
        this.turno = generarTurno();
    }

    private String clasificarCliente() {
        if (edad < 18) return "DENEGADO";
        else if (edad >= 60) return "PREFERENCIAL";
        else return "NORMAL";
    }

    private String generarTurno() {
        if (tipoAtencion.equals("PREFERENCIAL")) return String.format("P-%03d", numeroCliente);
        else if (tipoAtencion.equals("NORMAL"))  return String.format("N-%03d", numeroCliente);
        else return "---";
    }

    public String getTipoAtencion() { return tipoAtencion; }
    public String getTurno()        { return turno; }
    public String getNombre()       { return nombre; }
    public String getOperacion()    { return operacion; }

    public void mostrarTicket() {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("\n------------------------------------------");
        System.out.println("|          BANCO NACIONAL                |");
        System.out.println("|     SISTEMA DE ATENCION AL CLIENTE     |");
        System.out.println("------------------------------------------");
        System.out.printf("| %-18s : %-18s |%n", "Fecha y Hora",  fechaHora.format(formato));
        System.out.printf("| %-18s : %-18s |%n", "Turno",         turno);
        System.out.printf("| %-18s : %-18s |%n", "Nombre",        nombre);
        System.out.printf("| %-18s : %-18s |%n", "Edad",          edad + " anos");
        System.out.printf("| %-18s : %-18s |%n", "Operacion",     operacion);
        System.out.printf("| %-18s : %-18s |%n", "Tipo Atencion", tipoAtencion);
        System.out.println("------------------------------------------");

        if (tipoAtencion.equals("DENEGADO")) {
            System.out.printf("| %-18s : %-18s |%n", "Estado", "ACCESO DENEGADO");
            System.out.printf("| %-18s : %-18s |%n", "Motivo", "Menor de edad");
        } else {
            System.out.printf("| %-18s : %-18s |%n", "Estado",  "REGISTRADO");
            System.out.printf("| %-18s : %-18s |%n", "Mensaje", "Espere su llamado");
        }

        System.out.println("------------------------------------------");
        System.out.println("|  Gracias por confiar en nuestro banco  |");
        System.out.println("|      www.banconacional.com.pe          |");
        System.out.println("------------------------------------------\n");
    }
}
