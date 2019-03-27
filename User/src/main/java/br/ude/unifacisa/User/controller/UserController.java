package br.ude.unifacisa.User.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ude.unifacisa.User.domain.User;
import br.ude.unifacisa.User.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity< List<User> > listarUsuarios() {

		List<User> listaUsuarios = (List<User>) userService.listarTodosUsuarios();

		return new ResponseEntity< List<User> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> obterUsuario(@PathVariable String id) {

		Optional<User> user = userService.buscarUsuarioPorId(id);

		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> criarUsuario(@RequestBody User user) {

		try {
			User usuarioInserido = userService.inserirUsuario(user);
			return new ResponseEntity<User>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
