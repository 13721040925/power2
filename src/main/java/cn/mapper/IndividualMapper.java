package cn.mapper;

import org.apache.ibatis.annotations.Insert;

import cn.pojo.Individual;

public interface IndividualMapper {
	@Insert(" insert into individual (group_id,group_name,indi_num,indi_v,indi_tem) values (#{group_id},#{group_name},#{indi_num},#{indi_v},#{indi_tem}) ")
	Integer addIndividual(Individual individual);
}
