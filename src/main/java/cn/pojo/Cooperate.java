package cn.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("cooperate")
public class Cooperate {
	private Long id;
	private String ip;
	private String cooperate_name;//����������
	private Double fdtime;// �ŵ絹��ʱ
	private Integer totaltime;// �ŵ���ʱ��
	private Integer onlioncount;// �������������
	private List<Cooperate> coopList; 
	private String state;
	private String logtime;
	private String version;
	//private Group[] groups = new Group[6];
//	private List<Group> grouplts;
//	private List<Warnlog> loglts;
//	private Warnlog warnlog;
//	private Group group;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCooperate_name() {
		return cooperate_name;
	}
	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}
	public Double getFdtime() {
		return fdtime;
	}
	public void setFdtime(Double fdtime) {
		this.fdtime = fdtime;
	}
	public Integer getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}
	public Integer getOnlioncount() {
		return onlioncount;
	}
	public void setOnlioncount(Integer onlioncount) {
		this.onlioncount = onlioncount;
	}
	public List<Cooperate> getCoopList() {
		return coopList;
	}
	public void setCoopList(List<Cooperate> coopList) {
		this.coopList = coopList;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Cooperate [id=" + id + ", ip=" + ip + ", cooperate_name=" + cooperate_name + ", fdtime=" + fdtime
				+ ", totaltime=" + totaltime + ", onlioncount=" + onlioncount + ", coopList=" + coopList + ", state="
				+ state + ", logtime=" + logtime + ", version=" + version + "]";
	}

	
}
