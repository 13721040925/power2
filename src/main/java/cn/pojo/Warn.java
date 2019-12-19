package cn.pojo;

import org.springframework.stereotype.Component;

@Component("warn")
public class Warn {

	private Long id;
	private Integer powertemplower;
	private Integer powertemphigher;
	private Integer indivhighers;
	private Integer indivlowers;
	private Integer groupvhigher;
	private Integer groupvlower;
	private Integer powerahigher; 
	private Integer bmu;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPowertemplower() {
		return powertemplower;
	}
	public void setPowertemplower(Integer powertemplower) {
		this.powertemplower = powertemplower;
	}
	public Integer getPowertemphigher() {
		return powertemphigher;
	}
	public void setPowertemphigher(Integer powertemphigher) {
		this.powertemphigher = powertemphigher;
	}

	public Integer getIndivhighers() {
		return indivhighers;
	}

	public void setIndivhighers(Integer indivhighers) {
		this.indivhighers = indivhighers;
	}

	public Integer getIndivlowers() {
		return indivlowers;
	}

	public void setIndivlowers(Integer indivlowers) {
		this.indivlowers = indivlowers;
	}
	public Integer getGroupvhigher() {
		return groupvhigher;
	}
	public void setGroupvhigher(Integer groupvhigher) {
		this.groupvhigher = groupvhigher;
	}
	public Integer getGroupvlower() {
		return groupvlower;
	}
	public void setGroupvlower(Integer groupvlower) {
		this.groupvlower = groupvlower;
	}
	public Integer getPowerahigher() {
		return powerahigher;
	}
	public void setPowerahigher(Integer powerahigher) {
		this.powerahigher = powerahigher;
	}
	public Integer getBmu() {
		return bmu;
	}
	public void setBmu(Integer bmu) {
		this.bmu = bmu;
	}
	@Override
	public String toString() {
		return "Warn [id=" + id + ", powertemplower=" + powertemplower + ", powertemphigher=" + powertemphigher
				+ ", indivhighers=" + indivhighers + ", indivlowers=" + indivlowers + ", groupvhigher=" + groupvhigher
				+ ", groupvlower=" + groupvlower + ", powerahigher=" + powerahigher + ", bmu=" + bmu + "]";
	}


	
}
