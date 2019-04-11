package br.ude.unifacisa.promocao.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.promocao.domain.Promocao;
import br.ude.unifacisa.promocao.repository.PromocaoRepository;



@Service
@Validated
public class PromocaoService {

	@Autowired
	private PromocaoRepository repository;

	public Optional<Promocao> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Promocao> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Promocao inserirUsuario(Promocao usuario) {
		return repository.save(usuario);
	}

	public PromocaoRepository getRepository() {
		return repository;
	}

	public void setRepository(PromocaoRepository repository) {
		this.repository = repository;
	}
}
