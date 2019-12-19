package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.pojo.Group;

public interface GroupMapper {

	//根据name来查找机器下的电池信息
	@Select("select * from `group` where cooperate_name=#{cooperate_name}")
			List<Group> getListDcByJqName(@Param("cooperate_name") String cooperate_name);
			
			//根据id获取 电池对象
	@Select("select * from `group` where id=#{id}")
			Group selDianciGroupById(@Param("id") Integer id);  
			
			//模糊分页显示所有日志  根据时间段查询 根据操作类型查询
			List<Group> getAllPageJiqis(@Param("rowNum") Integer rowNum, @Param("pagecount") int pagecount, @Param("cooperate_name") String cooperate_name);

			//获取最新电池组的id集合
			@Select("SELECT max(id) id,cooperate_name FROM  `group` GROUP BY  cooperate_name,group_name HAVING count(*) >=1 and cooperate_name=#{cooperate_name}") 
			List<Integer> getNewIdList(@Param("cooperate_name") String cooperate_name); 
			
			//根据控制器name获取 去重后的 电池组list信息
			@Select("select * from `group` where  id in (select max(id) from `group` GROUP BY group_name) and "
					+ "cooperate_name=#{cooperate_name};")
			List<Group> getListGroup(@Param("cooperate_name") String cooperate_name); 

	@Insert(" insert into `group` (cooperate_id,cooperate_name,group_num,group_name,batter_type,group_v,group_a,group_ah,indi_m,indi_n,dod,middle_v,surplus_time,group_total_time) values (#{cooperate_id},#{cooperate_name},#{group_num},#{group_name},#{batter_type},#{group_v},#{group_a},#{group_ah},#{indi_m},#{indi_n},#{dod},#{middle_v},#{surplus_time},#{group_total_time}) ")
	Integer addGroup(Group group);

	@Select(" select * from `group` where group_name = #{group_name} ")
	List<Group> getGroupByName(Group group);
}
