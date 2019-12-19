package cn.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.pojo.Address;

public interface AddressMapper {
	@Select(" select * from address where ip=#{ip} ")
	Address getAddressByIp(@Param("ip") String ip);

	@Insert(" insert into address (ip,cooperate_name,states) values (#{ip},#{cooperate_name},#{states}) ")
	int addAddress(Address address);

	@Update(" update address set states=#{states} where ip=#{ip} ")
	int updateAddress(Address address);
}
