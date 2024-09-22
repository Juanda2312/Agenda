package co.edu.uniquindio.poo.application;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Agenda agenda = new Agenda(10, 10, 10);
        Contacto contacto1 = new Contacto("Pedro", "El pepe", "MZ f", "5555", "akwdjkas@gmail.com");
        Contacto contacto2 = new Contacto("Paco", "El calvo", "MZ D", "5535", "sawdsakas@gmail.com");
        Contacto contacto3 = new Contacto("Pepe", "El gordo", "Mz h", "454545", "si");
        agenda.crearcontacto(contacto1);
        agenda.crearcontacto(contacto2);
        agenda.crearcontacto(contacto3);
        JOptionPane.showMessageDialog(null, agenda.listacontactostoString(), null, 0);
        agenda.OrdenamientoBurbujaEdadContactos();
        JOptionPane.showMessageDialog(null, agenda.listacontactostoString(), null, 0);
        System.out.println(contacto1.toString());
        agenda.imprimirnombresalreves();
        //System.out.println(agenda.desviacionedades());
        //agenda.ImprimirContactosalreves();
        Grupo grupo1 = new Grupo("Los reales", Categoria.AMIGOS);
        grupo1.agregar_contacto(contacto1);
        grupo1.agregar_contacto(contacto2);
        try {
            Date fecha = sdf.parse("05-11-2022");
            Reunion reunion1 = new Reunion("Fiesta", fecha, null, 2);
            fecha = sdf.parse("23-11-2022");
            Reunion reunion2 = new Reunion("Party", fecha, null, 5);
            agenda.crearreunion(reunion1);
            agenda.crearreunion(reunion2);
            System.out.println(agenda.matrizreuniones());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null, grupo1.toString(), grupo1.getNombre(), 0);
        //Reunion reunion = new Reunion("Fiesta donde paco", null, null, 12);
        JOptionPane.showMessageDialog(null, caracterestostring(), "Frase;", 0);
    }

    public static String caracterestostring(){
        char[] caracteres = caracteres();
        String mensaje = "[";
        for (int i = 0; i < caracteres.length; i++) {
            mensaje+= caracteres[i] + " ";
        }
        mensaje+= "]";
        return mensaje;

    }
    
    public static char[] caracteres(){
        String frase = JOptionPane.showInputDialog("Escribe la frase");
        char[] caracteres = new char[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            caracteres[i] = frase.charAt(i);
        }
        return caracteres;
    }

}
