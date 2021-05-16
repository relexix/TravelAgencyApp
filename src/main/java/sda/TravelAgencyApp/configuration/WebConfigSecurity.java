package sda.TravelAgencyApp.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/","/css/**","/js/**","/login")
                .permitAll();
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        http
                //.httpBasic() login popup forteaza sa afiseze pentru user si parola
                .formLogin() // aceasta comanda indica springului ca avem propiul form de login
                .loginPage("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                //url care apare la form in action
                .defaultSuccessUrl("/")
                .failureUrl("/");
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    @Autowired //varianta cu inMemory auth
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("Alex")
                .password(passwordEncoder.encode("123456"))
                .roles("USER")
                .and()
                .passwordEncoder(passwordEncoder);
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception{
//        auth
//                .jdbcAuthentication()
//                .dataSource(this.dataSource)
//                .passwordEncoder(passwordEncoder);
//        System.out.println(passwordEncoder().encode("123"));
//    }
}
