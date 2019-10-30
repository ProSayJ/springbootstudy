package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.List;

public class TableData  implements Serializable {

    private static final long serialVersionUID = -4364010424789708099L;
    //表格一行数据
    private List<TableRowData> tableRowDataList;

    private Integer num;

    public TableData() {

    }

    public TableData(List<TableRowData> tableRowDataList) {
        this.tableRowDataList = tableRowDataList;
    }

    public List<TableRowData> getTableRowDataList() {
        return tableRowDataList;
    }

    public void setTableRowDataList(List<TableRowData> tableRowDataList) {
        this.tableRowDataList = tableRowDataList;
    }

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    
}
