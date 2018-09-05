package com.prosayj.springboot.javase.homework.day03_a.com.service.impl;

import com.prosayj.springboot.javase.homework.day03_a.com.dao.UserDBMapper;
import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDoman;
import com.prosayj.springboot.javase.homework.day03_a.com.dao.impl.UserDBMapperImpl;
import com.prosayj.springboot.javase.homework.day03_a.com.service.Convert;
import com.prosayj.springboot.javase.homework.day03_a.com.service.Dto.UserDto;
import com.prosayj.springboot.javase.homework.day03_a.com.service.UserService;
import com.prosayj.springboot.javase.homework.day03_a.com.service.userexpection.BusinessExpection;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:17
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {


    @Override
    public Boolean login(UserDto userDto, int loginTimes) {
        Boolean isLogin = Boolean.FALSE;

        // 对象转换
        UserDoman userDoman = Convert.toUserDoman(userDto);
        // 模拟spinrg注入dao层
        UserDBMapper userDBMapper = new UserDBMapperImpl();
        //dao层查询结果
        Boolean login = userDBMapper.checkUser(userDoman);
        //处理查询结果
        //判断登陆是否成功
        if (!login && loginTimes != 3) {
            System.out.println("===========登陆失败：您还有" + (3 - loginTimes) + "次机会！");
        } else if (login) {
            System.out.println("===========登陆成功");
            // TODO 登陆成功，进行猜数字小游戏
            // guessNum();
        }
        // 登陆次数限制
        if (!login && (loginTimes == 3)) {
            throw new BusinessExpection("账号已经锁定，请联系管理员");
        } else if (login) {
            isLogin = Boolean.TRUE;
        }
        return isLogin;
    }
}
