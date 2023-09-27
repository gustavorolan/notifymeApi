package com.notfyme.api.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.session.web.http.HeaderHttpSessionIdResolver.xAuthToken
import org.springframework.session.web.http.HttpSessionIdResolver


@Configuration
@EnableMethodSecurity(jsr250Enabled = true)
class SecurityConfig {

    @Bean
    fun httpSessionIdResolver(): HttpSessionIdResolver {
        return xAuthToken()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf {
            it.disable()
        }.cors {
            it.disable()
        }.httpBasic {
        }.authorizeHttpRequests {
            it.requestMatchers(AntPathRequestMatcher("/login")).permitAll()
                .requestMatchers(AntPathRequestMatcher("/empresa/adicionar")).permitAll()
                .anyRequest().authenticated()
        }

        return http.build()
    }

}
