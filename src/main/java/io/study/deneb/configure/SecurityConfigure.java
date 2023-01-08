package io.study.deneb.configure;

import io.study.deneb.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigure {

  private final UserService userService;

  public SecurityConfigure(UserService userService) {
    this.userService = userService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .csrf(csrf -> csrf.ignoringRequestMatchers(antMatcher("/h2-console/**")))
            .authorizeHttpRequests(auth ->  auth
              .requestMatchers(antMatcher("/h2-console/**")).permitAll()
              .requestMatchers("/api/posts").permitAll()
              .anyRequest().authenticated())
            .headers(headers -> headers.frameOptions().sameOrigin())
            .httpBasic(withDefaults())
            .userDetailsService(userService)
            .build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
