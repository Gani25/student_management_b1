package com.sprk.student_management;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Student Management System For SPRK Technologies",
				description = "REST API's created to understand the concepts of Backend in SPRING BOOT",
				version = "v1.2.30",
				contact = @Contact(
						name = "ABDUL GANI",
						email = "memonabdulgani3d@gmail.com",
						url = "https://www.sprktechnologies.in"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.sprktechnologies.in"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "REST API doc's for Student Management System",
				url = "http://localhost:8080/swagger-ui.html"
				// url = "http://localhost:8080/swagger-ui/index.html"
		)
)
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
