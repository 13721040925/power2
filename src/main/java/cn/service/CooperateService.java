package cn.service;

import java.util.List;

import cn.pojo.Cooperate;

public interface CooperateService {

	// 根据机器id数 查找机器总数
		int totalCount(int id);

		//模糊分页显示所有日志  根据时间段查询 根据操作类型查询
		List<Cooperate> getAllPageJiqi(Integer rowNum,int pagecount,String cooperate_name,String state);
		
		//获得去重后的控制器的id集合
		List<Integer> getListNewId(); 
		
		//通过id集合获取控制器信息
		Cooperate getListById(Integer id);
		
		//通过ip来查询控制器对象
		Cooperate getCooperateByIp(String ip); 
		
		//根据机器名称 查总数
		List<Cooperate> getListLogByCooperate_name(String cooperate_name); 
		
		//根据机器名称 查总数 用于分页  去除重复 
		List<Cooperate> getListLogByCooperate_names(String cooperate_name,String state); 
		
	Integer addCooperate(Cooperate cooperate);

	Integer getCooperateCount();

	List<Cooperate> getCooperateByName(Cooperate cooperate);

}
