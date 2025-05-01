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
                                "/admin/login",
                                "/gate",
                                "/central",
                                "/oauth2/**"
                        ).permitAll()
                        .requestMatchers("/admin/airport/**", "/admin/airlines/**", "/admin/ground_staff/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/admin/login")
                )
                .logout(logout -> logout.logoutSuccessUrl("/admin/login"));
        return chainBuilder.build();
    }
}
