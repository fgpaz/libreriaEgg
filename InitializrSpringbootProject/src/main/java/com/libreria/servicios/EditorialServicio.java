package com.libreria.servicios;

// @author fgpaz
import com.libreria.entidades.Editorial;
import com.libreria.errores.ErrorServicio;
import com.libreria.repositorios.EditorialRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio
{

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void agregarEditorial(String nombre) throws ErrorServicio
    {
        validarNombre(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void modificarEditorial(String id, String nombre) throws ErrorServicio
    {
        validarNombre(nombre);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        } else
        {
            throw new ErrorServicio("No existe una editorial con ese id");
        }
    }

    @Transactional
    public void bajaEditorial(String id) throws ErrorServicio
    {
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Editorial editorial = respuesta.get();
            editorial.setAlta(Boolean.FALSE);
            editorialRepositorio.save(editorial);
        } else
        {
            throw new ErrorServicio("No existe una editorial con ese id");
        }
    }

    @Transactional
    public void validarNombre(String nombre) throws ErrorServicio
    {
        if (nombre == null || nombre.isEmpty())
        {
            throw new ErrorServicio("El nombre de la editorial no puede ser nula");
        }
    }
}
