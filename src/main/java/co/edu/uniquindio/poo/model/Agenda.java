package co.edu.uniquindio.poo.model;

import java.util.Arrays;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Agenda {
    public Contacto listacontactos[];
    public Grupo listagrupos[];
    public Reunion listareuniones[]; 

    public Agenda(int numerocontactos, int numerogrupos, int numeroreuniones){        
        this.listacontactos = new Contacto[numerocontactos];
        this.listagrupos = new Grupo[numerogrupos];
        this.listareuniones = new Reunion[numeroreuniones];
    }

    /***
     * Crea un contacto siempre y cuando no exista un contacto con el mismo nombre y telefono
     * @param contactonuevo
     * @return
     */
    public String crearcontacto(Contacto contactonuevo){
        String mensaje = "";
        int posiciondisponible = 0;
        Contacto contactoencontrado = null;
        posiciondisponible = buscarposiciondisponiblecontactos();
        if (posiciondisponible == -1){
            mensaje = "No hay cupo disponible";
        }else{
            contactoencontrado = buscarContacto(contactonuevo);
            if (contactoencontrado != null){
                mensaje = "Este contacto ya está registrado";
            }else{
                listacontactos[posiciondisponible] = contactonuevo;
                mensaje = "El contacto a sido agregado correctamente";
            }
        }
        return mensaje;
    }
    /**
     * busca un contacto a partir de su nombre y telefono
     * @param contactonuevo
     * @return
     */
    public Contacto buscarContacto(Contacto contactonuevo){
        Contacto contactoencontrado = null;
        for (Contacto Contacto1 : listacontactos) {
            if (contactonuevo.equals(Contacto1)){
                contactoencontrado = Contacto1;
                return contactoencontrado;
            }
        }
        return contactoencontrado;
}

/**
 * Busca si existe una posicion disponible en la lista de contactos 
 * @return
 */
private int buscarposiciondisponiblecontactos(){
    int posiciondisponible = -1;
    for (int i = 0; i < listacontactos.length; i++) {
        Contacto contacto = listacontactos[i];
        if (contacto == null){
            posiciondisponible = i;
            return posiciondisponible;
        }
    }
    return posiciondisponible;
}
/**
 * Elimina un contacto
 * @param indice
 * @return
 */
public String EliminarContacto(Contacto contactonuevo){
    String mensaje = "Este contacto no existe";
    for (int i = 0; i < listacontactos.length; i++) {
        Contacto contactoactual = listacontactos[i];
        if (contactonuevo.equals(contactoactual)) {
            listacontactos [i] = null;
            mensaje = "El contacto a sido eliminado";
            break;
        }
    }
    return mensaje;

}
/**
 * Actualiza toda la información de un contacto siempre y cuando este exista
 * @param nombre
 * @param alias
 * @param direccion
 * @param telefono
 * @param email
 * @param indice
 * @return
 */
public String ActualizarContacto(String nombre, String alias, String direccion, String telefono, String email,int edad, Contacto contactonuevo){
    String mensaje = "El contacto no existe";
    Contacto contactoencontrado = buscarContacto(contactonuevo);
    if (contactoencontrado != null){
        contactoencontrado.setNombre(nombre);
        contactoencontrado.setAlias(alias);
        contactoencontrado.setDireccion(direccion);
        contactoencontrado.setTelefono(telefono);
        contactoencontrado.setEmail(email);
        contactoencontrado.setEdad(edad);
        mensaje = "El contacto a sido actualizado";
    } 
    return mensaje;
}

    public String creargrupo(Grupo gruponuevo){
        String mensaje = "";
        int posiciondisponible = 0;
        Grupo grupoencontrado = null;
        posiciondisponible = buscarposiciondisponiblegrupo();
        if (posiciondisponible == -1){
            mensaje = "No hay cupo disponible";
        }else{
            grupoencontrado = buscargrupo(gruponuevo);
            if (grupoencontrado != null){
                mensaje = "Este grupo ya está registrado";
            }else{
                listagrupos[posiciondisponible] = gruponuevo;
                mensaje = "El grupo a sido agregado correctamente";
            }
        }
        return mensaje;
    }
    
    public Grupo buscargrupo(Grupo gruponuevo){
        Grupo grupoencontrado = null;
        for (Grupo grupo1 : listagrupos) {
            if (gruponuevo.equals(grupo1)){
                grupoencontrado = grupo1;
                return grupoencontrado;
            }
        }
        return grupoencontrado;
}

private int buscarposiciondisponiblegrupo(){
    int posiciondisponible = -1;
    for (int i = 0; i < listagrupos.length; i++) {
        Grupo grupo = listagrupos[i];
        if (grupo == null){
            posiciondisponible = i;
            return posiciondisponible;
        }
    }
    return posiciondisponible;
}

public String EliminarGrupo(Grupo gruponuevo){
    String mensaje = "Este grupo no existe";
    for (int i = 0; i < listagrupos.length; i++) {
        Grupo grupo = listagrupos[i];
        if (gruponuevo.equals(grupo)) {
            listagrupos [i] = null;
            mensaje = "El grupo a sido eliminado";
            break;
        }
    }
    return mensaje;

}

public String Actualizargrupo(String nombre,Categoria categoria, Grupo gruponuevo){
    String mensaje = "El grupo no existe";
    Grupo grupoencontrado = buscargrupo(gruponuevo);
    if (grupoencontrado != null){
        grupoencontrado.setNombre(nombre);
        grupoencontrado.setCategoria(categoria);
        mensaje = "El grupo a sido actualizado";
    } 
    return mensaje;
}
public String crearreunion(Reunion reunionnueva){
    String mensaje = "";
    int posiciondisponible = 0;
    Reunion reunionencontrada = null;
    posiciondisponible = buscarposiciondisponiblereunion();
    if (posiciondisponible == -1){
        mensaje = "No hay cupo disponible";
    }else{
        reunionencontrada = buscarreunion(reunionnueva);
        if (reunionencontrada != null){
            mensaje = "Esta reunion ya está registrado";
        }else{
            listareuniones[posiciondisponible] = reunionnueva;
            mensaje = "La reunion a sido agregada correctamente";
        }
    }
    return mensaje;
}

public Reunion buscarreunion(Reunion reunionnueva){
    Reunion reunionencontrada = null;
    for (Reunion reunion : listareuniones) {
        if (reunionnueva.equals(reunion)){
            reunionencontrada = reunion;
            return reunionencontrada;
        }
    }
    return reunionencontrada;
}

private int buscarposiciondisponiblereunion(){
int posiciondisponible = -1;
for (int i = 0; i < listareuniones.length; i++) {
    Reunion reunion = listareuniones[i];
    if (reunion == null){
        posiciondisponible = i;
        return posiciondisponible;
    }
}
return posiciondisponible;
}

public String Eliminarreunion(Reunion reunionnueva){
String mensaje = "Esta reunion no existe";
for (int i = 0; i < listareuniones.length; i++) {
    Reunion reunion = listareuniones[i];
    if (reunionnueva.equals(reunion)) {
        listareuniones [i] = null;
        mensaje = "la reunipn a sido eliminada";
        break;
    }
}
return mensaje;

}

public String Actualizarreunion(String descripcion, Date fecha, Time hora, Reunion reunion){
String mensaje = "La reunion no existe";
Reunion reunionencontrada = buscarreunion(reunion);
if (reunionencontrada != null){
    reunionencontrada.setDescripcion(descripcion);
    reunionencontrada.setFecha(fecha);
    reunionencontrada.setHora(hora);
    mensaje = "La reunion a sido actualizada";
} 
return mensaje;
}

/**
 * imprime los contactos en posición impar
 */
public void ImprimirContactosPosImpares(){

    for (int i = 0; i < listacontactos.length; i++) {
        if (!(i%2==0)){
            System.out.println(listacontactos[i]);
        }
    }
}

/**
 * Retorna la edad más repetida de todos los contactos
 * @return
 */
public int obteneredadmasrepetida(){
    int EdadMasRepetida = 0;
    int ContadorMasRepetida = 0;
    int Contador = 1;
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null) {
            int edadi = listacontactos[i].getEdad();
            Contador = 0;
            for (int j = 0; j < listacontactos.length; j++) {
                if (listacontactos[j]!= null){
                    int edadj = listacontactos[j].getEdad();
                if (edadi == edadj){
                    Contador++;
                }
            }
                }
                if (ContadorMasRepetida < Contador){
                    EdadMasRepetida = edadi;
                    ContadorMasRepetida = Contador;
                }
            }
        }
    return EdadMasRepetida;
}

