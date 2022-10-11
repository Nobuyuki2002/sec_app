package oit.is.ouyouteam.c03.sec_app.sec_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserBuilder users = User.builder();

    //password: miren
    UserDetails riku = users
        .username("riku")
        .password("$2y$10$4JOswrcSCPDw/0.UFW6Afut7wNOmo6vZJ3wyBS.lK9ORhVLQMXBe2")
        .roles("RIKU")
        .build();
    //password: mugi
    UserDetails mugi = users
        .username("mugi")
        .password("$2y$10$IIRxRSv99NQJSW5st.tAteOjyCN.rywPqx06Q2log.POnvhm8mQAO")
        .roles("MUGI")
        .build();

    return new InMemoryUserDetailsManager(riku, mugi);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/sample3/**").authenticated();

    http.logout().logoutSuccessUrl("/");
    return http.build();
  }
}
