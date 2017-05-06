package pl.quider.web.komis.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.quider.web.komis.models.User;
import pl.quider.web.komis.repositories.UserReposiory;
import pl.quider.web.komis.services.UserService;

import java.util.HashSet;

/**
 * Created by adrian on 04.05.17.
 */
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/css/**", "/js/**", "/registration").permitAll()
////                .antMatchers("/form").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().logoutUrl("/logout")
//                .permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        userService.createNewUserIfNooneExists();
    }
}
