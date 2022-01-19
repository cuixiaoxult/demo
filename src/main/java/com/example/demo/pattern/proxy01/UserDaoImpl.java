package com.example.demo.pattern.proxy01;
/**
 * 目标对象
 * @author cui
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public int save() {
		// TODO Auto-generated method stub
		System.out.println("数据已保存！");
		return 1;
	}

}
