package com.prosayj.springboot.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * @author yangjian
 * @description 金额转换成中文大写
 * @Date 10:35 2018/9/19
 * @since 1.0.0
 */
public class TransformMoneyUtils {

    /*
     * 以下摘自百度百科：http://baike.baidu.com/view/359995.htm 大写数字规则
     * 中文大写金额数字应用正楷或行书填写，如壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整（正）等字样。不得用一、二（两）、
     * 三、四、五、六、七、八、九、十、廿、毛、另（或０）填写，不得自造简化字。如果金额数字书写中使用繁体字，如贰、陆、亿、万、圆的，也可。
     * 中文大写金额数字到"元"为止的，在"元"之后，应写"整"（或"正"）字，在"角"之后，可以不写"整"（或"正"）字。大写金额数字有"分"的，
     * "分"后面不写"整"（或"正"）字。 中文大写金额数字前应标明"人民币"字样，大写金额数字有"分"的，"分"后面不写"整"（或"正"）字。
     * 中文大写金额数字前应标明"人民币"字样，大写金额数字应紧接"人民币"字样填写，不得留有空白。大写金额数字前未印"人民币"字样的，
     * 应加填"人民币"三字。在票据和结算凭证大写金额栏内不得预印固定的"仟、佰、拾、万、仟、佰、拾、元、角、分"字样。
     * 阿拉伯数字小写金额数字中有"0"时，中文大写应按照汉语语言规律、金额数字构成和防止涂改的要求进行书写。举例如下：
     * 阿拉伯数字中间有"0"时，中文大写要写"零"字，如￥1409.50，应写成人民币壹仟肆佰零玖元伍角。
     * 阿拉伯数字中间连续有几个"0"时，中文大写金额中间可以只写一个"零"字，如￥6007.14，应写成人民币陆仟零柒元壹角肆分。
     * 阿拉伯金额数字万位和元位是"0"，或者数字中间连续有几个"0"，万位、元位也是"0"，但千位、角位不是"0"时，中文大写金额中可以只写一个零字，
     * 也可以不写"零"字。如￥1680.32，应写成人民币壹仟陆佰捌拾元零叁角贰分，或者写成人民币壹仟陆佰捌拾元叁角贰分，又如￥107000.53，
     * 应写成人民币壹拾万柒仟元零伍角叁分，或者写成人民币壹拾万零柒仟元伍角叁分。
     * 阿拉伯金额数字角位是"0"，而分位不是"0"时，中文大写金额"元"后面应写"零"字。如￥16409.02，应写成人民币壹万陆仟肆佰零玖元零贰分；
     * 又如￥325.04，应写成人民币叁佰贰拾伍元零肆分。
     */
    /**
     * @description 亿
     */
    private static final char HUNDRED_MILLION_CHAR = '亿';
    /**
     * @description 整
     */
    private static final char ZHENG_CHAR = '整';
    /**
     * @description 元
     */
    private static final char YUAN_CHAR = '元';
    /**
     * @description 零
     */
    private static final char ZERO_CHAR = '零';
    /**
     * @description 万
     */
    private static final char TEN_THOUSAND = '万';
    /**
     * @description 零
     */
    private static final String ZERO_STR = "零";
    /**
     * 大写
     */
    private static final String BIG = "零壹贰叁肆伍陆柒捌玖";
    /**
     * 单位
     */
    private static final String[] UNITS = {"仟佰拾", "角分"};

    /**
     * 双精度浮点数转换成字符串 注： 1、如果直接用String.toString(double d)方法，超大数额会出现科学计数法的字符串；
     * 2、如果整数部分超过15位数，低位部分可能出现误差，所以不支持超过15位整数的数值，
     * 一般数据库设计金额字段时都不会超过15位整数，如oracle用Number(18,3)的类型表示，整数部分最多15位，小数点后保留3位有效数字。
     */
    public static String getDecimalStr(double d) {
        // 设置小数点后的精度，保留两位
        /*
         * 四舍五入结果参考: 0.005,//0.01入 0.015,//0.01舍 0.025,//0.03入 0.035,//0.04入
         * 0.045,//0.04舍 0.055,//0.06入(前一位是5则入)
         */
        String str = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

        /*
         * //经过测试，以下三种方法都是可以用的： //或1: String str = new BigDecimal(d).setScale(2,
         * BigDecimal.ROUND_HALF_UP).toPlainString();
         *
         * //或2： DecimalFormat format = new DecimalFormat();
         * format.applyPattern("#################0.00"); String str =
         * format.format(d);
         *
         * //或3: DecimalFormat decimalFormat = new DecimalFormat();
         * decimalFormat.setMinimumFractionDigits(2);
         * decimalFormat.setMaximumFractionDigits(2);
         * decimalFormat.setGroupingUsed(false);
         * decimalFormat.setMaximumIntegerDigits(15);
         * decimalFormat.setMinimumIntegerDigits(15);
         * str=decimalFormat.format(d);
         */

        // 如果结果是整数，则去掉尾巴
        if (str.endsWith(".00")) {
            str = str.substring(0, str.length() - 3);
        }
        return str;
    }

    /**
     * 金额是double类型的要先转换成字符串
     *
     * @param money 金额
     */
    public static String transform(double money) {
        String moneyStr = getDecimalStr(money);
        return transform(moneyStr);
    }

