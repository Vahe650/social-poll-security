package com.social.poll.socialpoll.controller;


import com.social.poll.socialpoll.dto.LoginUserRequest;
import com.social.poll.socialpoll.jwt.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Authentication")
@RestController
public class AuthApi {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;

    public AuthApi(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUserRequest loginUserRequest) throws AuthenticationException {
        // Perform the security
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginUserRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

        // Return the token
        return ResponseEntity.ok(token);
    }


}