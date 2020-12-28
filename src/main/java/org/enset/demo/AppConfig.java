package org.enset.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"org.enset.demo.controller","org.enset.demo.aspects"})
public class AppConfig {

}
