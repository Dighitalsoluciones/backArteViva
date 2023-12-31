package com.dighital.arteviva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase modelo articulos
 *
 * @HAG
 */
@Entity
@Getter
@Setter
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codigo;
    private String descripcion;
    private int peso;
    private int costo;
    private String[] composicion;

    public Articulo() {
    }

    public Articulo(int codigo, String descripcion, int peso, int costo, String[] composicion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.costo = costo;
        this.composicion = composicion;
    }

}
