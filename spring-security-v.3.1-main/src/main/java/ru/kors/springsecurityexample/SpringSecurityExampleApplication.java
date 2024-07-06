package ru.kors.springsecurityexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class SpringSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExampleApplication.class, args);
		openHomePage("http://localhost:8080/login");
	}
	private static void openHomePage(String url) {
			System.err.println("Link is ready, please open " + url);
		}
	}
