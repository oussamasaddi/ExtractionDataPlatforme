package esprit.tn.extraireDataBack.configuration;


import esprit.tn.extraireDataBack.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private JwtAuthentificationEntryPoint jwtAuthentificationEntryPoint ;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter ;
	
	@Autowired
	private JwtService jwtService ;
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
    	
    	//temchi hedhi
        //http.csrf().disable()
        //.authorizeRequests().antMatchers("/**")
        //.fullyAuthenticated().and().httpBasic();
    	
    	http.csrf().disable()
    		.authorizeRequests().antMatchers("/authenticate" , "/registerNewUser").permitAll()
    		.antMatchers(HttpHeaders.ALLOW).permitAll()
    		.anyRequest().authenticated()
    		.and()
    		.exceptionHandling().authenticationEntryPoint(jwtAuthentificationEntryPoint)
    		.and()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	 http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);    }



    //tekhdem
    
 /**  
  *  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("oussama")
        .password("{noop}admin").roles("USER");
}**/
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
    }
  
}