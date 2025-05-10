package security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
	    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
	    jdbcUserDetailsManager.setUsersByUsernameQuery("select email, password, 'true' from users where email=?");
	    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select email,CONCAT('ROLE_', role) from users where email=?");
	    return jdbcUserDetailsManager;
	}
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {	
        http
            .authorizeHttpRequests(configurer -> configurer
            			//.requestMatchers("/api/**").authenticated().anyRequest().permitAll()
            		.requestMatchers(HttpMethod.GET,"/api/customers/{id}/**").hasAnyRole("CUSTOMER","MANAGER","ADMIN")
            		.requestMatchers(HttpMethod.PUT,"/api/customers/**").hasAnyRole("CUSTOMER","ADMIN")
            		.requestMatchers(HttpMethod.GET,"/api/fooditem/**").permitAll()
            		.requestMatchers("/api/fooditem/**").hasAnyRole("MANGER","ADMIN")
            		.requestMatchers(HttpMethod.GET,"/api/managers/{id}").hasAnyRole("MANGER","ADMIN")
            		.requestMatchers(HttpMethod.PUT,"/api/managers/{id}").hasAnyRole("MANGER","ADMIN")
            		.requestMatchers(HttpMethod.GET,"/api/restaurant/**").hasAnyRole("MANGER","ADMIN")
            		.requestMatchers("/api/**").hasRole("ADMIN")
            		
            );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
