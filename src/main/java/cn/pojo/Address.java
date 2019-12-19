package cn.pojo;

import org.springframework.stereotype.Component;

@Component("address")
public class Address {
	private Integer id;
	private String ip;
	private String cooperate_name;
	private String province;
	private String city;
	private String street;
	private String lng;
	private String lat;
	private String imei;
	private Integer states;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Integer getStates() {
		return states;
	}

	public void setStates(Integer states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", ip=" + ip + ", cooperate_name=" + cooperate_name + ", province=" + province
				+ ", city=" + city + ", street=" + street + ", lng=" + lng + ", lat=" + lat + ", imei=" + imei
				+ ", states=" + states + "]";
	}



}
