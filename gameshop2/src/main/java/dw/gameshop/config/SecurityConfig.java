package dw.gameshop.config;

import dw.gameshop.exception.MyAccessDeniedHandler;
import dw.gameshop.exception.MyAuthenticationEntryPoint;
import dw.gameshop.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers(  //이 주소들은
                                new AntPathRequestMatcher("/products/**"),
                                new AntPathRequestMatcher("/user/login"), //"/user/**" -> 모두 허용
                                new AntPathRequestMatcher("/user/signup"), //"/user/*" -> 첫번째 자식들만 허용
                                new AntPathRequestMatcher("/login")
                        ).permitAll()  //모두 접근 허용
                        .anyRequest().authenticated())  //어떤 요청이던 모두 인증 받겠다
                .formLogin(form->form.loginPage("/login").defaultSuccessUrl("/articles"))
                // 정적로그인 페이지가 있는경우 "/login"으로 리다이렉트 로그인 성공시  "/articles" 페이지로 리다이렉트
                .sessionManagement(session -> session //세션관리시 필요
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .csrf(AbstractHttpConfigurer::disable)  //Cross-Site Request Forgery 보호를 비활성화
                .exceptionHandling(exception -> exception  //예외
                        .authenticationEntryPoint(new MyAuthenticationEntryPoint())  // 인증실패
                        .accessDeniedHandler(new MyAccessDeniedHandler()))  // 권한실패
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailService userDetailService) throws Exception {
        // BCrypt : 블로피시 암호에 기반을 둔 암호화 해시함수
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {  //암호화
        return new BCryptPasswordEncoder();
    }
}
