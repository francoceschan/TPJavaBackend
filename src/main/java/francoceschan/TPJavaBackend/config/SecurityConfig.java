package francoceschan.TPJavaBackend.config;

import francoceschan.TPJavaBackend.config.filter.JwtTokenValidator;
import francoceschan.TPJavaBackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                //No mantiene la sesion, de esto se encarga el token, cuando vence el token se cierra la sesion
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {

                    // AUTH
                    http.requestMatchers(HttpMethod.GET, "/auth/token").hasAnyRole("ADMINISTRATIVO", "DEVELOPER");
                    http.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();

                    // VIAJE
                    http.requestMatchers(HttpMethod.GET, "/viaje/getViajesDisponibles").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/viaje/busqueda").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/viaje/guardar").hasAnyRole("ADMINISTRATIVO");
                    http.requestMatchers(HttpMethod.GET, "/viaje/getAll").hasAnyRole("ADMINISTRATIVO");
                    http.requestMatchers(HttpMethod.DELETE, "/viaje/**").hasAnyRole("ADMINISTRATIVO");


                    // CIUDAD
                    http.requestMatchers(HttpMethod.POST, "/ciudad/**").hasAnyRole("ADMINISTRATIVO");
                    http.requestMatchers(HttpMethod.GET, "/ciudad/getAll").permitAll();

                    // COLECTIVO
                    http.requestMatchers(HttpMethod.POST, "/colectivo/**").hasAnyRole("ADMINISTRATIVO");
                    http.requestMatchers(HttpMethod.GET, "/colectivo/**").hasAnyRole("ADMINISTRATIVO");
                    http.requestMatchers(HttpMethod.DELETE, "/colectivo/**").hasAnyRole("ADMINISTRATIVO");

                    // BOLETO
                    http.requestMatchers(HttpMethod.POST, "/boleto/**").hasAnyRole("PASAJERO");

                    // PASAJERO
                    http.requestMatchers(HttpMethod.GET, "/pasajero/**").hasAnyRole("PASAJERO");


                    http.requestMatchers(HttpMethod.GET, "/colectivo/getPermiso").hasAnyRole("ADMINISTRATIVO", "DEVELOPER");
                    //http.requestMatchers(HttpMethod.GET, "/colectivo/guardar").hasAuthority("CREATE");

                    //http.anyRequest().authenticated();
                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

/*    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("franco")
                .password("java")
                .roles("ADMIN")
                .authorities("READ", "CREATE")
                .build();

        return  new InMemoryUserDetailsManager(userDetails);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
