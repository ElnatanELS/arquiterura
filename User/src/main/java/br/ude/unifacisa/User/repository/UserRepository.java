package br.ude.unifacisa.User.repository;

import org.springframework.data.repository.CrudRepository;

import br.ude.unifacisa.User.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
