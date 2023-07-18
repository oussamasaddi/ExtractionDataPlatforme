package esprit.tn.extraireDataBack.controller;

import esprit.tn.extraireDataBack.entity.JwtRequest;
import esprit.tn.extraireDataBack.entity.JwtResponse;
import esprit.tn.extraireDataBack.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;
	
	
	/*@PostMapping({"/authenticate"})
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
		
	}
*/

	@PostMapping({"/authenticate"})
	public HashMap<String , String> createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		HashMap<String , String> jwt = new HashMap<>();
		jwt.put("jwtToken" ,jwtService.createJwtToken(jwtRequest).getJwtToken() );
		return jwt;

	}
}
