package com.libreria.repositorios;
// @author fgpaz

import com.libreria.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>
{
    @Query("SELECT a FROM Editorial a WHERE a.nombre= :nombre")
    public Editorial buscarPorNombre(@Param("nombre") String nombre);
}
