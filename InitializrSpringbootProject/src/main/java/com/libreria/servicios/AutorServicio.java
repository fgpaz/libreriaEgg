package com.libreria.servicios;

// @author fgpaz
import com.libreria.entidades.Autor;
import com.libreria.errores.ErrorServicio;
import com.libreria.repositorios.AutorRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AutorServicio
{

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void agregarAutor(String nombre) throws ErrorServicio
    {
        validarNombre(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(Boolean.TRUE);
        autorRepositorio.save(autor);
    }

    @Transactional
    public void modificarAutor(String id, String nombre) throws ErrorServicio
    {
        validarNombre(nombre);
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        } else
        {
            throw new ErrorServicio("No se encontro un autor con esa id");
        }
    }

    @Transactional
    public void bajaAutor(String id) throws ErrorServicio
    {
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Autor autor = respuesta.get();
            autor.setAlta(Boolean.FALSE);
            autorRepositorio.save(autor);
        } else
        {
            throw new ErrorServicio("No se encontro un autor con esa id");
        }
    }

    @Transactional
    public void validarNombre(String nombre) throws ErrorServicio
    {
        if (nombre == null || nombre.isEmpty())
        {
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
    }
}
