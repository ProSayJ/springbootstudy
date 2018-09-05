package com.prosayj.springboot.javase.homework.day03_a.com.controller;


import com.prosayj.springboot.javase.homework.day03_a.com.controller.vo.UserVO;
import com.prosayj.springboot.javase.homework.day03_a.com.service.Convert;
import com.prosayj.springboot.javase.homework.day03_a.com.service.Dto.UserDto;
import com.prosayj.springboot.javase.homework.day03_a.com.service.UserService;
import com.prosayj.springboot.javase.homework.day03_a.com.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:04
 * @since 1.0.0
 */
public class UserLoginController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //登陆次数
        int loginTimes = 0;
        //循环输入
        while (true) {
            System.out.println("==========请输入用户名：");
            String userName = scanner.nextLine();
            System.out.println("==========请输入密码：");
            String pwd = scanner.nextLine();
            //封装入参数
            UserVO userVO = new UserVO(userName, pwd);
            //转换成DTO
            UserDto userDto = Convert.toUserDto(userVO);
            //模拟spring注解注入service
            UserService userService = new UserServiceImpl();
            //调用service的方法
            loginTimes++;
            Boolean login = userService.login(userDto, loginTimes);
            if (login) {
                break;
            }
        }


    }
}
