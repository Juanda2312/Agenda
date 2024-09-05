package co.edu.uniquindio.poo.application;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;


public class App {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10, 10, 10);
        Contacto contacto1 = new Contacto("Pedro", "El pepe", "MZ f", "5555", "akwdjkas@gmail.com");
        Contacto contacto2 = new Contacto("Paco", "El calvo", "MZ D", "5535", "sawdsakas@gmail.com");
        Contacto contacto3 = new Contacto("Pepe", "El gordo", "Mz h", "454545", "si");
        agenda.crearcontacto(contacto1);
        agenda.crearcontacto(contacto2);
        agenda.crearcontacto(contacto3);
        System.out.println(contacto1.toString());
        agenda.imprimirnombresalreves();
        //System.out.println(agenda.desviacionedades());
        //agenda.ImprimirContactosalreves();
        Grupo grupo1 = new Grupo("Los reales", Categoria.AMIGOS);
        grupo1.agregar_contacto(contacto1);
        grupo1.agregar_contacto(contacto2);
        //JOptionPane.showMessageDialog(null, grupo1.toString(), grupo1.getNombre(), 0);
        //Reunion reunion = new Reunion("Fiesta donde paco", null, null, 12);
    }
}
