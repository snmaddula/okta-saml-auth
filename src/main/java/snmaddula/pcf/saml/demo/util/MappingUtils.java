package snmaddula.pcf.saml.demo.util;

import org.springframework.beans.BeanUtils;

import snmaddula.pcf.saml.demo.dto.Product;
import snmaddula.pcf.saml.demo.entity.ProductEntity;

public class MappingUtils {

	public static ProductEntity toEntity(Product product) {
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(product, entity);
		return entity;
	}

	public static Product toDto(ProductEntity entity) {
		Product product = new Product();
		BeanUtils.copyProperties(entity, product);
		return product;
	};
}
