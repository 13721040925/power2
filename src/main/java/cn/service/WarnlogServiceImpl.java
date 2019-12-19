package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mapper.WarnlogMapper;
import cn.pojo.Other;
import cn.pojo.Pro;
import cn.pojo.Warn;
import cn.pojo.Warnlog;

@Service("warnlogService")
public class WarnlogServiceImpl implements WarnlogService {

	@Resource
	private WarnlogMapper mapper;
	
	@Override
	public List<Warnlog> getNewWarnlogId() {
		return mapper.getNewWarnlogId();
	}

	@Override
	public Warnlog getWarnlogById(Integer id) {
		return mapper.getWarnlogById(id);
	}

	@Override
	public Warnlog selWarnlogByIp(String ip) {
		return mapper.selWarnlogByIp(ip);
	}

	@Override
	public int getProCount() {
		return mapper.getProCount();
	}

	@Override
	public int getWarnCount() {
		return mapper.getWarnCount();
	}

	@Override
	public int getOtherWarnCount() {
		return mapper.getOtherWarnCount();
	}

	@Override
	public int getNotWarnCount() {
		return mapper.getNotWarnCount();
	}

	@Override
	public int getAllWarnCount() {
		return mapper.getAllWarnCount();
	}

	@Override
	public int getCountByWarntime(String warnTime) {
		return mapper.getCountByWarntime(warnTime);
	}

	@Override
	public int getNotWarnCountByWarnTime(String warnTime) {
		return mapper.getNotWarnCountByWarnTime(warnTime);
	}

	@Override
	public List<Warnlog> getWarnlogList() {
		return mapper.getWarnlogList();
	}

	@Override
	public List<Pro> getProWarnList() {
		return mapper.getProWarnList();
	}

	@Override
	public List<Warn> getWarnList() {
		return mapper.getWarnList();
	}

	@Override
	public List<Other> getOtherWarnList() {
		return mapper.getOtherWarnList();
	}

	@Override
	public int getPageAllWarnlogCount(String ip) {
		return mapper.getPageAllWarnlogCount(ip);
	}

	@Override
	public List<Warnlog> getPageAllWarnlog(Integer rowNum, int pagecount, String ip) {
		return mapper.getPageAllWarnlog(rowNum, pagecount, ip);
	}

	@Override
	public Pro selProByIpAndTime(String ip, String warntime) {
		return mapper.selProByIpAndTime(ip, warntime);
	}

	@Override
	public Warn selWarnByIpAndTime(String ip, String warntime) {
		return mapper.selWarnByIpAndTime(ip, warntime);
	}

	@Override
	public Other selOtherByIpAndTime(String ip, String warntime) {
		return mapper.selOtherByIpAndTime(ip, warntime);
	}

	@Override
	public Integer addWarnLog(Warnlog warnlog) {
		// TODO Auto-generated method stub
		return mapper.addWarnLog(warnlog);
	}

}
