package br.ude.unifacisa.Cliente.controller;

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

import br.ude.unifacisa.Cliente.domain.Cliente;
import br.ude.unifacisa.Cliente.service.ClienteService;

@RestController

public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity< List<Cliente> > listarUsuarios() {

		List<Cliente> listaUsuarios = (List<Cliente>) clienteService.listarTodosUsuarios();

		return new ResponseEntity< List<Cliente> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obterUsuario(@PathVariable String id) {

		Optional<Cliente> cliente = clienteService.buscarUsuarioPorId(id);

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Cliente> criarUsuario(@RequestBody Cliente cliente) {

		try {
			Cliente usuarioInserido = clienteService.inserirUsuario(cliente);
			return new ResponseEntity<Cliente>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ClienteService getUserService() {
		return clienteService;
	}

	public void setUserService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
