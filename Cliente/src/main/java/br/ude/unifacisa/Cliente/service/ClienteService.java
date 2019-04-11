package br.ude.unifacisa.Cliente.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.Cliente.domain.Cliente;
import br.ude.unifacisa.Cliente.repository.ClienteRepository;



@Service
@Validated
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Optional<Cliente> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Cliente> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Cliente inserirUsuario(Cliente usuario) {
		return repository.save(usuario);
	}

	public ClienteRepository getRepository() {
		return repository;
	}

	public void setRepository(ClienteRepository repository) {
		this.repository = repository;
	}
}
