package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Result;

public interface IDemoService {

	public int insertJOSN(String jsonString);

	public List<Result> selectList();

}
