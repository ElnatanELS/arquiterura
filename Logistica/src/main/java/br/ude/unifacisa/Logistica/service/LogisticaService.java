package br.ude.unifacisa.Logistica.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.Logistica.domain.Logistica;
import br.ude.unifacisa.Logistica.repository.LogisticaRepository;



@Service
@Validated
public class LogisticaService {

	@Autowired
	private LogisticaRepository repository;

	public Optional<Logistica> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Logistica> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Logistica inserirUsuario(Logistica usuario) {
		return repository.save(usuario);
	}

	public LogisticaRepository getRepository() {
		return repository;
	}

	public void setRepository(LogisticaRepository repository) {
		this.repository = repository;
	}
}
