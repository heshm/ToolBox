package com.erp.common.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.ITXInfoDAO;
import com.erp.common.IService.ITXInfoService;
import com.erp.common.dataSet.TXInfo;

@Transactional
public class TXInfoService implements ITXInfoService {

	private ITXInfoDAO txInfoDAO;
	public ITXInfoDAO getTxInfoDAO() {
		return txInfoDAO;
	}
	public void setTxInfoDAO(ITXInfoDAO txInfoDAO) {
		this.txInfoDAO = txInfoDAO;
	}
	@Override
	public List<TXInfo> getTXInfoList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return txInfoDAO.getTXInfoList(map);
	}
	@Override
	public TXInfo getOneTXInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return txInfoDAO.getOneTXInfo(map);
	}
	@Override
	public int updateTXInfo(TXInfo txInfo) {
		// TODO Auto-generated method stub
		return txInfoDAO.updateTXInfo(txInfo);
	}
	@Override
	public int insertTXInfo(TXInfo txInfo) {
		// TODO Auto-generated method stub
		return txInfoDAO.insertTXInfo(txInfo);
	}

}
