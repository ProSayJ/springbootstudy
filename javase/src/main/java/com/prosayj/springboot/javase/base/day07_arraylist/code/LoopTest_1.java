package com.prosayj.springboot.javase.base.day07_arraylist.code;


/*
   要求: 计算出水仙花数
     三位数 100-999  个位数的立方+十位数的立方+百位数的立方 = 自己本身
	 153 = 1*1*1 + 5*5*5 + 3*3*3
	 已知三位数  123  获取出每个数位 利用 除法,取模运算
	 
	实现步骤:
	 1. 定义变量才存储 三个数位上的整数
	 2. 利用循环,循环中的变量,从100变化到999
	 3. 循环中得到三位数,利用算法,拆解成三个单独数位
	 4. 将三个数位立方的求和计算, 计算后的求和,和他自己进行比较判断
	    想同,就是水仙花
*/
public class LoopTest_1{
	public static void main(String[] args){
		//定义三个变量
		int bai = 0;
		int shi = 0;
		int ge = 0 ;
		
		//循环,循环变量从100-999
		for(int i = 100 ; i < 1000 ; i++){
			//对i,进行计算,获取出三个数位
			//获取百位
			bai = i / 100;
			//获取十位
			shi = i / 10 % 10;
			//获取个位
			ge = i % 10;
			//对三个数位进行立方求和
			if(bai * bai * bai + shi * shi *shi + ge * ge *ge == i){
				System.out.println(i);
			}
		}
	}
}




