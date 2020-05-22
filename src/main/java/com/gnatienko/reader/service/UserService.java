package com.gnatienko.reader.service;

import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService
{


    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String delete (Long userId){
        if(repository.findById(userId).isPresent()){
        repository.delete(repository.findById(userId).get());
        return "User is deleted";
        }
        else {
            return "User is not exist";
        }
    }

    public UserEntity save(UserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return repository.save(entity);
    }

    public UserEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    public Long userId (){
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findByEmail(userEmail).get().getId();
    }


}

