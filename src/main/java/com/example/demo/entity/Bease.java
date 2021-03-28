package com.example.demo.entity;

public class Bease {
	
	private String sql;

	public Bease() {
		super();
	}

	public Bease(String sql) {
		super();
		this.sql = sql;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "Bease [sql=" + sql + "]";
	}
	
}
