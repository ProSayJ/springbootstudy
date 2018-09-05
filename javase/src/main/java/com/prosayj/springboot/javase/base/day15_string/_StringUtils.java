package com.prosayj.springboot.javase.base.day15_string;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/29 22:13
 * @since 1.0.0
 */
public class _StringUtils {
    public static void main(String[] args) {
        String str = null;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d %n", 100 / 2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
        System.out.println("=======================");
        boolean empty = StringUtils.isEmpty("qww");
        System.out.println(empty);
        List<String> list= null;
        System.out.println(CollectionUtils.isEmpty(list));

        Calendar now = Calendar.getInstance();
        String inviteCode = String.format("%02d", now.get(Calendar.DAY_OF_MONTH)) + RandomStringUtils.randomAlphanumeric(4);
        System.out.println(inviteCode);
        String str1 = "【{$supplyerName}】使用【{$voucherNo}】凭证申请融资【{$financeAmount}】元【{$createTime}】";
        String str2 = "【%s】使用【{$voucherNo}】凭证申请融资【{$financeAmount}】元【{$createTime}】";
        System.out.println(String.format(str2,"哈哈哈"));

    }
}
