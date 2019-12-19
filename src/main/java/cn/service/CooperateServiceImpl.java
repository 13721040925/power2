package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mapper.CooperateMapper;
import cn.pojo.Cooperate;

@Service("cooperateService")
public class CooperateServiceImpl implements CooperateService {

	@Resource
	private CooperateMapper mapper;
	 
	@Override
	public int totalCount(int id) { 
		return mapper.totalCount(id);
	}

	@Override
	public List<Cooperate> getAllPageJiqi(Integer rowNum, int pagecount, String cooperate_name,String state) {
		return mapper.getAllPageJiqi(rowNum, pagecount, cooperate_name,state);
	}

	@Override
	public List<Cooperate> getListLogByCooperate_name(String cooperate_name) {
		return mapper.getListLogByCooperate_name(cooperate_name);
	}

	@Override
	public List<Cooperate> getListLogByCooperate_names(String cooperate_name,String state) {
		return mapper.getListLogByCooperate_names(cooperate_name,state);
	}

	@Override
	public List<Integer> getListNewId() {  
		return mapper.getListNewId();
	}

	@Override
	public Cooperate getListById(Integer id) { 
		return mapper.getListById(id);
	}

	@Override
	public Cooperate getCooperateByIp(String ip) {
		return mapper.getCooperateByIp(ip); 
	}

	@Override
	public Integer addCooperate(Cooperate cooperate) {
		// TODO Auto-generated method stub
		return mapper.addCooperate(cooperate);
	}

	@Override
	public Integer getCooperateCount() {
		// TODO Auto-generated method stub
		return mapper.getCooperateCount();
	}

	@Override
	public List<Cooperate> getCooperateByName(Cooperate cooperate) {
		// TODO Auto-generated method stub
		return mapper.getCooperateByName(cooperate);
	}

	
}
