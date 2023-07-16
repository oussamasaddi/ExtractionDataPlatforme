package esprit.tn.extraireDataBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class ExtraireDataBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtraireDataBackApplication.class, args);
	}

}
