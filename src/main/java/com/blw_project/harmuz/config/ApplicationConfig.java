package com.blw_project.harmuz.config;

import com.blw_project.harmuz.repository.CustomerRepository;
import com.blw_project.harmuz.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return customerRepository.findByEmail(username)
                    .map(c -> org.springframework.security.core.userdetails.User
                            .withUsername(c.getEmail())
                            .password(c.getPassword())
                            .authorities(c.getRoles().stream().map(Enum::name).toArray(String[]::new))
                            .build())
                    .or(() -> vendorRepository.findByEmail(username)
                            .map(v -> org.springframework.security.core.userdetails.User
                                    .withUsername(v.getEmail())
                                    .password(v.getPassword())
                                    .authorities(v.getRoles().stream().map(Enum::name).toArray(String[]::new))
                                    .build()))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        };
    }
}