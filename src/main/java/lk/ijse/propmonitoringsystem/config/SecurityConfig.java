/* Created By Sithira Roneth
 * Date :12/6/24
 * Time :10:08
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.config;

import lk.ijse.propmonitoringsystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;
//    private final JWTConfigFilter jwtConfigFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req ->
//                        req.requestMatchers("auth/**")
//                                .permitAll()
//                                .anyRequest()
//                                .authenticated())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtConfigFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider dap =
//                new DaoAuthenticationProvider();
//        dap.setUserDetailsService(userService.userDetailsService());
//        dap.setPasswordEncoder(passwordEncoder());
//        return dap;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//
//    }
}
