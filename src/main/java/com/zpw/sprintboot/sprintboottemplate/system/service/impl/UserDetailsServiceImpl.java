package com.zpw.sprintboot.sprintboottemplate.system.service.impl;

import com.zpw.sprintboot.sprintboottemplate.system.dao.UserDao;
import com.zpw.sprintboot.sprintboottemplate.system.entity.Permission;
import com.zpw.sprintboot.sprintboottemplate.system.entity.Role;
import com.zpw.sprintboot.sprintboottemplate.system.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        List<Role> roles = user.getRoles();
        List<Permission> permissions = roles.stream().flatMap(r->r.getPermissions().stream()).distinct().toList();
        user.setAuthorities(permissions);
        return user;
    }
}
