package com.wangzhe.service;

import java.util.ArrayList;
import java.util.List;

import com.wangzhe.bean.Message;
import com.wangzhe.dao.MessageDao;

/**
 * 维护相关业务的服务
 * @author Administrator
 *
 */
public class MaintainService {
	/**
	 * 新增
	 * @param message
	 */
	public void addOne(Message message){
		MessageDao messageDao = new MessageDao();
		
		messageDao.addOne(message);
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public boolean deleteBatch(String[] ids){
		MessageDao dao =new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		return dao.deleteBatch(idList);
	}
	
	/**
	 * 单条删除
	 * @param id
	 */
	public boolean deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){
			MessageDao dao =new MessageDao();
			return dao.deleteOne(Integer.valueOf(id));
		}else{
			return false;
		}
	}

}
