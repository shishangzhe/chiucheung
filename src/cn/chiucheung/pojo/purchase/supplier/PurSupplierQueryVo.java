package cn.chiucheung.pojo.purchase.supplier;

public class PurSupplierQueryVo {

    private String name;

    private String supplyLevel;

    private String province;

    private String city;

    private int page;//第几页

    private int rows;//每页多少条记录

    private int startPage;

    private String sort;

    private String order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplyLevel() {
        return supplyLevel;
    }

    public void setSupplyLevel(String supplyLevel) {
        this.supplyLevel = supplyLevel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStartPage() {
        return (page-1)*rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
