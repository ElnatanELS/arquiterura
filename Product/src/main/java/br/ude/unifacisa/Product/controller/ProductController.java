package br.ude.unifacisa.Product.controller;

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

import br.ude.unifacisa.Product.domain.Product;
import br.ude.unifacisa.Product.service.ProductService;

@RestController

public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity< List<Product> > listarUsuarios() {

		List<Product> listaUsuarios = (List<Product>) productService.listarTodosUsuarios();

		return new ResponseEntity< List<Product> >(listaUsuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> obterUsuario(@PathVariable String id) {

		Optional<Product> product = productService.buscarUsuarioPorId(id);

		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<Product> criarUsuario(@RequestBody Product product) {

		try {
			Product usuarioInserido = productService.inserirUsuario(product);
			return new ResponseEntity<Product>(usuarioInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ProductService getUserService() {
		return productService;
	}

	public void setUserService(ProductService productService) {
		this.productService = productService;
	}

}
