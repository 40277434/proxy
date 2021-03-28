package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.IDemoService;
import com.example.demo.entity.Result;
import com.example.demo.mapper.DemoMapper;

@Service
public class DemoService implements IDemoService {

	@Autowired
	private DemoMapper demoMapper;

	@Override
	public int insertJOSN(String jsonString) {
		return demoMapper.insertJOSN(jsonString);
	}

	@Override
	public List<Result> selectList() {
		return demoMapper.selectList();
	}
}
