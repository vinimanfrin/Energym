package com.globalsolution.energym;

import com.globalsolution.energym.domain.entities.Academia;
import com.globalsolution.energym.domain.entities.Endereco;
import com.globalsolution.energym.domain.entities.Praticante;
import com.globalsolution.energym.domain.entities.User;
import com.globalsolution.energym.repositories.AcademiaRepository;
import com.globalsolution.energym.repositories.ExercicioRepository;
import com.globalsolution.energym.repositories.PraticanteRepository;
import com.globalsolution.energym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class EnergymApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnergymApplication.class, args);
	}

	@Autowired
	private AcademiaRepository academiaRepository;

	@Autowired
	private PraticanteRepository praticanteRepository;

	@Autowired
	private ExercicioRepository exercicioRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"vini","vini@gmail.com", passwordEncoder.encode("123456"));
		userRepository.save(user);
		Academia academia = academiaRepository.save(new Academia(null,"cnpj","nome",user,new Endereco(null,"200","rua","bairro","cidade","estado","04330060")));
		Praticante praticante = praticanteRepository.save(new Praticante(null,"52887068830","vinicius@email.com", LocalDate.now(),0,1));
		praticanteRepository.save(praticante);
	}
}
