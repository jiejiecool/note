package com.zhouhe.note;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.ListUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhouhe.note.App.User;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		user1.setId(1);
		user2.setId(2);
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		
		StringBuilder sb = new StringBuilder();
		//使用匿名内部类的方式处理list
		sb = new buildStringinterface() {
			
			public StringBuilder buildString(List<User> list) {
				StringBuilder sb2 = new StringBuilder();
				for (User u: list) {
					sb2.append("\'").append(u.getId()).append("\'").append(",");
				}
				return sb2;
			}
		}.buildString(users);
		log.info(sb.toString());
	}
	
	public static interface buildStringinterface {
		public StringBuilder buildString(List<User> list);
	}
	
	public static class User{
		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		
	}
}
