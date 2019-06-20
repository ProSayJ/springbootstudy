package com.prosayj.springboot.myblog.api_freemark;

import io.swagger.annotations.ApiModelProperty;

public class PublicModulePageVO {
    @ApiModelProperty(value = "css列样式", required = false)
    private String cssCol;
    @ApiModelProperty(value = "cssFree", required = false)
    private String cssFree;
    @ApiModelProperty(value = "css的Option", required = false)
    private String cssOption;
    @ApiModelProperty(value = "数据", required = false)
    private ModuleDataVO data;
    @ApiModelProperty(value = "样式", required = false)
    private String layout;
    @ApiModelProperty(value = "模块ID", required = false)
    private Integer modelId;
    @ApiModelProperty(value = "顺序", required = false)
    private Integer order;
    @ApiModelProperty(value = "小标题", required = false)
    private String pageTitle;
    @ApiModelProperty(value = "页id", required = false)
    private Integer pageId;
    @ApiModelProperty(value = "是否展开：1-展开；0-不展开？？", required = false)
    private Integer spread;
    @ApiModelProperty(value = "提示信息", required = false)
    private String tipMsg;
    @ApiModelProperty(value = "标题", required = false)
    private String title;
    @ApiModelProperty(value = "标题是否显示：1-显示；0-不显示？？", required = false)
    private Integer titleShow;
    @ApiModelProperty(value = "表类型", required = false)
    private String type;

    public String getCssCol() {
        return cssCol;
    }

    public void setCssCol(String cssCol) {
        this.cssCol = cssCol;
    }

    public String getCssFree() {
        return cssFree;
    }

    public void setCssFree(String cssFree) {
        this.cssFree = cssFree;
    }

    public String getCssOption() {
        return cssOption;
    }

    public void setCssOption(String cssOption) {
        this.cssOption = cssOption;
    }

    public ModuleDataVO getData() {
        return data;
    }

    public void setData(ModuleDataVO data) {
        this.data = data;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public String getTipMsg() {
        return tipMsg;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTitleShow() {
        return titleShow;
    }

    public void setTitleShow(Integer titleShow) {
        this.titleShow = titleShow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PublicModulePageVO{" +
                "cssCol='" + cssCol + '\'' +
                ", cssFree='" + cssFree + '\'' +
                ", cssOption='" + cssOption + '\'' +
                ", data=" + data +
                ", layout='" + layout + '\'' +
                ", modelId=" + modelId +
                ", order=" + order +
                ", pageTitle='" + pageTitle + '\'' +
                ", pageId=" + pageId +
                ", spread=" + spread +
                ", tipMsg='" + tipMsg + '\'' +
                ", title='" + title + '\'' +
                ", titleShow=" + titleShow +
                ", type='" + type + '\'' +
                '}';
    }
}

