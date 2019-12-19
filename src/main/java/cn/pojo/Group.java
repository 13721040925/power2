package cn.pojo;

import org.springframework.stereotype.Component;

@Component("group")
public class Group {
	private Long id;
	private Long cooperate_id;
	private String group_name;//�������
	private Double group_v;//������ѹ
	private Double group_a;//��������
	private Integer group_ah;//ʵ������
	private Integer indi_m;// �����ĵ������m
	private Integer indi_n;// �����ĵ����¶���n
	private Integer dod;
	private Double middle_v;//�е��ѹ
	private Integer surplus_time;//�ŵ�ʣ��ʱ��(��ʣ���ٵ�)
	private Integer group_total_time;//�����ŵ�ʱ��
	private String cooperate_name;//����������
	private Warnlog warnlog;
	private String name;
	private Integer batter_type;// 1:铁锂电池 0：铅酸电池
	private Integer group_num;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCooperate_id() {
		return cooperate_id;
	}

	public void setCooperate_id(Long cooperate_id) {
		this.cooperate_id = cooperate_id;
	}

	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public Double getGroup_v() {
		return group_v;
	}
	public void setGroup_v(Double group_v) {
		this.group_v = group_v;
	}
	public Double getGroup_a() {
		return group_a;
	}
	public void setGroup_a(Double group_a) {
		this.group_a = group_a;
	}
	public Integer getGroup_ah() {
		return group_ah;
	}
	public void setGroup_ah(Integer group_ah) {
		this.group_ah = group_ah;
	}
	public Integer getIndi_m() {
		return indi_m;
	}
	public void setIndi_m(Integer indi_m) {
		this.indi_m = indi_m;
	}
	public Integer getIndi_n() {
		return indi_n;
	}
	public void setIndi_n(Integer indi_n) {
		this.indi_n = indi_n;
	}
	public Integer getDod() {
		return dod;
	}
	public void setDod(Integer dod) {
		this.dod = dod;
	}
	public Double getMiddle_v() {
		return middle_v;
	}
	public void setMiddle_v(Double middle_v) {
		this.middle_v = middle_v;
	}
	public Integer getSurplus_time() {
		return surplus_time;
	}
	public void setSurplus_time(Integer surplus_time) {
		this.surplus_time = surplus_time;
	}
	public Integer getGroup_total_time() {
		return group_total_time;
	}
	public void setGroup_total_time(Integer group_total_time) {
		this.group_total_time = group_total_time;
	}
	public String getCooperate_name() {
		return cooperate_name;
	}
	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}
	public Warnlog getWarnlog() {
		return warnlog;
	}
	public void setWarnlog(Warnlog warnlog) {
		this.warnlog = warnlog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getBatter_type() {
		return batter_type;
	}

	public void setBatter_type(Integer batter_type) {
		this.batter_type = batter_type;
	}

	public Integer getGroup_num() {
		return group_num;
	}

	public void setGroup_num(Integer group_num) {
		this.group_num = group_num;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", cooperate_id=" + cooperate_id + ", group_name=" + group_name + ", group_v="
				+ group_v + ", group_a=" + group_a + ", group_ah=" + group_ah + ", indi_m=" + indi_m + ", indi_n="
				+ indi_n + ", dod=" + dod + ", middle_v=" + middle_v + ", surplus_time=" + surplus_time
				+ ", group_total_time=" + group_total_time + ", cooperate_name=" + cooperate_name + ", warnlog="
				+ warnlog + ", name=" + name + ", batter_type=" + batter_type + ", group_num=" + group_num + "]";
	}
	
}
