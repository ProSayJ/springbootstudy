/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.spring4.vo入参校验;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import spring4.constants.ValidationConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author yangjian
 * @description
 * @Date 10:33 2018/8/8
 * @since 1.0.0
 */
public class CompanySubjoinCacheVO {
    @ApiModelProperty(value = "机构类型", required = true)
    private Integer type;

    @Size(max = ValidationConstants.CERTIFICATE_CODE_LENGTH_MAX)
    @ApiModelProperty(value = "税务登记证号码", required = true)
    private String taxCode;

    @Size(max = ValidationConstants.FULL_NAME_MAX)
    @ApiModelProperty(value = "法人姓名", required = true)
    private String corpName;

    @ApiModelProperty(value = "法人证件类型：0-身份证；1-护照；2-驾驶执照", required = true)
    private Integer corpCardType;

    @ApiModelProperty(value = "法人证件号", required = true)
    @Size(max = ValidationConstants.CERTIFICATE_CODE_LENGTH_MAX)
    private String corpCardId;

    @ApiModelProperty(value = "法人证件有效期", required = true)
    private Long corpCardDate;

    @ApiModelProperty(value = "企业所在城市", required = true)
    @Length(min = ValidationConstants.CITY_LENGTH_MIN, max = ValidationConstants.CITY_LENGTH_MAX)
    @NotNull
    @NotEmpty
    private String city;

    @ApiModelProperty(value = "企业所在省", required = true)
    @NotNull
    @NotEmpty
    private String province;

    @ApiModelProperty(value = "企业注册地址", required = false)
    @Size(max = ValidationConstants.ADDRESS_LENGTH_MAX)
    private String address;

    @ApiModelProperty(value = "联系人姓名", required = false)
    @Size(max = ValidationConstants.FULL_NAME_MAX)
    private String contactName;

    @ApiModelProperty(value = "联系人手机号", required = false)
    @Size(max = ValidationConstants.PHONE_LENGTH_MAX)
    private String contactPhone;

    @ApiModelProperty(value = "营业执照文件id", required = true)
    private Long businessFileId;

    @ApiModelProperty(value = "法人证件文件id", required = true)
    private Long corpFileId;

    @ApiModelProperty(value = "联系人身份证文件id", required = true)
    private Long contactFileId;

    @ApiModelProperty(value = "评级报告文件id：核心企业/金融机构必填，供应商不需要", required = true)
    private Long reportFileId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public Integer getCorpCardType() {
        return corpCardType;
    }

    public void setCorpCardType(Integer corpCardType) {
        this.corpCardType = corpCardType;
    }

    public String getCorpCardId() {
        return corpCardId;
    }

    public void setCorpCardId(String corpCardId) {
        this.corpCardId = corpCardId;
    }

    public Long getCorpCardDate() {
        return corpCardDate;
    }

    public void setCorpCardDate(Long corpCardDate) {
        this.corpCardDate = corpCardDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getBusinessFileId() {
        return businessFileId;
    }

    public void setBusinessFileId(Long businessFileId) {
        this.businessFileId = businessFileId;
    }

    public Long getCorpFileId() {
        return corpFileId;
    }

    public void setCorpFileId(Long corpFileId) {
        this.corpFileId = corpFileId;
    }

    public Long getContactFileId() {
        return contactFileId;
    }

    public void setContactFileId(Long contactFileId) {
        this.contactFileId = contactFileId;
    }

    public Long getReportFileId() {
        return reportFileId;
    }

    public void setReportFileId(Long reportFileId) {
        this.reportFileId = reportFileId;
    }
}
