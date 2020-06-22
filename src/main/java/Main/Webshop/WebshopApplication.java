package Main.Webshop;

import Controllers.LoginController;
import Models.Account;
import Repositories.LoginRepository;
import Services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = LoginController.class)
@EnableJpaRepositories(basePackageClasses = LoginRepository.class)
@EntityScan(basePackageClasses = Account.class)
public class WebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

	@Bean
	public iLoginService iLoginService()
	{
		return new LoginService(){};
	}

	@Bean
	public iBestellingService iBestellingService()
	{
		return new BestellingService(){};
	}

	@Bean
	public iProductService iProductService()
	{
		return new ProductService(){};
	}
}
