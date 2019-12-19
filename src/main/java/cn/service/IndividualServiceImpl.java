package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mapper.IndividualMapper;
import cn.pojo.Individual;

@Service("individualService")
public class IndividualServiceImpl implements IndividualService {
	@Resource
	private IndividualMapper mapper;

	@Override
	public Integer addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return mapper.addIndividual(individual);
	}

}
