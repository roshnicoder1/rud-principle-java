package com.ibm;

import java.util.Scanner;

import com.ibm.bo.DeptBO;
import com.ibm.exception.DeptException;
import com.ibm.model.Dept;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, Exception {
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter Dept Number");
	int dno=Integer.parseInt(sc.nextLine());
	System.out.println("Enter Dept Name");
	String dname=sc.next();
	System.out.println("Enter Location");
	String loc=sc.next();

	Dept d = new Dept();
	d.setDeptno(dno);
	d.setDname(dname);
	d.setLoc(loc);
	sc.close();
	DeptBO db = new DeptBO();
	
	if(db.registerUser(d)){
		System.out.println("Record Inserted Successfully");	 
		}
	else{
		try {
		  throw new DeptException("Invalid Department");
		} catch (DeptException e) {
			System.out.println(e.getMessage());
		}
	
	}
	}	
}
