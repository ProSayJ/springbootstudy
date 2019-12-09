package com.prosayj.springboot;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/27 下午 01:46
 * @since 1.0.0
 */
public class Test02 {

    public String jsonString2 = "\"data\": \"[\n" +
            "\t{\n" +
            "\t\\\"address\\\":\\\"\\\",\n" +
            "\t\\\"appId\\\":\\\"fpms\\\",\n" +
            "\t\\\"arrayParentCode\\\":\\\"[ZB]\\\",\n" +
            "\t\\\"arrayParentId\\\": \\\"[ed06b34c98b84318b3745242800cf9d2][2aa1a23aaf6f49c5af60c71277449dbe]\\\",\n" +
            "\t\t\t\t\t\t\\\"attributes\\\":{\n" +
            "\t\t\t\t\t\t\t\\\"model\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\t\\\"page\\\":\\\"1,79,68,73,80,66,86,87,82,75,90,83,91,76,74,89,84,78,77,5,85,92,2,3,4,69,19,72,88,81,93,94,95,96,97,98,99,100,101,102,103,104,151,152,153,154,155,156,157,158\\\",\n" +
            "\t\t\t\t\t\t\t\\\"gsdmtype\\\":\\\"\\\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\\\"contact\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"createTime\\\":\\\"2018-09-14\\\",\n" +
            "\t\t\t\t\t\t\\\"createUserAccount\\\":\\\"fpmsadmin\\\",\n" +
            "\t\t\t\t\t\t\\\"createUserId\\\":3603516,\n" +
            "\t\t\t\t\t\t\\\"createUserName\\\":\\\"大数据应用管理员\\\",\n" +
            "\t\t\t\t\t\t\\\"delFlag\\\":0,\n" +
            "\t\t\t\t\t\t\\\"email\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"enterCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"enterName\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"fax\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"fullName\\\":\\\"总部总部机关财务\\\",\n" +
            "\t\t\t\t\t\t\\\"hasChild\\\":0,\n" +
            "\t\t\t\t\t\t\\\"isUsed\\\":0,\n" +
            "\t\t\t\t\t\t\\\"limit\\\":0,\n" +
            "\t\t\t\t\t\t\\\"oldParentId\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"orderNum\\\":33,\n" +
            "\t\t\t\t\t\t\\\"orgCode\\\":\\\"ZB\\\",\n" +
            "\t\t\t\t\t\t\\\"orgId\\\":\\\"2aa1a23aaf6f49c5af60c71277449dbe\\\",\n" +
            "\t\t\t\t\t\t\\\"orgIdAndOrgCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"orgLevelCode\\\":\\\"two-level\\\",\n" +
            "\t\t\t\t\t\t\\\"orgLevelId\\\":\\\"4ad4d1eb09ab4f7c8c966f490b2aa5a3\\\",\n" +
            "\t\t\t\t\t\t\\\"orgLevelName\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"orgName\\\":\\\"总部机关财务\\\",\n" +
            "\t\t\t\t\t\t\\\"orgTypeCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"orgTypeId\\\":\\\"fd8a6c2d157d41d8aeff19500a9f789a\\\",\n" +
            "\t\t\t\t\t\t\\\"orgTypeName\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"orgUsers\\\":[],\n" +
            "\t\t\t\t\t\t\\\"parentCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"parentId\\\":\\\"ed06b34c98b84318b3745242800cf9d2\\\",\n" +
            "\t\t\t\t\t\t\\\"parentIdAndCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"parentOrgName\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"phone\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"positionCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"positionDesc\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"positionId\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"positionIdAndCode\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"remark\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"reserve1\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"reserve2\\\":\\\"\\\",\n" +
            "\t\t\t\t\t\t\\\"shortName\\\":\\\"总部机关财务\\\",\n" +
            "\t\t\t\t\t\t\\\"start\\\":0,\n" +
            "\t\t\t\t\t\t\\\"subOrg\\\":[],\n" +
            "\t\t\t\t\t\t\\\"updateTime\\\":\\\"2019-10-10\\\",\n" +
            "\t\t\t\t\t\t\\\"updateUserAccount\\\":\\\"luanfz8888.lube\\\",\n" +
            "\t\t\t\t\t\t\\\"updateUserId\\\":3603516,\n" +
            "\t\t\t\t\t\t\\\"updateUserName\\\":\\\"大数据应用管理员\\\",\n" +
            "\t\t\t\t\t\t\\\"zipCode\\\":\\\"\\\"\n" +
            "\t\t\t\t\t}\n" +
            "]\"";
    public String jsonString = "{\n" +
            " \"success\": true,\n" +
            " \"code\": null,\n" +
            " \"msg\": null,\n" +
            " \"detail\": null,\n" +
            " \"data\": \"[{\\\"address\\\":\\\"\\\",\\\"appId\\\":\\\"fpms\\\",\\\"arrayParentCode\\\":\\\"[ZB]\\\",\\\"arrayParentId\\\":\\\"[ed06b34c98b84318b3745242800cf9d2][2aa1a23aaf6f49c5af60c71277449dbe]\\\",\\\"attributes\\\":{\\\"model\\\":\\\"\\\",\\\"page\\\":\\\"1,79,68,73,80,66,86,87,82,75,90,83,91,76,74,89,84,78,77,5,85,92,2,3,4,69,19,72,88,81,93,94,95,96,97,98,99,100,101,102,103,104,151,152,153,154,155,156,157,158\\\",\\\"gsdmtype\\\":\\\"\\\"},\\\"contact\\\":\\\"\\\",\\\"createTime\\\":\\\"2018-09-14\\\",\\\"createUserAccount\\\":\\\"fpmsadmin\\\",\\\"createUserId\\\":3603516,\\\"createUserName\\\":\\\"大数据应用管理员\\\",\\\"delFlag\\\":0,\\\"email\\\":\\\"\\\",\\\"enterCode\\\":\\\"\\\",\\\"enterName\\\":\\\"\\\",\\\"fax\\\":\\\"\\\",\\\"fullName\\\":\\\"总部总部机关财务\\\",\\\"hasChild\\\":0,\\\"isUsed\\\":0,\\\"limit\\\":0,\\\"oldParentId\\\":\\\"\\\",\\\"orderNum\\\":33,\\\"orgCode\\\":\\\"ZB\\\",\\\"orgId\\\":\\\"2aa1a23aaf6f49c5af60c71277449dbe\\\",\\\"orgIdAndOrgCode\\\":\\\"\\\",\\\"orgLevelCode\\\":\\\"two-level\\\",\\\"orgLevelId\\\":\\\"4ad4d1eb09ab4f7c8c966f490b2aa5a3\\\",\\\"orgLevelName\\\":\\\"\\\",\\\"orgName\\\":\\\"总部机关财务\\\",\\\"orgTypeCode\\\":\\\"\\\",\\\"orgTypeId\\\":\\\"fd8a6c2d157d41d8aeff19500a9f789a\\\",\\\"orgTypeName\\\":\\\"\\\",\\\"orgUsers\\\":[],\\\"parentCode\\\":\\\"\\\",\\\"parentId\\\":\\\"ed06b34c98b84318b3745242800cf9d2\\\",\\\"parentIdAndCode\\\":\\\"\\\",\\\"parentOrgName\\\":\\\"\\\",\\\"phone\\\":\\\"\\\",\\\"positionCode\\\":\\\"\\\",\\\"positionDesc\\\":\\\"\\\",\\\"positionId\\\":\\\"\\\",\\\"positionIdAndCode\\\":\\\"\\\",\\\"remark\\\":\\\"\\\",\\\"reserve1\\\":\\\"\\\",\\\"reserve2\\\":\\\"\\\",\\\"shortName\\\":\\\"总部机关财务\\\",\\\"start\\\":0,\\\"subOrg\\\":[],\\\"updateTime\\\":\\\"2019-10-10\\\",\\\"updateUserAccount\\\":\\\"luanfz8888.lube\\\",\\\"updateUserId\\\":3603516,\\\"updateUserName\\\":\\\"大数据应用管理员\\\",\\\"zipCode\\\":\\\"\\\"}]\"\n" +
            "}";

    @Test
    public void m1() {
        List<Result> results = JSON.parseArray(jsonString, Result.class);
        System.out.println(results.toString());

    }



    class Result{
        private String success;
        private String code;
        private String detail;
        //private List<PermistionData> data;

        @Override
        public String toString() {
            return "Result{" +
                    "success='" + success + '\'' +
                    ", code='" + code + '\'' +
                    ", detail='" + detail + '\'' +
                    '}';
        }
    }

    class PermistionData{

    }



  /*  public void insertAll(PublicAuthPage publicAuthPage) {
        String sql = "insert into t_public_auth_page values(?,?)";
        jdbcTemplate.update(sql,publicAuthPage.getUid(),publicAuthPage.getPageId());
    }*/
}
