package com.sp.fc.web.student;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class StudentManager implements AuthenticationProvider, InitializingBean {

    private HashMap<String, Student> studentDB = new HashMap<>();


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        StudentAuthenticationToken token = (StudentAuthenticationToken) authentication;

        if (studentDB.containsKey(token.getCredentials())) {
            Student student = studentDB.get(token.getCredentials());
            return StudentAuthenticationToken.builder()
                    .principal(student)
                    .details(student.getUsername())
                    .authenticated(true)
                    .build();

        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == StudentAuthenticationToken.class;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Set.of(
                new Student("manbalboy", "훈", Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
                new Student("manbalboyA", "훈2", Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
                new Student("manbalboyB", "훈3", Set.of(new SimpleGrantedAuthority("ROLE_STUDENT")))
        ).forEach(
                s -> studentDB.put(s.getId(), s)
        );

    }
}
