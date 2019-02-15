package snmaddula.pcf.saml.demo.controller;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import snmaddula.pcf.saml.demo.dto.User;

@Controller
public class AppController {

	@GetMapping("/")
	public String showView() {
		return "home";
	}

	@ModelAttribute("user")
	public User username() {
		try {
			SAMLCredential cred = (SAMLCredential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
			User user = new User();
			user.setFirstName(cred.getAttributeAsString("First Name"));
			user.setLastName(cred.getAttributeAsString("Last Name"));
			user.setEmail(cred.getAttributeAsString("Email"));
			user.setUserType(cred.getAttributeAsString("User Type"));
			return user;
		} catch (AuthenticationCredentialsNotFoundException ex) {
			return null;
		}
	}
}
