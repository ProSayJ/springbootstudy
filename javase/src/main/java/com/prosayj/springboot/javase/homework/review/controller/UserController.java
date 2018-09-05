package com.prosayj.springboot.javase.homework.review.controller;


import com.prosayj.springboot.javase.homework.review.controller.tools.Convert;
import com.prosayj.springboot.javase.homework.review.controller.tools.MyselfException;
import com.prosayj.springboot.javase.homework.review.controller.vo.UserVo;
import com.prosayj.springboot.javase.homework.review.service.IUserService;
import com.prosayj.springboot.javase.homework.review.service.UserServiceImpl;
import com.prosayj.springboot.javase.homework.review.service.model.UserDto;

import java.util.Scanner;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 18:37
 * @since 1.0.0
 */
public class UserController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.println("============请输入用户名");
            String username = scanner.nextLine();
            System.out.println("============请输入密码");
            String password = scanner.nextLine();
            UserVo userVo = new UserVo(username, password);
            UserDto userDto = Convert.toUserDto(userVo);
            IUserService userService = new UserServiceImpl();
            Boolean aBoolean = userService.checkUser(userDto);

            System.out.println("这是第"+i+"次登录");
            if(aBoolean){
                break;
            }else if(!aBoolean && i>=3){
                try {
                    throw new MyselfException("账号或密码输入错误且输入超过3次");
                } catch (MyselfException e) {
                    e.printStackTrace();
                }
                break;
            }
            i++;
        }
    }
}
