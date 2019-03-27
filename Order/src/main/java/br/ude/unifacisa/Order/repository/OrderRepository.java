package br.ude.unifacisa.Order.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.Order.domain.Order;

public interface OrderRepository extends CrudRepository<Order, String> {

}
