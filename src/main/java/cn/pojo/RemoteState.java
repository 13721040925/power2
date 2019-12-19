package cn.pojo;

import org.springframework.stereotype.Component;

@Component("remoteState")
public class RemoteState {
	private Integer id;
	private String cooperate_ip;
	private String cooperate_name;
	// 第一组
	private Integer group1xianliu;// 第1组限流方式开启/关闭,1：开启 0：关闭(下同)
	private Integer group1inpower;// 第1组充电开启/关闭
	private Integer group1outpower;// 第1组放电开启/关闭
	private Integer group1inorder;// 第1组充电顺序(取值范围1~6)
	private Integer group1outorder;// 第1组放电顺序
	// 第二组
	private Integer group2xianliu;
	private Integer group2inpower;
	private Integer group2outpower;
	private Integer group2inorder;
	private Integer group2outorder;
	// 第三组
	private Integer group3xianliu;
	private Integer group3inpower;
	private Integer group3outpower;
	private Integer group3inorder;
	private Integer group3outorder;
	// 第四组
	private Integer group4xianliu;
	private Integer group4inpower;
	private Integer group4outpower;
	private Integer group4inorder;
	private Integer group4outorder;
	// 第五组
	private Integer group5xianliu;
	private Integer group5inpower;
	private Integer group5outpower;
	private Integer group5inorder;
	private Integer group5outorder;
	// 第六组
	private Integer group6xianliu;
	private Integer group6inpower;
	private Integer group6outpower;
	private Integer group6inorder;
	private Integer group6outorder;

	private Integer inoutmodel;// 充放电模式 1：同充同放 2：同充异放 3：异充同放 4：异充异放

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCooperate_ip() {
		return cooperate_ip;
	}

	public void setCooperate_ip(String cooperate_ip) {
		this.cooperate_ip = cooperate_ip;
	}

