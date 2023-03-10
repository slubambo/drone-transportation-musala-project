package drone.config;

import drone.security.CustomUserDetailsService;
import drone.security.JwtAuthenticationEntryPoint;
import drone.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
  securedEnabled = true,
  jsr250Enabled = true,
  prePostEnabled = true
)
public class SecurityConfig {

  @Autowired
  CustomUserDetailsService customUserDetailsService;

  @Autowired
  private JwtAuthenticationEntryPoint unauthorizedHandler;

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    return new JwtAuthenticationFilter();
  }

  @Bean
  public AuthenticationManager authManager(
    HttpSecurity http,
    BCryptPasswordEncoder bCryptPasswordEncoder
  ) throws Exception {
    return http
      .getSharedObject(AuthenticationManagerBuilder.class)
      .userDetailsService(customUserDetailsService)
      .passwordEncoder(passwordEncoder())
      .and()
      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
      .cors()
      .and()
      .csrf()
      .disable()
      .exceptionHandling()
      .authenticationEntryPoint(unauthorizedHandler)
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeHttpRequests(requests ->
        requests
          .requestMatchers(new AntPathRequestMatcher("/"))
          .permitAll()
          .requestMatchers(new AntPathRequestMatcher("/api/auth/**"))
          .permitAll()
          .anyRequest()
          .authenticated()
      );

    // Add our custom JWT security filter
    http.addFilterBefore(
      jwtAuthenticationFilter(),
      UsernamePasswordAuthenticationFilter.class
    );

    return http.build();
  }
}
