package com.ycj.reservation.config;

import com.ycj.reservation.pojo.User;
import com.ycj.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;
    @Autowired
    UserDetailsServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByName(userName);
        if (user == null){
            throw new UsernameNotFoundException("用户:"+userName +"不存在 ！");
        }
        List<SimpleGrantedAuthority> sampleGrantedAuthorities = createAuthorities(user.getRoles());
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),sampleGrantedAuthorities);
    }

    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String []roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for(String role : roles){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }
}
