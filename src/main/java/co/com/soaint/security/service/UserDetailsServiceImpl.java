package co.com.soaint.security.service;

import co.com.soaint.security.entity.User;
import co.com.soaint.security.entity.UserPrimary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = usuarioService.getByUserName(userName).get();
        return UserPrimary.build(user);
    }
}
