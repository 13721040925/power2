package cn.pojo;

import org.springframework.stereotype.Component;

@Component("individual")
public class Individual {
	private Long id;
	private Long group_id;
	private String group_name;
	private Integer indi_num;
	private Double indi_v;
	private Double indi_tem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public Double getIndi_v() {
		return indi_v;
	}

	public void setIndi_v(Double indi_v) {
		this.indi_v = indi_v;
	}

	public Double getIndi_tem() {
		return indi_tem;
	}

	public void setIndi_tem(Double indi_tem) {
		this.indi_tem = indi_tem;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public Integer getIndi_num() {
		return indi_num;
	}

	public void setIndi_num(Integer indi_num) {
		this.indi_num = indi_num;
	}

	@Override
	public String toString() {
		return "Individual [id=" + id + ", group_id=" + group_id + ", group_name=" + group_name + ", indi_num="
				+ indi_num + ", indi_v=" + indi_v + ", indi_tem=" + indi_tem + "]";
	}



}
