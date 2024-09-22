package co.edu.uniquindio.poo.model;

import java.util.Date;
import java.sql.Time;


public class Reunion {

    String descripcion;
    Date Fecha;
    Time hora;
    Contacto listacontactos[];
    
    public Reunion(String descripcion, Date fecha, Time hora, int numerocontactos) {
        this.descripcion = descripcion;
        this.Fecha = fecha;
        this.hora = hora;
        this.listacontactos = new Contacto[numerocontactos];
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reunion [descripcion=" + descripcion + ", Fecha=" + Fecha + ", hora=" + hora + ", listacontactos="
                + listacontactos + "]";
    }
    
    /**
     *  este metodo agrega un contacto a la reunion siempre y cuando no sobrepase el limite de contactos por grupo y este no esté agregado
     * @param nuevocontacto
     * @return
     */
    public String agregar_contacto(Contacto nuevocontacto){
        String mensaje = "";
        int cupo_libre = 0;
        cupo_libre = buscar_cupo();
        Contacto contacto_encontrado = null;
        if (cupo_libre == -1){
            mensaje = "La reunion no puede tener más contactos";
        }else{contacto_encontrado = buscar_contacto(nuevocontacto);
            if (contacto_encontrado == null) {
            mensaje = "Agregaste correctamente al contacto";
            listacontactos[cupo_libre] = nuevocontacto;
        }else{
            mensaje = "Este contacto ya está registrado en esta reunion";
        }
        }
        return mensaje;

    /**
     * Este metodo compara el telefono y nombre de 2 contactos para verificar si son el mismo
     */
    }
    private Contacto buscar_contacto(Contacto nuevocontacto) {
        Contacto contactoencontrado = null;
        for (Contacto contacto : listacontactos) {
            if (nuevocontacto.equals(contacto)) {
                contactoencontrado = contacto;
                return contactoencontrado;
            }
            
        }
        return contactoencontrado;
    }

    /**
     * Este metodo busca si existe espacio en la reunion o si este está lleno
     * @return
     */
    private int buscar_cupo() {
        int cupo = -1;
        for (int i = 0; i < listacontactos.length; i++) {
            Contacto contacto_actual = listacontactos[i];
            if (contacto_actual == null){
                cupo = i;
                return cupo;
            }
        }
        return cupo;
    }

    /**
     * Este metodo busca al contacto con el nombre y telefono y lo elimina de la lista
     * @param contacto
     * @return
     */
    public String eliminar_contacto(Contacto contacto){
        String mensaje = "Este contacto no existe en la reunion";
        for (int i = 0; i < listacontactos.length; i++) {
            Contacto contacto_actual = listacontactos[i];
            if (contacto.equals(contacto_actual)){
                mensaje = "El contacto a sido eliminado";
                listacontactos[i] = null;
                return mensaje;
                
            }
        }
        return mensaje;
    }

    
}
       


