package org.enset.demo;

import org.enset.demo.model.Contrat;
import org.enset.demo.repository.ContratRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        org.enset.demo.aspects.ApplicationContext.authenticateUser("root","1234",new String[]{"ADMIN"});
        SpringApplication.run(DemoApplication.class, args);
    }

   /* @Bean
    CommandLineRunner start(ContratRepository contratRepository){
        return args -> {
            contratRepository.save(new Contrat(null,"Contrat 1",new Date(),1+new Random().nextDouble(),"Maazaz","U123456"));
            contratRepository.save(new Contrat(null,"Contrat 2",new Date(),1+new Random().nextDouble(),"Karimo","U123457"));
            contratRepository.save(new Contrat(null,"Contrat 3",new Date(),1+new Random().nextDouble(),"Salama","U123458"));
        };
    }*/

}
