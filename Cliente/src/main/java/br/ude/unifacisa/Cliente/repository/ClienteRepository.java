package br.ude.unifacisa.Cliente.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.Cliente.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
