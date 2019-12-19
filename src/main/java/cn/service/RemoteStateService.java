package cn.service;

import org.apache.ibatis.annotations.Param;

import cn.pojo.RemoteState;

public interface RemoteStateService {
	RemoteState checkRemoteState(@Param("cooperate_ip") String cooperate_ip);

	int addRemoteState(RemoteState remoteState);

	int updateRemoteState(RemoteState remoteState);
}
