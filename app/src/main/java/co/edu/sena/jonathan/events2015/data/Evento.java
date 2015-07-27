package co.edu.sena.jonathan.events2015.data;

/**
 * Created by jeison on 27/07/2015.
 */
public class Evento {

    int id,estado,encabesado;
    String nombre,start_time,dia,participantes,ubiacion;

    public Evento() {
    }

    public Evento(int id, int estado, int encabesado, String nombre, String start_time, String dia, String participantes, String ubiacion) {
        this.id = id;
        this.estado = estado;
        this.encabesado = encabesado;
        this.nombre = nombre;
        this.start_time = start_time;
        this.dia = dia;
        this.participantes = participantes;
        this.ubiacion = ubiacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEncabesado() {
        return encabesado;
    }

    public void setEncabesado(int encabesado) {
        this.encabesado = encabesado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getUbiacion() {
        return ubiacion;
    }

    public void setUbiacion(String ubiacion) {
        this.ubiacion = ubiacion;
    }
}
