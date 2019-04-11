package br.ude.unifacisa.valePresente.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.valePresente.domain.ValePresente;
import br.ude.unifacisa.valePresente.repository.ValePresenteRepository;



@Service
@Validated
public class ValePresenteService {

	@Autowired
	private ValePresenteRepository repository;

	public Optional<ValePresente> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<ValePresente> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public ValePresente inserirUsuario(ValePresente usuario) {
		return repository.save(usuario);
	}

	public ValePresenteRepository getRepository() {
		return repository;
	}

	public void setRepository(ValePresenteRepository repository) {
		this.repository = repository;
	}
}
