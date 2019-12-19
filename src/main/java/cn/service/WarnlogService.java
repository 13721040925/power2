package cn.service;

import java.util.List;

import cn.pojo.Other;
import cn.pojo.Pro;
import cn.pojo.Warn;
import cn.pojo.Warnlog;

public interface WarnlogService {

	//查看最新报错的控制器id
	List<Warnlog> getNewWarnlogId();
	
	//通过id查找Warnlog对象
	Warnlog getWarnlogById(Integer id);
	
	//去重后 通过ip来查电池组的最新报错信息
	Warnlog selWarnlogByIp(String ip);
	
	//保护故障告警次数
	int getProCount();
	
	//告警故障次数
	int getWarnCount();
	
	//其他故障次数
	int getOtherWarnCount();
	
	//不报警出现次数
	int getNotWarnCount();
	
	//报警表总记录
	int getAllWarnCount();
	
	//获取报警表某天的总数
	int getCountByWarntime(String warnTime);
	
	//获取报警表某天的正常数
	int getNotWarnCountByWarnTime(String warnTime);
	
	/**
	 * 过滤出异常告警的信息
	 * @return
	 */
	List<Warnlog> getWarnlogList();
	List<Pro> getProWarnList();
	List<Warn> getWarnList();
	List<Other> getOtherWarnList(); 
	
	//报警记录分页显示
	List<Warnlog> getPageAllWarnlog(Integer rowNum,int pagecount,String ip);
	
	//报警记录分页显示的条数
	int getPageAllWarnlogCount(String ip);
	
	//三大故障报警记录
	//保护故障
	Pro selProByIpAndTime(String ip,String warntime);
	//告警故障
	Warn selWarnByIpAndTime(String ip,String warntime);
	//其他故障
	Other selOtherByIpAndTime(String ip,String warntime);
	//保护与告警
	//保护与其他
	//告警与其他

	Integer addWarnLog(Warnlog warnlog);
}
