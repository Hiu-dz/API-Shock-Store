package com.hieuvo.shonkstore.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable() // Tắt tính năng CSRF để các request có thể được gửi bằng phương thức POST, PUT, DELETE.
                .authorizeHttpRequests() // Bắt đầu cấu hình cho việc xác thực request.
                .requestMatchers("/api/v1/accounts/**") // Các request này sẽ được cho phép truy cập mà không cần xác thực.
                .permitAll()
                .anyRequest().authenticated() // Các request không thuộc URL được định nghĩa trong requestMatchers sẽ yêu cầu xác thực.
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Chỉ định rằng việc quản lý session sẽ không được thực hiện bởi Spring Security. Bởi vì, chúng ta đang sử dụng JWT để xác thực, session không còn cần thiết.
                .and()
                .authenticationProvider(authenticationProvider) // Cung cấp một AuthenticationProvider để xác thực người dùng.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Chèn jwtAuthenticationFilter vào filter chain của Spring Security. Filter này được sử dụng để xác thực và giải mã token JWT.
                .build(); // Kết thúc việc cấu hình và trả về một SecurityFilterChain.
    }
}
