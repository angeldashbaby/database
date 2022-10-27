package angelbaby.database.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final String corsOrigin="http://localhost:3000";

        http.addFilterBefore(new CorsFilter(corsConfigurationSource(corsOrigin)), AbstractPreAuthenticatedProcessingFilter.class)

                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated() // เอา ; ออกด้วยค่ะ

                // use stateless session, so user's state is not stored
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // use oauth as a resource server to do jwt validation
                .and()
                .oauth2ResourceServer()
                .jwt()
                .decoder(jwtDecoder());

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }


    private JwtDecoder jwtDecoder() {
        OAuth2TokenValidator<Jwt> withAudience =
                new AudienceValidator(audience);

        OAuth2TokenValidator<Jwt> withIssuer =
                JwtValidators.createDefaultWithIssuer(issuer);

        OAuth2TokenValidator<Jwt> validator =
                new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
                JwtDecoders.fromOidcIssuerLocation(issuer);

        jwtDecoder.setJwtValidator(validator);

        return jwtDecoder;
    }

    private CorsConfigurationSource corsConfigurationSource(String corsOrigin) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(corsOrigin));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","HEAD","OPTIONS","PUT","PATCH","DELETE"));
        configuration.setMaxAge(10L);
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Accept","Access-Control-Request-Method","Access-Control-Request-Headers",
                "Accept-Language","Authorization","Content-Type","Request-Name","Request-Surname","Origin","X-Request-AppVersion",
                "X-Request-OsVersion", "X-Request-Device", "X-Requested-With"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
