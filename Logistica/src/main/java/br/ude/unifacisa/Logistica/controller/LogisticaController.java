package br.ude.unifacisa.Logistica.controller;

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

import br.ude.unifacisa.Logistica.domain.Logistica;
import br.ude.unifacisa.Logistica.service.LogisticaService;


@RestController

public class LogisticaController {

	@Autowired
	private LogisticaService logisticaService;
	
	@RequestMapping(value = "/autor", method = RequestMethod.GET)
	public ResponseEntity< List<Logistica> > listarUsuarios() {

		List<Logistica> listaUsuarios = (List<Logistica>) logisticaService.listarTodosUsuarios();

		return new ResponseEntity< List<Logistica> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Logistica> obterUsuario(@PathVariable String id) {

		Optional<Logistica> logistica = logisticaService.buscarUsuarioPorId(id);

		if (logistica == null) {
			return new ResponseEntity<Logistica>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Logistica>(logistica.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/autor", method = RequestMethod.POST)
	public ResponseEntity<Logistica> criarUsuario(@RequestBody Logistica logistica) {

		try {
			Logistica usuarioInserido = logisticaService.inserirUsuario(logistica);
			return new ResponseEntity<Logistica>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Logistica>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public LogisticaService getUserService() {
		return logisticaService;
	}

	public void setUserService(LogisticaService logisticaService) {
		this.logisticaService = logisticaService;
	}

}
