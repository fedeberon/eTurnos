package com.bolivarSoftware.eTurnos.domain;

/**
 * Created by Diego on 15/6/2017.
 */
public class TurnoCartel {

    private String numeroTicket;
    private String puesto;
    private String cliente;

    public TurnoCartel(Turno turno) {
        this.numeroTicket = turno.getNumeroTicket();
        this.puesto = turno.getPuesto()!= null ? turno.getPuesto().getNumero().toString() : "S/N";
        this.cliente = turno.getCliente() != null ?
                turno.getCliente().getNombre().concat(" ").concat(turno.getCliente().getApellido())
                : "No cliente";
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }
    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
