package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/10 下午 03:42
 * @since 1.0.0
 */
public class ListFiler {
    public static void main(String[] args) {
        List<CompanyInviteInfoConfigDomain> inviteConfigs = toInviteConfigs();

        //过滤形成map
        Map<Long, List<CompanyInviteInfoConfigDomain>> companyOperationModeConfigs = inviteConfigs.stream()
                .filter(inviteConfig -> inviteConfig.getProductId() != null)
                .collect(Collectors.groupingBy(CompanyInviteInfoConfigDomain::getProductId));
    }


    private static List<CompanyInviteInfoConfigDomain> toInviteConfigs() {
      
        List<CompanyInviteInfoConfigDomain> inviteConfigs = new ArrayList<>();
        CompanyInviteInfoConfigDomain value1 = new CompanyInviteInfoConfigDomain();
        value1.setInviteId(1L);
        value1.setProductId(null);
        value1.setOwnerType("COMPANY");
        value1.setType("OPERATION_IDENTIFY");
        value1.setValue("yinuo");
        value1.setLabel("运营方标识");

        CompanyInviteInfoConfigDomain value2 = new CompanyInviteInfoConfigDomain();
        value2.setInviteId(1L);
        value2.setProductId(1L);
        value2.setOwnerType("PRODUCT");
        value2.setType("COMPANY_TYPE");
        value2.setValue("CORE");
        value2.setLabel("企业类型");

        CompanyInviteInfoConfigDomain value3 = new CompanyInviteInfoConfigDomain();
        value3.setInviteId(1L);
        value3.setProductId(1L);
        value3.setOwnerType("PRODUCT");
        value3.setType("ACCESS_MODE");
        value3.setValue("1");
        value3.setLabel("系统对接");

        CompanyInviteInfoConfigDomain value4 = new CompanyInviteInfoConfigDomain();
        value4.setInviteId(1L);
        value4.setProductId(5L);
        value4.setOwnerType("PRODUCT");
        value4.setType("ACCESS_MODE");
        value4.setValue("0");
        value4.setLabel("接口对接");

        CompanyInviteInfoConfigDomain value5 = new CompanyInviteInfoConfigDomain();
        value5.setInviteId(1L);
        value5.setProductId(1L);
        value5.setOwnerType("PRODUCT");
        value5.setType("OPERATION_MODE");
        value5.setValue("SUB_ACCOUNT");
        value5.setLabel("子账户模式");

        CompanyInviteInfoConfigDomain value6 = new CompanyInviteInfoConfigDomain();
        value6.setInviteId(1L);
        value6.setProductId(2L);
        value6.setOwnerType("PRODUCT");
        value6.setType("OPERATION_MODE");
        value6.setValue("SETTLEMENT_ACCOUNT");
        value6.setLabel("结算户模式");

        CompanyInviteInfoConfigDomain value7 = new CompanyInviteInfoConfigDomain();
        value7.setInviteId(1L);
        value7.setProductId(1L);
        value7.setOwnerType("PRODUCT");
        value7.setType("COMPANY_TYPE");
        value7.setValue("SUPPER");
        value7.setLabel("企业类型");


        CompanyInviteInfoConfigDomain value8 = new CompanyInviteInfoConfigDomain();
        value8.setInviteId(1L);
        value8.setProductId(1L);
        value8.setOwnerType("PRODUCT");
        value8.setType("USE_EXPANSION");
        value8.setValue("1");
        value8.setLabel("应用扩展包信息");

        CompanyInviteInfoConfigDomain value9 = new CompanyInviteInfoConfigDomain();
        value9.setInviteId(1L);
        value9.setProductId(1L);
        value9.setOwnerType("PRODUCT");
        value9.setType("CONFIG_EXPANSION");
        value9.setValue("1");
        value9.setLabel("可配扩展包信息");

        inviteConfigs.add(value1);
        inviteConfigs.add(value2);
        inviteConfigs.add(value3);
        inviteConfigs.add(value4);
        inviteConfigs.add(value5);
        inviteConfigs.add(value6);
        inviteConfigs.add(value7);
        inviteConfigs.add(value8);
        inviteConfigs.add(value9);
        return inviteConfigs;

    }
}

class CompanyInviteInfoConfigDomain {
    private Long id;

    private Long inviteId;

    private Long productId;

    private String ownerType;

    private String type;

    private String value;

    private String label;

    private String remark1;

    private String remark2;

    private Date createTime;

    private Date updateTime;

    private Byte isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "CompanyInviteInfoConfigDomain{" +
                "id=" + id +
                ", inviteId=" + inviteId +
                ", productId=" + productId +
                ", ownerType='" + ownerType + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
