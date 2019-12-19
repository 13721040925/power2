package cn.pojo;

import org.springframework.stereotype.Component;

@Component("warnlog")
public class Warnlog {

	private Long id;
	private String warntime;
	private String ip;
	private Integer address_cooperate_id;
	private String cooperate_name;
	private Integer group_id;// 0表示温度的
	private Integer type;// 1：保护，2：告警，3：其他，4：温度
	private Long child_warn_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getWarntime() {
		return warntime;
	}
	public void setWarntime(String warntime) {
		this.warntime = warntime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getAddress_cooperate_id() {
		return address_cooperate_id;
	}

	public void setAddress_cooperate_id(Integer address_cooperate_id) {
		this.address_cooperate_id = address_cooperate_id;
	}

	public String getCooperate_name() {
		return cooperate_name;
	}

	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getChild_warn_id() {
		return child_warn_id;
	}

	public void setChild_warn_id(Long child_warn_id) {
		this.child_warn_id = child_warn_id;
	}
	@Override
	public String toString() {
		return "Warnlog [id=" + id + ", warntime=" + warntime + ", ip=" + ip + ", address_cooperate_id="
				+ address_cooperate_id + ", cooperate_name=" + cooperate_name + ", group_id=" + group_id + ", type="
				+ type + ", child_warn_id=" + child_warn_id + "]";
	}

	
}
