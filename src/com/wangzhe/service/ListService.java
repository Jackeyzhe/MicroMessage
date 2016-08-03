package com.wangzhe.service;

import java.util.List;

import com.wangzhe.bean.Message;
import com.wangzhe.dao.MessageDao;

public class ListService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao dao = new MessageDao();
		return dao.queryMessageList(command, description);
	}

}
