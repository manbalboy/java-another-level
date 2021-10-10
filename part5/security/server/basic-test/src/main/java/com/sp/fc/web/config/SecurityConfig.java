package com.sp.fc.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(1) /*여러개의 필터를 활용할 때 순서가 중요 Order 필수*/
@EnableWebSecurity(debug = true) /* 필터체이닝을 할 수 있도록 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(
                        User.builder()
                                .username("user2")
                                .password(passwordEncoder().encode("2222"))
                                .roles("USER"))
                .withUser(User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("3333"))
                        .roles("ADMIN")
                );

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //필터체인 설정 할수 있음
        http.authorizeRequests((requests) ->
                requests.antMatchers("/")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        );
        http.formLogin();
        http.httpBasic();


        // 필터기능을 제거할수 있음
        //http.headers().disable().csrf().disable();
    }
}
