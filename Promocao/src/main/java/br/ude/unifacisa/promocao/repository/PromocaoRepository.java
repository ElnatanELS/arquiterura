package br.ude.unifacisa.promocao.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.promocao.domain.Promocao;

public interface PromocaoRepository extends CrudRepository<Promocao, String> {

}
