package cn.service;

import java.util.List;

import cn.pojo.Group;

public interface GroupService {

	//根据cooperate_name来查找机器下的电池信息
		List<Group> getListDcByJqName(String cooperate_name);
		
		//根据id获取 电池对象
		Group selDianciGroupById(Integer id);
		
		//获取最新电池组的id集合
		List<Integer> getNewIdList(String cooperate_name);
		
		//根据控制器name获取 去重后的 电池组list信息
		List<Group> getListGroup(String cooperate_name);
 		
		//模糊分页显示所有日志  根据时间段查询 根据操作类型查询
		List<Group> getAllPageJiqis(Integer rowNum,int pagecount,String cooperate_name);

	Integer addGroup(Group group);

	List<Group> getGroupByName(Group group);
}
