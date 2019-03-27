package br.ude.unifacisa.Product.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.Product.domain.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
