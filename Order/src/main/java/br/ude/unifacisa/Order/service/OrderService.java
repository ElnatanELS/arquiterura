package br.ude.unifacisa.Order.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.Order.domain.Order;
import br.ude.unifacisa.Order.repository.OrderRepository;



@Service
@Validated
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public Optional<Order> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Order> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Order inserirUsuario(Order usuario) {
		return repository.save(usuario);
	}

	public OrderRepository getRepository() {
		return repository;
	}

	public void setRepository(OrderRepository repository) {
		this.repository = repository;
	}
}
