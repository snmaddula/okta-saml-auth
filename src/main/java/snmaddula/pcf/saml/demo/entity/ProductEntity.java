package snmaddula.pcf.saml.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Double price;
	
}
