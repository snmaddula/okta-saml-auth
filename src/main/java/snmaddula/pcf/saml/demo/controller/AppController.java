package snmaddula.pcf.saml.demo.controller;

import java.security.Principal;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {

	@GetMapping("/")
	public String showView() {
		return "home";
	}

	@ModelAttribute("username")
	public String username() {
		try {
			Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication();
			return principal.getName();
		} catch (AuthenticationCredentialsNotFoundException ex) {
			return null;
		}
	}
}
