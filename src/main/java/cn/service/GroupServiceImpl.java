package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mapper.GroupMapper;
import cn.pojo.Group;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Resource
	private GroupMapper mapper;
	
	@Override
	public List<Group> getListDcByJqName(String cooperate_name) {
		return mapper.getListDcByJqName(cooperate_name);
	}

	@Override 
	public List<Group> getAllPageJiqis(Integer rowNum, int pagecount, String cooperate_name) {
		return mapper.getAllPageJiqis(rowNum, pagecount, cooperate_name);
	}

	@Override
	public List<Integer> getNewIdList(String cooperate_name) {
		return mapper.getNewIdList(cooperate_name);
	}

	@Override
	public Group selDianciGroupById(Integer id) {
		return mapper.selDianciGroupById(id);
	}

	@Override
	public List<Group> getListGroup(String cooperate_name) {
		return mapper.getListGroup(cooperate_name);
	}

	@Override
	public Integer addGroup(Group group) {
		// TODO Auto-generated method stub
		return mapper.addGroup(group);
	}

	@Override
	public List<Group> getGroupByName(Group group) {
		// TODO Auto-generated method stub
		return mapper.getGroupByName(group);
	}

}
