package com.hwua.entity;

import java.util.Date;
/**
 * 商品表
 * @author oracleOAEC
 *
 */
public class Items {
    private Integer id;//编号

    private String name;//商品名字

    private Float price;//商品价格

    private String pic;//

    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	public Items(Integer id, String name, Float price, String pic, Date createtime, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.createtime = createtime;
		this.detail = detail;
	}

	public Items() {
		super();
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", createtime=" + createtime
				+ ", detail=" + detail + "]";
	}
     
}