package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.pojo.Other;
import cn.pojo.Pro;
import cn.pojo.Warn;
import cn.pojo.Warnlog;

public interface WarnlogMapper {

	//查看最新报错的控制器id
	@Select("SELECT max(id) id,ip FROM  warnlog GROUP BY  ip HAVING count(*) >= 1")
		List<Warnlog> getNewWarnlogId();
	
	//通过id查找Warnlog对象
	@Select("select * from warnlog where id=#{id}")
		Warnlog getWarnlogById(@Param("id") Integer id);
	
	//去重后 通过ip来查电池组的最新报错信息
	@Select("select * from (select * from warnlog where id in(select max(id) from warnlog GROUP BY ip)) t where ip=#{ip}")
		Warnlog selWarnlogByIp(@Param("ip") String ip);  
	
	//保护故障告警次数
	@Select("select count(id) from warnlog where prostatus=1")
		int getProCount();
		
	@Select("select count(id) from warnlog where warnstatus=1")
		//告警故障次数
		int getWarnCount();
		
	@Select("select count(id) from warnlog where otherstatus=1")
		//其他故障次数
		int getOtherWarnCount();
		
	@Select("select count(id) from warnlog where prostatus=0 and otherstatus=0 and warnstatus=0")
		//不报警出现次数
		int getNotWarnCount();
		
	@Select("select count(id) from warnlog")
		//报警表总记录
		int getAllWarnCount();  
	
	@Select("select count(id) from warnlog where warntime like '%${warnTime}%'")
	//获取报警表某天的总数
		int getCountByWarntime(@Param("warnTime") String warnTime);
		
	@Select("select count(id) from warnlog where prostatus=0 and otherstatus=0 and warnstatus=0 and warntime like '%${warnTime}%';")
		//获取报警表某天的正常数
		int getNotWarnCountByWarnTime(@Param("warnTime") String warnTime);
	
	/**
	 * 过滤出异常告警的信息
	 * @return
	 */
	@Select("select * from warnlog where prostatus not in (0) or warnstatus not in (0) or otherstatus not in (0) ")
	List<Warnlog> getWarnlogList();
	
	@Select("select * from pro where lipower not in (0) or templower not in (0) or temphigher not in (0) or indivhigher not in (0) or indivlower not in(0) or powervhigher not in (0) or powervlower not in (0) ")
	List<Pro> getProWarnList();
	
	@Select("select * from warn where powertemplower not in (0) or powertemphigher not in (0) or indivhigher not in (0) or indivlower not in (0) or groupvhigher not in (0) or groupvlower not in (0) or powerahigher not in (0) or bmu not in (0)")
	List<Warn> getWarnList();
	
	@Select("select * from other where power not in (0) or ahlower not in (0) or outpower not in (0) or inpower not in (0) or middlev not in (0);")
	List<Other> getOtherWarnList(); 
	
	//报警记录分页显示
	List<Warnlog> getPageAllWarnlog(@Param("rowNum") Integer rowNum,@Param("pagecount") int pagecount,@Param("ip") String ip);

	//报警记录分页显示的条数
	int getPageAllWarnlogCount(@Param("ip") String ip);
	
	//保护故障
		@Select("select * from pro where ip=#{ip} and warntime=#{warntime}")
		Pro selProByIpAndTime(@Param("ip") String ip,@Param("warntime") String warntime);
		//告警故障
		@Select("select * from warn where ip=#{ip} and warntime=#{warntime}")
		Warn selWarnByIpAndTime(@Param("ip") String ip,@Param("warntime") String warntime);
		//其他故障
		@Select("select * from other where ip=#{ip} and warntime=#{warntime}")
		Other selOtherByIpAndTime(@Param("ip") String ip,@Param("warntime") String warntime); 

	@Insert(" insert into warnlog (warntime,ip,address_cooperate_id,cooperate_name,group_id,type,child_warn_id) values (#{warntime},#{ip},#{address_cooperate_id},#{cooperate_name},#{group_id},#{type},#{child_warn_id}) ")
	Integer addWarnLog(Warnlog warnlog);
}
