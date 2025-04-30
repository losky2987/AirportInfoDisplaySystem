package losky2987.AirportInfoDisplay.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/error",
                                "/css/**",
                                "/js/**",
                                "/login",
                                "/gate",
                                "/central",
                                "/oauth2/**"
                        ).permitAll()
                        .requestMatchers("/admin/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/login")
                )
                .logout(logout -> logout.logoutSuccessUrl("/login"));
        return chainBuilder.build();
    }
}