/**
 * borra un contacto los contactos que tengan 3 o más contactos
 */
public void borrarcontacto3vocales(){
    int Cantidadvocales = -1;
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null) {
            String nombre = listacontactos[i].getNombre();
            Cantidadvocales = 0;
            for (int j = 0; j < nombre.length(); j++) {
                char letra = Character.toLowerCase(nombre.charAt(j));
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    Cantidadvocales++;
                }                   
                }
                if (Cantidadvocales >= 3){
                    listacontactos[i] = null;
                }
            }
        }
    }

/**
 * Devuelve el grupo que tiene más contactos
 * @return
 */
public Grupo GrupoConMasContactos(){
    Grupo grupomascontactos = null;
    int contador = 0;
    for (int i = 0; i < listagrupos.length; i++) {
        if (listagrupos[i] != null){
            int cantidadcontactos = listagrupos[i].contarcontactos();
            if (cantidadcontactos>contador){
                contador = cantidadcontactos;
                grupomascontactos = listagrupos[i];
            }
        }
    }
    return grupomascontactos;
}

/**
 * Retorna el promedio de las edades
 * @return
 */
public int PromedioEdadContactos(){
    int promedio = 0;
    int cantidadcontactos = 0;
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null){
            promedio += listacontactos[i].getEdad();
            cantidadcontactos ++;
        }
    }
    return promedio/cantidadcontactos;
}

