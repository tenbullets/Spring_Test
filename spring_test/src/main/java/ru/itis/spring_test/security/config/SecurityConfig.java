package ru.itis.spring_test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**").antMatchers("/imgs/**").antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/welcome").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/confirm").permitAll()

                .antMatchers("/**").authenticated()
                .antMatchers("/users").hasAnyAuthority("ADMIN")
                .antMatchers("/search").hasAnyAuthority("ADMIN")
                .antMatchers("/ban").hasAnyAuthority("ADMIN")
                .antMatchers("/addAdmin").hasAnyAuthority("ADMIN")
                .antMatchers("/profile").authenticated()
                .antMatchers("/addPost").authenticated()
                .antMatchers("/sendLike").authenticated()
                .antMatchers("/feed").authenticated()
                .antMatchers("/theWall").authenticated()
                .antMatchers("delUserAccount").authenticated()
                .antMatchers("/files/**").authenticated()

                .and()

                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .permitAll();
    }
}
