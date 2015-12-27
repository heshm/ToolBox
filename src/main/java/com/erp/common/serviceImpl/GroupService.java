package com.erp.common.serviceImpl;

import java.util.List;
import java.util.Map;

import com.erp.common.IDAO.IGroupDAO;
import com.erp.common.IService.IGroupService;
import com.erp.common.dataSet.GroupDS;

public class GroupService implements IGroupService {
	
	private IGroupDAO groupDAO;

	public IGroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(IGroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	@Override
	public List<GroupDS> getGroupList() {
		// TODO Auto-generated method stub
		return groupDAO.getGroupList();
	}

}
