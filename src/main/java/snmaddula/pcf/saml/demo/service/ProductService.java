package snmaddula.pcf.saml.demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.pcf.saml.demo.dto.AppResponse;
import snmaddula.pcf.saml.demo.dto.Product;
import snmaddula.pcf.saml.demo.repo.ProductRepo;
import snmaddula.pcf.saml.demo.util.MappingUtils;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepo productRepo;

	public AppResponse getAll() {
		return new AppResponse(productRepo.findAll());
	}

	public AppResponse getById(Long id) {
		return new AppResponse(productRepo.findById(id).get());
	}

	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}

	public void deleteAll() {
		productRepo.deleteAllInBatch();
	}

	public AppResponse create(Product product) {
		return new AppResponse(productRepo.save(MappingUtils.toEntity(product)));
	}

	public AppResponse update(Product product) {
		// check id exists and then respond.
		return new AppResponse(productRepo.save(MappingUtils.toEntity(product)));
	}

}
