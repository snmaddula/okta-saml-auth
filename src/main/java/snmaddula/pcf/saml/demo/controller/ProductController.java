package snmaddula.pcf.saml.demo.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import snmaddula.pcf.saml.demo.dto.AppResponse;
import snmaddula.pcf.saml.demo.dto.Product;
import snmaddula.pcf.saml.demo.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<AppResponse> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<AppResponse> getById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getById(id));
	}

	@ResponseStatus(OK)
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		productService.deleteById(id);
	}

	@DeleteMapping
	@ResponseStatus(OK)
	public void deleteAll() {
		productService.deleteAll();
	}

	@PostMapping
	public ResponseEntity<AppResponse> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.create(product));
	}

	@PutMapping
	public ResponseEntity<AppResponse> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.update(product));
	}

}