	public String getCooperate_name() {
		return cooperate_name;
	}

	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}

	public Integer getGroup1xianliu() {
		return group1xianliu;
	}

	public void setGroup1xianliu(Integer group1xianliu) {
		this.group1xianliu = group1xianliu;
	}

	public Integer getGroup1inpower() {
		return group1inpower;
	}

	public void setGroup1inpower(Integer group1inpower) {
		this.group1inpower = group1inpower;
	}

	public Integer getGroup1outpower() {
		return group1outpower;
	}

	public void setGroup1outpower(Integer group1outpower) {
		this.group1outpower = group1outpower;
	}

	public Integer getGroup1inorder() {
		return group1inorder;
	}

	public void setGroup1inorder(Integer group1inorder) {
		this.group1inorder = group1inorder;
	}

	public Integer getGroup1outorder() {
		return group1outorder;
	}

	public void setGroup1outorder(Integer group1outorder) {
		this.group1outorder = group1outorder;
	}

	public Integer getGroup2xianliu() {
		return group2xianliu;
	}

	public void setGroup2xianliu(Integer group2xianliu) {
		this.group2xianliu = group2xianliu;
	}

	public Integer getGroup2inpower() {
		return group2inpower;
	}

	public void setGroup2inpower(Integer group2inpower) {
		this.group2inpower = group2inpower;
	}

	public Integer getGroup2outpower() {
		return group2outpower;
	}

	public void setGroup2outpower(Integer group2outpower) {
		this.group2outpower = group2outpower;
	}

	public Integer getGroup2inorder() {
		return group2inorder;
	}

	public void setGroup2inorder(Integer group2inorder) {
		this.group2inorder = group2inorder;
	}

	public Integer getGroup2outorder() {
		return group2outorder;
	}

	public void setGroup2outorder(Integer group2outorder) {
		this.group2outorder = group2outorder;
	}

	public Integer getGroup3xianliu() {
		return group3xianliu;
	}

	public void setGroup3xianliu(Integer group3xianliu) {
		this.group3xianliu = group3xianliu;
	}

	public Integer getGroup3inpower() {
		return group3inpower;
	}

	public void setGroup3inpower(Integer group3inpower) {
		this.group3inpower = group3inpower;
	}

	public Integer getGroup3outpower() {
		return group3outpower;
	}

	public void setGroup3outpower(Integer group3outpower) {
		this.group3outpower = group3outpower;
	}

	public Integer getGroup3inorder() {
		return group3inorder;
	}

	public void setGroup3inorder(Integer group3inorder) {
		this.group3inorder = group3inorder;
	}

	public Integer getGroup3outorder() {
		return group3outorder;
	}

	public void setGroup3outorder(Integer group3outorder) {
		this.group3outorder = group3outorder;
	}

	public Integer getGroup4xianliu() {
		return group4xianliu;
	}

	public void setGroup4xianliu(Integer group4xianliu) {
		this.group4xianliu = group4xianliu;
	}

	public Integer getGroup4inpower() {
		return group4inpower;
	}

	public void setGroup4inpower(Integer group4inpower) {
		this.group4inpower = group4inpower;
	}

	public Integer getGroup4outpower() {
		return group4outpower;
	}

	public void setGroup4outpower(Integer group4outpower) {
		this.group4outpower = group4outpower;
	}

	public Integer getGroup4inorder() {
		return group4inorder;
	}

	public void setGroup4inorder(Integer group4inorder) {
		this.group4inorder = group4inorder;
	}

	public Integer getGroup4outorder() {
		return group4outorder;
	}

	public void setGroup4outorder(Integer group4outorder) {
		this.group4outorder = group4outorder;
	}

	public Integer getGroup5xianliu() {
		return group5xianliu;
	}

	public void setGroup5xianliu(Integer group5xianliu) {
		this.group5xianliu = group5xianliu;
	}

	public Integer getGroup5inpower() {
		return group5inpower;
	}

	public void setGroup5inpower(Integer group5inpower) {
		this.group5inpower = group5inpower;
	}

	public Integer getGroup5outpower() {
		return group5outpower;
	}

	public void setGroup5outpower(Integer group5outpower) {
		this.group5outpower = group5outpower;
	}

	public Integer getGroup5inorder() {
		return group5inorder;
	}

	public void setGroup5inorder(Integer group5inorder) {
		this.group5inorder = group5inorder;
	}

	public Integer getGroup5outorder() {
		return group5outorder;
	}

	public void setGroup5outorder(Integer group5outorder) {
		this.group5outorder = group5outorder;
	}

	public Integer getGroup6xianliu() {
		return group6xianliu;
	}

	public void setGroup6xianliu(Integer group6xianliu) {
		this.group6xianliu = group6xianliu;
	}

	public Integer getGroup6inpower() {
		return group6inpower;
	}

	public void setGroup6inpower(Integer group6inpower) {
		this.group6inpower = group6inpower;
	}

	public Integer getGroup6outpower() {
		return group6outpower;
	}

	public void setGroup6outpower(Integer group6outpower) {
		this.group6outpower = group6outpower;
	}

	public Integer getGroup6inorder() {
		return group6inorder;
	}

	public void setGroup6inorder(Integer group6inorder) {
		this.group6inorder = group6inorder;
	}

	public Integer getGroup6outorder() {
		return group6outorder;
	}

	public void setGroup6outorder(Integer group6outorder) {
		this.group6outorder = group6outorder;
	}

	public Integer getInoutmodel() {
		return inoutmodel;
	}

	public void setInoutmodel(Integer inoutmodel) {
		this.inoutmodel = inoutmodel;
	}

	@Override
	public String toString() {
		return "RemoteState [id=" + id + ", cooperate_ip=" + cooperate_ip + ", cooperate_name=" + cooperate_name
				+ ", group1xianliu=" + group1xianliu + ", group1inpower=" + group1inpower + ", group1outpower="
				+ group1outpower + ", group1inorder=" + group1inorder + ", group1outorder=" + group1outorder
				+ ", group2xianliu=" + group2xianliu + ", group2inpower=" + group2inpower + ", group2outpower="
				+ group2outpower + ", group2inorder=" + group2inorder + ", group2outorder=" + group2outorder
				+ ", group3xianliu=" + group3xianliu + ", group3inpower=" + group3inpower + ", group3outpower="
				+ group3outpower + ", group3inorder=" + group3inorder + ", group3outorder=" + group3outorder
				+ ", group4xianliu=" + group4xianliu + ", group4inpower=" + group4inpower + ", group4outpower="
				+ group4outpower + ", group4inorder=" + group4inorder + ", group4outorder=" + group4outorder
				+ ", group5xianliu=" + group5xianliu + ", group5inpower=" + group5inpower + ", group5outpower="
				+ group5outpower + ", group5inorder=" + group5inorder + ", group5outorder=" + group5outorder
				+ ", group6xianliu=" + group6xianliu + ", group6inpower=" + group6inpower + ", group6outpower="
				+ group6outpower + ", group6inorder=" + group6inorder + ", group6outorder=" + group6outorder
				+ ", inoutmodel=" + inoutmodel + "]";
	}

}
