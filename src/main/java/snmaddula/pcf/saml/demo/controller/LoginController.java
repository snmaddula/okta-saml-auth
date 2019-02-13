package snmaddula.pcf.saml.demo.controller;

import java.util.Map;

import org.springframework.security.saml.metadata.MetadataManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final MetadataManager metadataManager;

	@GetMapping("/login")
	public String loginView(Map<String, Object> model) {
		model.put("idps", metadataManager.getIDPEntityNames());
		return "login";
	}

}
