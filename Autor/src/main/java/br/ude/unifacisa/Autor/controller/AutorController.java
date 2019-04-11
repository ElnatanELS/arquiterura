package br.ude.unifacisa.Autor.controller;

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

import br.ude.unifacisa.Autor.domain.Autor;
import br.ude.unifacisa.Autor.service.AutorService;


@RestController

public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@RequestMapping(value = "/autor", method = RequestMethod.GET)
	public ResponseEntity< List<Autor> > listarUsuarios() {

		List<Autor> listaUsuarios = (List<Autor>) autorService.listarTodosUsuarios();

		return new ResponseEntity< List<Autor> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> obterUsuario(@PathVariable String id) {

		Optional<Autor> autor = autorService.buscarUsuarioPorId(id);

		if (autor == null) {
			return new ResponseEntity<Autor>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Autor>(autor.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/autor", method = RequestMethod.POST)
	public ResponseEntity<Autor> criarUsuario(@RequestBody Autor autor) {

		try {
			Autor usuarioInserido = autorService.inserirUsuario(autor);
			return new ResponseEntity<Autor>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Autor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public AutorService getUserService() {
		return autorService;
	}

	public void setUserService(AutorService autorService) {
		this.autorService = autorService;
	}

}
