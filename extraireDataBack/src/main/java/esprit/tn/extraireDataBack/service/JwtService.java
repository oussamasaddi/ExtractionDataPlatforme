package esprit.tn.extraireDataBack.service;

import java.util.HashSet;
import java.util.Set;

import esprit.tn.extraireDataBack.entity.JwtRequest;
import esprit.tn.extraireDataBack.entity.JwtResponse;
import esprit.tn.extraireDataBack.entity.User;
import esprit.tn.extraireDataBack.repository.UserRepository;
import esprit.tn.extraireDataBack.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class JwtService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private JwtUtil jwtUtil ;
	
	@Autowired
	private AuthenticationManager authenticationManager ; 
	
	
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		authenticate(userName, userPassword);
		final  UserDetails userDetails = loadUserByUsername(userName);
		User user =userRepository.findById(userName).get();
		String newGenerateToken = jwtUtil.generateToken(userDetails , user);

		
		return new JwtResponse(user, newGenerateToken);
		
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(username).get();
		if(user != null ) {
			System.out.print("user mawjoud");
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getUserPassword(),
					getAuthorities(user)
					);
		}else {
			throw new UsernameNotFoundException("username is not valid");
		}
	}
	
	private Set getAuthorities (User user) {
		 Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        user.getRole().forEach(role -> {
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
	        });
	        return authorities;
	}
	
	private void authenticate(String userName , String userPassword) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));

		}catch(DisabledException e ) {
			throw new Exception("user is disabled ");
		}catch(BadCredentialsException e) {
			throw new Exception("bad credentials from user ");
		}
	}

}
