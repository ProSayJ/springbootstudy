package com.prosayj.models.user.service.impl;

import com.prosayj.models.user.domain.UserDomain;
import com.prosayj.models.user.dto.UserDTO;
import com.prosayj.models.user.mapper.UserDomainMapper;
import com.prosayj.models.user.service.UserService;
import com.prosayj.springboot.utils.BeanUtils;
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
        return BeanUtils.toBeanList(userDomains, UserDTO.class);
    }

    @Override
    public List<UserDTO> queryUserByCondition(UserDTO userDTO) {
        return null;
    }
}
