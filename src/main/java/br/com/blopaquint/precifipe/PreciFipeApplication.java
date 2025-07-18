package br.com.blopaquint.precifipe;

import br.com.blopaquint.precifipe.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreciFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PreciFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Main main = new Main();
		main.exibeMenu();

	}
}