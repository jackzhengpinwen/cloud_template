package com.zpw.sprintboot.sprintboottemplate.system.service;

import com.zpw.sprintboot.sprintboottemplate.system.entity.User;

public interface UserService extends BaseService<User> {
    void login(User user);
}
