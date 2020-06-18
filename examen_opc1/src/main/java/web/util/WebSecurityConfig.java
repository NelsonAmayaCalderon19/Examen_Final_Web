package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Necesario para evitar que la seguridad se aplique a los resources
    // Como los css, imagenes y javascripts
    String[] resources = new String[] {"/css/**", "/img/**", "/js/**"};

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/", "/index", "/iniciar","/ufps","/colport","/perfil","/perfil/**","/menu","/menu/**" ).permitAll()
                //.antMatchers("/home/**","/index","/index/**","/home","/cliente","/cliente/**","/empleado","/empleado/**","/inventario","/inventario/**").hasAuthority("ADMIN")
               // .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/iniciar").permitAll().defaultSuccessUrl("/perfil/")
                .failureUrl("/iniciar?error=true")
                .and()
                .logout().deleteCookies("JSESSIONID").permitAll().logoutSuccessUrl("/iniciar?logout");
    }  

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }


    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}