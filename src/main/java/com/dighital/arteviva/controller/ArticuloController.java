package com.dighital.arteviva.controller;

import com.dighital.arteviva.dto.ArticuloDTO;
import com.dighital.arteviva.model.Articulo;
import com.dighital.arteviva.service.ArticuloService;
import exception.Mensaje;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @HEG
 */
@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/list")
    public ResponseEntity<List<Articulo>> list() {
        List<Articulo> listaArticulos = articuloService.listarArticulos();
        return new ResponseEntity(listaArticulos, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Articulo> geyById(@PathVariable("id") Long id) {
        if (!articuloService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Articulo articulo = articuloService.buscarPorId(id).get();
        return new ResponseEntity(articulo, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ArticuloDTO articuloDTO) {
        if (StringUtils.isBlank(articuloDTO.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Articulo articulo = new Articulo(
                articuloDTO.getCodigo(), articuloDTO.getDescripcion(), articuloDTO.getCosto(),
                articuloDTO.getPeso(), articuloDTO.getComposicion());
        articuloService.guardar(articulo);
        return new ResponseEntity(new Mensaje("Nuevo Articulo creado exitosamente"), HttpStatus.OK);
    }

}
