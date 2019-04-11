package br.ude.unifacisa.Autor.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.Autor.domain.Autor;
import br.ude.unifacisa.Autor.repository.AutorRepository;



@Service
@Validated
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public Optional<Autor> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Autor> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Autor inserirUsuario(Autor usuario) {
		return repository.save(usuario);
	}

	public AutorRepository getRepository() {
		return repository;
	}

	public void setRepository(AutorRepository repository) {
		this.repository = repository;
	}
}
