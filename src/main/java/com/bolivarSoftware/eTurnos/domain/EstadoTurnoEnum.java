package com.bolivarSoftware.eTurnos.domain;

public enum  EstadoTurnoEnum {

    EN_ESPERA(0xE6DB00),
    CANCELADO(0x444444),
    LLAMANDO(0xFE9A2E),
    AUSENTE(0xF94747),
    ATENDIDO(0x38DD22),
    PRIORIZADO(0x501E50),
    INCONSISTENTE(0x999999),
    DERIVADO(0xF64EF6);

    private Integer color;
    private String descripcion;

    EstadoTurnoEnum(Integer color) {
        this.color = color;
        this.descripcion = this.toString();
    }

    public Integer getColor() {
        return color;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
