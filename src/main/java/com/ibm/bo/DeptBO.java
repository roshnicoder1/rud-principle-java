package com.ibm.bo;

import com.ibm.dao.DeptDAO;
import com.ibm.exception.DeptException;
import com.ibm.model.Dept;

public class DeptBO {
	public boolean registerUser(Dept d) throws DeptException, ClassNotFoundException
			{
		boolean flag=false;
				if((d.getDeptno()>99) || (d.getDeptno()<0)){
					flag=false;
					}else	{
					DeptDAO dDao = new DeptDAO();
					flag = dDao.insertDept(d);
				}
			return flag;
		}
}