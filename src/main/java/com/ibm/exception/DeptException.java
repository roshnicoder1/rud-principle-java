package com.ibm.exception;

public class DeptException extends Exception {
	
	public DeptException( String message)
	{
		super(message);
	}

	public DeptException(Throwable t)
	{
		super(t);
	}
}