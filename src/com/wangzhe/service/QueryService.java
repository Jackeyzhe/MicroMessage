package com.wangzhe.service;

import java.util.List;

import com.wangzhe.bean.Message;
import com.wangzhe.dao.MessageDao;
import com.wangzhe.util.Iconst;

public class QueryService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao dao = new MessageDao();
		return dao.queryMessageList(command, description);
	}
	
	/**
	 * 通过指令查询自动回复内容
	 * @param command
	 * @return
	 */
	public String queryByCommand(String command){
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if(Iconst.HELP_COMMAND.equals(command)){
			 messageList = messageDao.queryMessageList(null, null);
			 StringBuilder result = new StringBuilder();
			 for(int i=0;i<messageList.size();i++){
				 if(0!=i){
					 result.append("<br/>");
				 }
				 result.append("回复["+messageList.get(i).getCommand()+"]可以查看"+messageList.get(i).getDescription());
			 }
			 return result.toString();
			
		}
		messageList = messageDao.queryMessageList(command, null);
		if(messageList.size()>0){
			return messageList.get(0).getContent();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
	}

}
