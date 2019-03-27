package br.ude.unifacisa.Order.controller;

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

import br.ude.unifacisa.Order.domain.Order;
import br.ude.unifacisa.Order.service.OrderService;

@RestController

public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity< List<Order> > listarUsuarios() {

		List<Order> listaUsuarios = (List<Order>) orderService.listarTodosUsuarios();

		return new ResponseEntity< List<Order> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> obterUsuario(@PathVariable String id) {

		Optional<Order> order = orderService.buscarUsuarioPorId(id);

		if (order == null) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Order> criarUsuario(@RequestBody Order order) {

		try {
			Order usuarioInserido = orderService.inserirUsuario(order);
			return new ResponseEntity<Order>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public OrderService getUserService() {
		return orderService;
	}

	public void setUserService(OrderService orderService) {
		this.orderService = orderService;
	}

}
