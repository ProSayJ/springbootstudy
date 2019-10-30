package com.prosayj.springboot.test.model;

import java.io.Serializable;

/**
 * <b><code>ChartCategory</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/10/31 21:58.
 *
 * @author Hu Weihui
 */
public class ChartCategory implements Serializable {

    private static final long serialVersionUID = -4012247073667886579L;
    //类别名
    private String categoryName;

    //值
    private Double val;

	public ChartCategory(String categoryName, double val) {

        this.categoryName = categoryName;
        this.val = val;
    }

    public ChartCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
	}
	

}
