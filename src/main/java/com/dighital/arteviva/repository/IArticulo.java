package com.dighital.arteviva.repository;

import com.dighital.arteviva.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @HAG
 */
@Repository
public interface IArticulo extends JpaRepository<Articulo, Long> {

}
