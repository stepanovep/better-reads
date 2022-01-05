package ru.stepanovep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.stepanovep.connection.DataStaxAstraProperties;
import ru.stepanovep.loader.author.Author;
import ru.stepanovep.loader.author.AuthorRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class Application {

    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @PostConstruct
    public void start() {
        System.out.println("### STARTED");
        Author author = new Author();
        author.setId("id");
        author.setName("name");
        author.setPersonalName("personalName");

        authorRepository.save(author);
    }
}
