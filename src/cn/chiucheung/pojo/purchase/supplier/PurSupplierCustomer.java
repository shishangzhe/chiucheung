package cn.chiucheung.pojo.purchase.supplier;

import cn.chiucheung.po.purchase.supplier.PurSupplier;

import java.io.Serializable;

public class PurSupplierCustomer extends PurSupplier implements Serializable {
    private String haveImg;

    public String getHaveImg() {
        return haveImg;
    }

    public void setHaveImg(String haveImg) {
        this.haveImg = haveImg;
    }
}
