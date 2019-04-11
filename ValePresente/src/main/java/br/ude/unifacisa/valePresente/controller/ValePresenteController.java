package br.ude.unifacisa.valePresente.controller;

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

import br.ude.unifacisa.valePresente.domain.ValePresente;
import br.ude.unifacisa.valePresente.service.ValePresenteService;


@RestController

public class ValePresenteController {

	@Autowired
	private ValePresenteService valePresenteService;
	
	@RequestMapping(value = "/autor", method = RequestMethod.GET)
	public ResponseEntity< List<ValePresente> > listarUsuarios() {

		List<ValePresente> listaUsuarios = (List<ValePresente>) valePresenteService.listarTodosUsuarios();

		return new ResponseEntity< List<ValePresente> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
	public ResponseEntity<ValePresente> obterUsuario(@PathVariable String id) {

		Optional<ValePresente> valePresente = valePresenteService.buscarUsuarioPorId(id);

		if (valePresente == null) {
			return new ResponseEntity<ValePresente>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ValePresente>(valePresente.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/autor", method = RequestMethod.POST)
	public ResponseEntity<ValePresente> criarUsuario(@RequestBody ValePresente valePresente) {

		try {
			ValePresente usuarioInserido = valePresenteService.inserirUsuario(valePresente);
			return new ResponseEntity<ValePresente>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ValePresente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ValePresenteService getUserService() {
		return valePresenteService;
	}

	public void setUserService(ValePresenteService valePresenteService) {
		this.valePresenteService = valePresenteService;
	}

}