    /**
     * 金额转换成大字 我的思路： 1、double数值转换成数值字符串 2、处理整数部分：
     * 填充到16位，不足16位则前面补'0'，然后右起分成四组，每组根据"x仟x佰x拾x"的规则转换成大写，若该组为"0000"则结果是"零"；
     * 对这四组结果从高位到低位拼接起来，规则：[组4]万[组3]亿[组2]万[组1]圆。 3、处理小数部分（不多说）
     */
    public static String transform(String moneyStr) {
        // 区别整数、小数部分
        String[] parts = simpleSplit(moneyStr, ".");
        String result = "";
        StringBuilder tmpResult = new StringBuilder();

        // 处理整数部分
        // 整数部分的位数
        int length = parts[0].length();
        if (length > 15) {
            return "金额太大,不能处理整数部分超过15位的金额！";
        }
        String intPart = parts[0];

        // 填充到16位，因为是分4组，每组4个数字
        while (intPart.length() < 16) {
            intPart = '0' + intPart;
        }
        // 共分四组,右起四位一组,例如：0001,2003,0030,3400
        String[] groups = new String[4];
        for (int i = 0; i < groups.length; i++) {
            // 开始位置
            int start = intPart.length() - (i + 1) * 4;
            // 结束位置
            int end = intPart.length() - i * 4;
            groups[i] = intPart.substring(start, end);
            // 当前组的四位数字转换成大写
            groups[i] = transformGroup(groups[i]);
        }

        // 对这四组结果从高位到低位拼接起来，规则：[组4]万[组3]亿[组2]万[组1]圆
        for (int i = groups.length - 1; i >= 0; i--) {
            // 第四组：万亿级
            if (i == 3) {
                if (!ZERO_STR.equals(groups[i])) {
                    tmpResult.append(groups[i]).append(TEN_THOUSAND);
                }
            }
            // 第三组：亿级
            else if (i == 2) {
                if (!ZERO_STR.equals(groups[i])) {
                    tmpResult.append(groups[i]).append(HUNDRED_MILLION_CHAR);
                } else {
                    if (tmpResult.length() > 0) {
                        tmpResult.append(HUNDRED_MILLION_CHAR);
                    }
                }
            }
            // 第二组：万级
            else if (i == 1) {
                if (!ZERO_STR.equals(groups[i])) {
                    tmpResult.append(groups[i]).append(TEN_THOUSAND);
                } else if (!groups[i].startsWith(ZERO_STR)) {
                    tmpResult.append(groups[i]);
                }
            }
            // 第一组：千级
            else {
                if (!ZERO_STR.equals(groups[i]) || tmpResult.length() == 0) {
                    tmpResult.append(groups[i]);
                }
                tmpResult.append(YUAN_CHAR);
            }
        }
        if (tmpResult.charAt(0) == ZERO_CHAR && tmpResult.charAt(1) != YUAN_CHAR) {
            // 最前面的可能出现的“零”去掉
            tmpResult.deleteCharAt(0);
        }

        // 处理小数部分
        if (parts.length == 2) {
            // 小数部分
            String decimalPart = parts[1];
            for (int i = 0; i < decimalPart.length(); i++) {
                // 提取数字，左起
                int num = decimalPart.charAt(i) - '0';
                // 数字变大写加上单位
                tmpResult.append(BIG.charAt(num)).append(UNITS[1].charAt(i));
            }
            result = tmpResult.toString();
            result = StringUtils.replace(result, "零角", ZERO_STR);
            result = StringUtils.replace(result, "零分", ZERO_STR);
        } else {
            tmpResult.append(ZHENG_CHAR);
            //没有小数部分，则加上“整”
            result = tmpResult.toString();
        }

        return result;
    }

    /**
     * 处理整数部分的组，右起每四位是一组
     *
     * @param group 四位数字字符串
     */
    public static String transformGroup(String group) {
        String result = "";
        int length = group.length();
        StringBuilder tmpResult = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // 单个数字，左起
            int digit = group.charAt(i) - '0';
            tmpResult.append(BIG.charAt(digit));
            if (i != length - 1) {
                tmpResult.append(UNITS[0].charAt(i));
            }
        }
        result = tmpResult.toString();

        result = StringUtils.replace(result, "零仟", ZERO_STR);
        result = StringUtils.replace(result, "零佰", ZERO_STR);
        result = StringUtils.replace(result, "零拾", ZERO_STR);

        // 连续的零转为一个零
        tmpResult.setLength(0);
        boolean lastOneIsZero = false;
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (!lastOneIsZero || c != ZERO_CHAR) {
                tmpResult.append(c);
            }

            lastOneIsZero = c == ZERO_CHAR;
        }
        result = tmpResult.toString();

        if (!ZERO_STR.equals(result) && result.endsWith(ZERO_STR)) {
            // 最未尾的可能出现的“零”去掉
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static String fmtMicrometer(String text) {
        DecimalFormat df = null;
        if (text.indexOf(".") > 0) {
            if (text.length() - text.indexOf(".") - 1 == 0) {
                df = new DecimalFormat("###,##0.");
            } else if (text.length() - text.indexOf(".") - 1 == 1) {
                df = new DecimalFormat("###,##0.0");
            } else {
                df = new DecimalFormat("###,##0.00");
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }

    private static String[] simpleSplit(String originString, String delim) {
        StringTokenizer stringTokenizer = new StringTokenizer(originString, delim);
        String[] result = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stringTokenizer.nextToken();
        }
        return result;
    }


    /**
     * 单位分转元
     *
     * @param cent
     * @return
     */
    public static String transformCent(long cent) {
        if (cent < 0) {
            return null;
        }
        return BigDecimal.valueOf(cent).divide(new BigDecimal(100)).toString();
    }

    public static String transformCentTwoDecimal(Long value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.divide(new BigDecimal(100)).setScale(2, RoundingMode.FLOOR).toString();
    }

}
