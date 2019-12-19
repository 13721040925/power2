package cn.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.pojo.RemoteState;

public interface RemoteStateMapper {
	@Select(" select * from remotestate where cooperate_ip=#{cooperate_ip} ")
	RemoteState checkRemoteState(@Param("cooperate_ip") String cooperate_ip);

	@Insert(" insert into remotestate (cooperate_ip,cooperate_name,"
			+ "group1xianliu,group1inpower,group1outpower,group1inorder,group1outorder,"
			+ "group2xianliu,group2inpower,group2outpower,group2inorder,group2outorder,"
			+ "group3xianliu,group3inpower,group3outpower,group3inorder,group3outorder,"
			+ "group4xianliu,group4inpower,group4outpower,group4inorder,group4outorder,"
			+ "group5xianliu,group5inpower,group5outpower,group5inorder,group5outorder,"
			+ "group6xianliu,group6inpower,group6outpower,group6inorder,group6outorder,inoutmodel) values "
			+ "(#{cooperate_ip},#{cooperate_name},"
			+ "#{group1xianliu},#{group1inpower},#{group1outpower},#{group1inorder},#{group1outorder},"
			+ "#{group2xianliu},#{group2inpower},#{group2outpower},#{group2inorder},#{group2outorder},"
			+ "#{group3xianliu},#{group3inpower},#{group3outpower},#{group3inorder},#{group3outorder},"
			+ "#{group4xianliu},#{group4inpower},#{group4outpower},#{group4inorder},#{group4outorder},"
			+ "#{group5xianliu},#{group5inpower},#{group5outpower},#{group5inorder},#{group5outorder},"
			+ "#{group6xianliu},#{group6inpower},#{group6outpower},#{group6inorder},#{group6outorder},"
			+ "#{inoutmodel}) ")
	int addRemoteState(RemoteState remoteState);

	int updateRemoteState(RemoteState remoteState);
}
