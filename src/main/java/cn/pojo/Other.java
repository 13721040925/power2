package cn.pojo;

import org.springframework.stereotype.Component;

@Component("other")
public class Other {

	private Long id;
	private Integer power; //一下是状态1报错 0 正常
	private Integer ahlower;
	private Integer outpower;
	private Integer inpower;
	private Integer middlev;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getAhlower() {
		return ahlower;
	}
	public void setAhlower(Integer ahlower) {
		this.ahlower = ahlower;
	}
	public Integer getOutpower() {
		return outpower;
	}
	public void setOutpower(Integer outpower) {
		this.outpower = outpower;
	}
	public Integer getInpower() {
		return inpower;
	}
	public void setInpower(Integer inpower) {
		this.inpower = inpower;
	}
	public Integer getMiddlev() {
		return middlev;
	}
	public void setMiddlev(Integer middlev) {
		this.middlev = middlev;
	}
	@Override
	public String toString() {
		return "Other [id=" + id + ", power=" + power + ", ahlower=" + ahlower + ", outpower=" + outpower + ", inpower="
				+ inpower + ", middlev=" + middlev + "]";
	}


}
