package com.prosayj.models.user.service;

import com.prosayj.models.user.dto.UserDTO;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/19 14:55
 * @since 1.0.0
 */
public interface UserService {

    List<UserDTO> queryAllUser();

    List<UserDTO> queryUserByCondition(UserDTO userDTO);
}
