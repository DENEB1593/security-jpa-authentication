package io.study.deneb;

import io.study.deneb.model.Post;
import io.study.deneb.model.User;
import io.study.deneb.repository.PostRepository;
import io.study.deneb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(PostRepository postRepository,
                                      UserRepository userRepository,
                                      PasswordEncoder encoder) {
    return args -> {
      User deneb = new User("deneb", encoder.encode("1234"), "ROLE_USER");
      User admin = new User("admin", encoder.encode("1234"), "ROLE_USER,ROLE_ADMIN");
      // Init User
      userRepository.save(deneb);
      userRepository.save(admin);

      // Init Post
      postRepository.save(new Post("hello everyone", "slug1",  "for everyone", deneb.getUsername()));
      postRepository.save(new Post("something wrong", "slug2",  "there's no content", admin.getUsername()));
      postRepository.save(new Post("thx!", "slug3",  "thanks for that!", deneb.getUsername()));
      postRepository.save(new Post("not good", "slug4",  "for good", deneb.getUsername()));
    };
  }

}
