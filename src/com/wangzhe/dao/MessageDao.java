package com.wangzhe.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wangzhe.bean.Message;
import com.wangzhe.db.DbAccess;

/**
 * 和message表相关的数据库
 * @author Administrator
 *
 */
public class MessageDao {
	/**
	 * 新增一条数据
	 * @param message
	 */
	public void addOne(Message message){
		DbAccess dbAccess=new DbAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			sqlSession.insert("Message.add", message);
			sqlSession.commit();
			System.out.println(message.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	public boolean deleteBatch(List<Integer> id){
		DbAccess dbAccess=new DbAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteBatch",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return true;
	}
	
	/**
	 * 单条删除
	 * @param id
	 */
	public boolean deleteOne(int id){
		DbAccess dbAccess=new DbAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return true;
	}
	/**
	 * 查询
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command,String description){
		DbAccess dbAccess=new DbAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过sqlSession执行SQL语句
			messageList=sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return messageList;
	}
//	public List<Message> queryMessageList(String command,String description){
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","123456");
//			StringBuilder sql =new StringBuilder( "select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paramList = new ArrayList<String>();
//			if(command != null && !"".equals(command.trim())){
//				sql.append(" and COMMAND = ?");
//				paramList.add(command);
//			}
//			if(description != null && !"".equals(description.trim())){
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for(int i =0 ;i < paramList.size(); i++){
//				statement.setString(i+1,paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()){
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return messageList;
//	}

}
