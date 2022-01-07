package com.libreria.servicios;

// @author fgpaz
import com.libreria.entidades.Autor;
import com.libreria.entidades.Editorial;
import com.libreria.entidades.Libro;
import com.libreria.errores.ErrorServicio;
import com.libreria.repositorios.AutorRepositorio;
import com.libreria.repositorios.EditorialRepositorio;
import com.libreria.repositorios.LibroRepositorio;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio
{

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Transactional
    public void agregarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, String idAutor, String idEditorial) throws ErrorServicio
    {
        validarIsbn(isbn);
        validarTitulo(titulo);
        validarAnio(anio);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        if (respuestaEditorial.isPresent())
        {
            Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
            if (respuestaAutor.isPresent())
            {
                Editorial editorial = respuestaEditorial.get();
                Autor autor = respuestaAutor.get();

                Libro libro = new Libro();
                libro.setIsbn(isbn);
                libro.setTitulo(titulo);
                libro.setAnio(anio);
                libro.setAlta(Boolean.TRUE);
                libro.setAutor(autor);
                libro.setEditorial(editorial);

                libroRepositorio.save(libro);
            } else
            {
                throw new ErrorServicio("No se encontro el autor");
            }
        } else
        {
            throw new ErrorServicio("No se encontro la editorial");
        }
    }

    @Transactional
    public void modificarLibro(String idLibro, Long isbn, String titulo, Integer anio, Integer ejemplares, String idAutor, String idEditorial) throws ErrorServicio
    {
        Optional<Libro> respuestaLibro = libroRepositorio.findById(idLibro);
        if (respuestaLibro.isPresent())
        {
            validarIsbn(isbn);
            validarTitulo(titulo);
            validarAnio(anio);
            Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
            if (respuestaEditorial.isPresent())
            {
                Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
                if (respuestaAutor.isPresent())
                {
                    Editorial editorial = respuestaEditorial.get();
                    Autor autor = respuestaAutor.get();

                    Libro libro = new Libro();
                    libro.setIsbn(isbn);
                    libro.setTitulo(titulo);
                    libro.setAnio(anio);
                    libro.setAlta(Boolean.TRUE);
                    libro.setAutor(autor);
                    libro.setEditorial(editorial);

                    libroRepositorio.save(libro);
                } else
                {
                    throw new ErrorServicio("No se encontro el autor");
                }
            } else
            {
                throw new ErrorServicio("No se encontro la editorial");
            }
        } else
        {
            throw new ErrorServicio("No existe el libro con el ID seleccionado");
        }
    }

    @Transactional
    public void bajaLibro(String id) throws ErrorServicio
    {
        Optional<Libro> respuesta = libroRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Libro libro = respuesta.get();
            libro.setAlta(Boolean.FALSE);
            libroRepositorio.save(libro);
        } else
        {
            throw new ErrorServicio("No existe el libro seleccionado en la base de datos");
        }
    }

    @Transactional
    public void validarIsbn(Long isbn) throws ErrorServicio
    {
        if (isbn < 0)
        {
            throw new ErrorServicio("El ISBN no puede ser negativo");
        }
    }

    @Transactional
    public void validarTitulo(String titulo) throws ErrorServicio
    {
        if (titulo == null || titulo.isEmpty())
        {
            throw new ErrorServicio("El titulo del libro no puede ser nulo");
        }
    }

    @Transactional
    public void validarAnio(Integer anio) throws ErrorServicio
    {
        if (anio < 0 || anio > 2021)
        {
            throw new ErrorServicio("El anio no puede ser negativo o mayor a 2021");
        }
    }
}
