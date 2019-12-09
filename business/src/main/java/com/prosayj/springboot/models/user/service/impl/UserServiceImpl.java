package com.prosayj.springboot.models.user.service.impl;

import com.prosayj.springboot.models.user.domain.UserDomain;
import com.prosayj.springboot.models.user.dto.UserDTO;
import com.prosayj.springboot.models.user.mapper.UserDomainMapper;
import com.prosayj.springboot.models.user.service.UserService;
import com.prosayj.springboot.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/19 15:00
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public List<UserDTO> queryAllUser() {
        UserDomain userDomain = new UserDomain();
        List<UserDomain> userDomains = userDomainMapper.queryByCondition(userDomain);
        return BeanUtil.toBeanList(userDomains, UserDTO.class);
    }

    @Override
    public List<UserDTO> queryUserByCondition(UserDTO userDTO) {
        return null;
    }
}
