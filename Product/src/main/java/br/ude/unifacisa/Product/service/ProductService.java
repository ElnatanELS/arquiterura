package br.ude.unifacisa.Product.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.ude.unifacisa.Product.domain.Product;
import br.ude.unifacisa.Product.repository.ProductRepository;



@Service
@Validated
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Optional<Product> buscarUsuarioPorId(String id) {
		return repository.findById(id);
	}

	public Iterable<Product> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Product inserirUsuario(Product usuario) {
		return repository.save(usuario);
	}

	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}
}