/**
 * devuelve un mensaje con todos los contactos menores a 18
 * @return
 */
public String ContactosMenoresA18(){
    String contactosmenores = "";
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null){
            int edad = listacontactos[i].getEdad();
            if (edad < 18){
                contactosmenores += listacontactos[i].toString() + " ";
            }
        }
    }
    return contactosmenores;
}

/**
 * retorna la desviación estandar de las edades
 * @return
 */
public double desviacionedades(){
    double desviacion = 0;
    int numerodatos = 0;
    double sumatoria = 0;
    double media = 0;
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null) {
            int edad = listacontactos[i].getEdad();
            sumatoria += edad;
            numerodatos ++;
        }
    }
    media = sumatoria/numerodatos;
    sumatoria = 0;
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null) {
            double edad = listacontactos[i].getEdad();
            sumatoria += ((edad-media) * (edad-media));
    }
    }
    desviacion = Math.sqrt(sumatoria/(numerodatos-1));
    return desviacion;
}
/**
 * este metodo imprime los nombres de los contactos del ultimo hasta el primero
 */

//este lo hice sin querer realizando el punto 9 y me gusto así que no lo borro :3
public void ImprimirContactosalreves(){
    for (int i = listacontactos.length-1; i > -1; i--) {
        if (listacontactos[i] !=null ){
            System.out.println(listacontactos[i].getNombre());
        }
    }
}

/**
 * Imprime el nombre de los contactos de atras hacia adelante
 */
public void imprimirnombresalreves(){
    String Nombrealreves = "";
    for (int i = 0; i < listacontactos.length; i++) {
        if (listacontactos[i] != null) {
            String nombre = listacontactos[i].getNombre();
            for (int j = nombre.length() -1; j > -1; j--) {
                char letra = nombre.charAt(j);
                Nombrealreves += letra; 
            }
            System.out.println(Nombrealreves);
            Nombrealreves = "";
        }
    }
}

/**
 * Este metodo retorna una matriz con las listas de reuniones dependiendo de la fecha
 * @return
 */
public Reunion[][] matrizreuniones(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    int numerocolumnas = listareuniones.length;
    Reunion matrizreuniones [][] = new Reunion[3][numerocolumnas];
    for (int i = 0; i < listareuniones.length; i++) {
        if (listareuniones[i] != null){
            Date fecha = listareuniones[i].getFecha();
            try {
                if (fecha.after(sdf.parse("01-11-2022")) && fecha.before((sdf.parse("30-11-2022")))){
                    for (int j = 0; j < matrizreuniones[0].length; j++) {
                        if (matrizreuniones[0][j] == null) {
                            matrizreuniones[0][j] = listareuniones[i];
                            break;
                        }
                    }
                }else if (fecha.after(sdf.parse("01-12-2022")) && fecha.before(sdf.parse("31-12-2022")) ) {
                    for (int j = 0; j < matrizreuniones[1].length; j++) {
                        if (matrizreuniones[1][j] == null) {
                            matrizreuniones[1][j] = listareuniones[i];
                            break;
                        }
                    }
                }else if (fecha.after(sdf.parse("01-01-2023")) && fecha.before(sdf.parse("30-01-2023")) ) {
                    for (int j = 0; j < matrizreuniones[2].length; j++) {
                        if (matrizreuniones[2][j] == null) {
                            matrizreuniones[2][j] = listareuniones[i];
                            break;
                        }
                    }
                }
                }catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
    return matrizreuniones;
}

/**
 * Este metodo agrega un contacto dado a partir de un nombre de un grupo.
 * @param nombregrupo
 * @param contacto
 */
public void agregarcontactonombre(String nombregrupo, Contacto contacto){
    for (int i = 0; i < listagrupos.length; i++) {
        if (listagrupos[i] != null) {
            if (listagrupos[i].getNombre() == nombregrupo) {
                listagrupos[i].agregar_contacto(contacto);
            }
        }
    }
}

/**
 * Este metodo ordena los contactos con el metodo burbuja a partir de su edad
 */
public void OrdenamientoBurbujaEdadContactos(){
    Contacto aux = new Contacto(null, null, null, null, null);
    int edadi = 0;
    int edadj = 0;
    for (int i = 0; i < listacontactos.length-1; i++) {
        for (int j = 0; j < listacontactos.length-1; j++) {
            if (listacontactos[j]!= null && listacontactos[j+1] != null) {
            edadi = listacontactos[j].getEdad();
            edadj = listacontactos[j+1].getEdad();
            if(edadi > edadj){
                aux = listacontactos[j];
                listacontactos[j] = listacontactos[j+1];
                listacontactos[j+1] = aux;
            }
            }
        }
    }
}

public String listacontactostoString() {
    return "Agenda [listacontactos=" + Arrays.toString(listacontactos) + "]";
}

}



