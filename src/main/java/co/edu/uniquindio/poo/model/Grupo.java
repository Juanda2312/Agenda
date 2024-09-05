package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Grupo {

    String nombre;
    Categoria Categoria;
    int participantes_maximos;
    Contacto[] lista_contactos;

    
    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.Categoria = categoria;
        participantes_maximos = 5;
        lista_contactos = new Contacto[participantes_maximos];
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Categoria getCategoria() {
        return Categoria;
    }


    public void setCategoria(Categoria categoria) {
        Categoria = categoria;
    }


    public Contacto[] getLista_contactos() {
        return lista_contactos;
    }


    public void setLista_contactos(Contacto[] lista_contactos) {
        this.lista_contactos = lista_contactos;
    }

    public int getParticipantes_maximos() {
        return participantes_maximos;
    }

    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", Categoria=" + Categoria + ", lista_contactos="
                + Arrays.toString(lista_contactos) + "]";
    }
    
    /**
     *  este metodo agrega un contacto al grupo siempre y cuando no sobrepase el limite de contactos por grupo y este no esté agregado
     * @param nuevocontacto
     * @return
     */
    public String agregar_contacto(Contacto nuevocontacto){
        String mensaje = "";
        int cupo_libre = 0;
        cupo_libre = buscar_cupo();
        Contacto contacto_encontrado = null;
        if (cupo_libre == -1){
            mensaje = "El grupo no puede tener más contactos";
        }else{contacto_encontrado = buscar_contacto(nuevocontacto);
            if (contacto_encontrado == null) {
            mensaje = "Agregaste correctamente al contacto";
            lista_contactos[cupo_libre] = nuevocontacto;
        }else{
            mensaje = "Este contacto ya está registrado en este grupo";
        }
        }
        return mensaje;

    /**
     * Este metodo compara el telefono y nombre de 2 contactos para verificar si son el mismo
     */
    }
    private Contacto buscar_contacto(Contacto nuevocontacto) {
        Contacto contactoencontrado = null;
        for (Contacto contacto : lista_contactos) {
            if (nuevocontacto.equals(contacto)) {
                contactoencontrado = contacto;
                return contactoencontrado;
            }
            
        }
        return contactoencontrado;
    }

    /**
     * Este metodo busca si existe espacio en el grupo o si este está lleno
     * @return
     */
    private int buscar_cupo() {
        int cupo = -1;
        for (int i = 0; i < lista_contactos.length; i++) {
            Contacto contacto_actual = lista_contactos[i];
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
        String mensaje = "Este contacto no existe en el grupo";
        for (int i = 0; i < lista_contactos.length; i++) {
            Contacto contacto_actual = lista_contactos[i];
            if (contacto.equals(contacto_actual)){
                mensaje = "El contacto a sido eliminado";
                lista_contactos[i] = null;
                return mensaje;
                
            }
        }
        return mensaje;
    }

    /**
     * Recorre la lista de contactos y si existe uno lo cuenta
     * @return
     */
    public int contarcontactos(){
        int cantidadcontactos = 0;
        for (Contacto contacto : lista_contactos) {
            if (contacto != null){
                cantidadcontactos++;
            }
        }
        return cantidadcontactos;
    }
    
}
