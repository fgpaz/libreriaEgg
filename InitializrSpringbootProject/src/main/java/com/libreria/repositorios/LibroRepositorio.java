package com.libreria.repositorios;
// @author fgpaz

import com.libreria.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String>{
    @Query("SELECT a FROM Libro a WHERE a.titulo= :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);
}
