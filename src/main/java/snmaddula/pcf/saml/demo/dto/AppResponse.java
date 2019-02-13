package snmaddula.pcf.saml.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppResponse {

	private boolean error;
	private String errorMessage;
	private Object data;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public AppResponse(@JsonProperty("data") Object data) {
		this.data = data;
	}
	
}
