package com.example.sz02420.checkbox;

public class Goods {
    private String id;
    private String goodsName;
    private String codeBar;
    private boolean isChecked;
    public Goods() {
        super();
    }

    public Goods(String id, String goodsName, String codeBar) {
        super();
        this.id = id;
        this.goodsName = goodsName;
        this.codeBar = codeBar;
    }
    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

}