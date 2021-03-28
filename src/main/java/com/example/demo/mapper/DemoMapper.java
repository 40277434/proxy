package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Result;

@Mapper
public interface DemoMapper {

	public int insertJOSN(String jsonString);

	public List<Result> selectList();

}
