package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.pojo.Cooperate;

public interface CooperateMapper {

	// 根据机器id数 查找机器总数
	@Select("select count(id) from cooperate")
			int totalCount(@Param("id") int id);

			//模糊分页显示所有日志  根据时间段查询 根据操作类型查询 
			List<Cooperate> getAllPageJiqi(@Param("rowNum") Integer rowNum,@Param("pagecount") int pagecount,
					@Param("cooperate_name") String cooperate_name,@Param("state") String state); 
			
			//去重后的分页
			
			//获得去重后的控制器的id集合
			@Select("SELECT max(id) id FROM cooperate GROUP BY cooperate_name HAVING count(*) >= 1;")
			List<Integer> getListNewId();
			
			//通过id集合获取控制器信息
			@Select("select * from cooperate where id=#{id}")
			Cooperate getListById(@Param("id") Integer id);
			
			//根据机器名称 查总数
			List<Cooperate> getListLogByCooperate_name(@Param("cooperate_name") String cooperate_name);  
			
			//根据机器名称 查总数 用于分页  去除重复 
			List<Cooperate> getListLogByCooperate_names(@Param("cooperate_name") String cooperate_name,
					@Param("state") String state); 
			
			//通过ip来查询控制器对象
			@Select("select * from cooperate where id in(select max(id) from cooperate GROUP BY cooperate_name) and ip=#{ip}")
	Cooperate getCooperateByIp(@Param("ip") String ip);

	@Insert(" insert into cooperate(ip,cooperate_name,fdtime,totaltime,onlioncount,state,logtime,version) values (#{ip},#{cooperate_name},#{fdtime},#{totaltime},#{totaltime},#{state},#{logtime},#{version}) ")
	Integer addCooperate(Cooperate cooperate);

	@Select(" select count(id) from  cooperate ")
	Integer getCooperateCount();

	@Select(" select * from cooperate where cooperate_name = #{cooperate_name} ")
	List<Cooperate> getCooperateByName(Cooperate cooperate);

}
