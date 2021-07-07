package dio.API_Pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"dio.API_Pessoa.controller", "dio.API_Pessoa.service", "dio.API_Pessoa.mapper",
		"dio.API_Pessoa.dto", "dio.API_Pessoa.enums"})
@EntityScan(basePackages = { "dio.API_Pessoa.entity" })
@EnableJpaRepositories(basePackages = { "dio.API_Pessoa.repository" })


//@EnableAutoConfiguration
public class ApiPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPessoaApplication.class, args);
	}

}
