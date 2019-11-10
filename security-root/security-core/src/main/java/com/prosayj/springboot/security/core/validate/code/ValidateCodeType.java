//package com.prosayj.springboot.security.core.validate.code;
//
//
//import com.prosayj.springboot.security.core.properties.SecurityConstants;
//
///**
// * @description
// * @author yangjian
// * @Date 下午 11:23 2019/11/3
// * @since 1.0.0
// */
//public enum ValidateCodeType {
//
//	/**
//	 * 短信验证码
//	 */
//	SMS {
//		@Override
//		public String getParamNameOnValidate() {
//			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
//		}
//	},
//	/**
//	 * 图片验证码
//	 */
//	IMAGE {
//		@Override
//		public String getParamNameOnValidate() {
//			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
//		}
//	};
//
//	/**
//	 * 校验时从请求中获取的参数的名字
//	 * @return
//	 */
//	public abstract String getParamNameOnValidate();
//
//}
