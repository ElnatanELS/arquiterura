package br.ude.unifacisa.promocao.controller;

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

import br.ude.unifacisa.promocao.domain.Promocao;
import br.ude.unifacisa.promocao.service.PromocaoService;


@RestController

public class PromocaoController {

	@Autowired
	private PromocaoService promocaoService;
	
	@RequestMapping(value = "/autor", method = RequestMethod.GET)
	public ResponseEntity< List<Promocao> > listarUsuarios() {

		List<Promocao> listaUsuarios = (List<Promocao>) promocaoService.listarTodosUsuarios();

		return new ResponseEntity< List<Promocao> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Promocao> obterUsuario(@PathVariable String id) {

		Optional<Promocao> promocao = promocaoService.buscarUsuarioPorId(id);

		if (promocao == null) {
			return new ResponseEntity<Promocao>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Promocao>(promocao.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/autor", method = RequestMethod.POST)
	public ResponseEntity<Promocao> criarUsuario(@RequestBody Promocao promocao) {

		try {
			Promocao usuarioInserido = promocaoService.inserirUsuario(promocao);
			return new ResponseEntity<Promocao>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Promocao>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public PromocaoService getUserService() {
		return promocaoService;
	}

	public void setUserService(PromocaoService promocaoService) {
		this.promocaoService = promocaoService;
	}

}
