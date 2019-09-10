package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.method;

/**
 * Created by Tom
 */
public class Method {
    private void modifyUserInfo(String userName,String address){
        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserInfo(String userName,String... fileds){
        userName = "Tom";
//        address = "Changsha";
    }
    private void modifyUserInfo(String userName,String address,boolean bool){
        if(bool){

        }else{

        }

        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserName(String userName){
        userName = "Tom";
    }
    private void modifyAddress(String address){
        address = "Changsha";
    }




}
