package esprit.tn.extraireDataBack.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CoresConfiguration {
	
	private static final String GET ="GET";
	private static final String POST = "POST";
	private static final String DELETE = "DELETE";
	private static final String PUT = "PUT";

	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				//WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping("/**")
						.allowedMethods(GET , POST , DELETE , PUT)
						.allowedHeaders("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true);
				
			}
			
			
		};
	}

}
