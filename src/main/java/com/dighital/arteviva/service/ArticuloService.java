package com.dighital.arteviva.service;

import com.dighital.arteviva.model.Articulo;
import com.dighital.arteviva.repository.IArticulo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @HEG
 */
@Service
@Transactional
public class ArticuloService {

    @Autowired
    private IArticulo iarticuloRepository;

    public List<Articulo> listarArticulos() {
        return iarticuloRepository.findAll();
    }
    
    public Optional<Articulo> buscarPorId(Long id){
        return iarticuloRepository.findById(id);
    }

    public Articulo guardar(Articulo articulo) {
        return iarticuloRepository.save(articulo);
    }

    public void eliminar(Long id) {
        iarticuloRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iarticuloRepository.existsById(id);
    }
}
