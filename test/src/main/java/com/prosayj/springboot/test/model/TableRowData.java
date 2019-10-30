package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.List;

public class TableRowData  implements Serializable {

    private static final long serialVersionUID = 3301688856074972172L;
    //每一行数据
    private List<String> dataList;

    public TableRowData() {
    }

    public TableRowData(List<String> dataList) {
        this.dataList = dataList;
    }


    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }
}
