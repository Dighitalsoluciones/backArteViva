package com.dighital.arteviva.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @HEG
 */
@Getter
@Setter
public class ArticuloDTO {

    private Long id;
    private int codigo;
    private String descripcion;
    private int peso;
    private int costo;
    private String[] composicion;

    public ArticuloDTO() {
    }

    public ArticuloDTO(int codigo, String descripcion, int peso, int costo, String[] composicion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.costo = costo;
        this.composicion = composicion;
    }
}
