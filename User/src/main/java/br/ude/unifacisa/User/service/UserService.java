package br.ude.unifacisa.User.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.User.domain.User;
import br.ude.unifacisa.User.repository.UserRepository;



@Service
@Validated
public class UserService {

	@Autowired
	private UserRepository repository;

	public Optional<User> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<User> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public User inserirUsuario(User usuario) {
		return repository.save(usuario);
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
}
