package br.ude.unifacisa.Autor.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.Autor.domain.Autor;

public interface AutorRepository extends CrudRepository<Autor, String> {

}
