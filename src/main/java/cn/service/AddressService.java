package cn.service;

import cn.pojo.Address;

public interface AddressService {
	Address getAddressByIp(String ip);

	int addAddress(Address address);

	int updateAddress(Address address);
}
