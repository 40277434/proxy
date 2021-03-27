package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DemoController {


	@GetMapping(value = "/api")
	public String aip(@RequestParam String x, @RequestParam String y, @RequestParam String method){
		JSONObject jsonObject = new JSONObject();
		if (null == method || "".equals(method)){
			jsonObject.put("error", true);
			jsonObject.put("reason", "method is null");
			return jsonObject.toJSONString();
		}
		if ("add".equals(method)){
			return add(x,y);
		}else if ("minus".equals(method)){
			return minus(x,y);
		}else if ("multiply".equals(method)){
			return multiply(x,y);
		}else if ("divi".equals(method)){
			return divi(x, y);
		}else if ("power".equals(method)){
			return power(x,y);
		}else if ("modulo".equals(method)){
			return modulo(x,y);
		}else {
			jsonObject.put("error", true);
			jsonObject.put("reason", "method[add,minus,product,divi,power,modulo]");
			return jsonObject.toJSONString();
		}
	}
	

	@GetMapping(value = "/add")
	public String add(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
        String url="add1.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);
	}
	
	
	@GetMapping(value = "/minus")
	public String minus(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
        String url="minus1.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);
	}
	
	@GetMapping(value = "/multiply")
	public String multiply(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

        String url="multiply1.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);
	}

	@GetMapping(value = "/divi")
	public String divi(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

        String url="division1.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);	
	
	}

	@GetMapping(value = "/power")
	public String power(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

        String url="power1.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);	
	}

	@GetMapping(value = "/modulo")
	public String modulo(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
 
        String url="modulo.40277434.qpc.hal.davecutting.uk";
		return doGet(url+"/?x="+x+"&y="+y);	
	}
	
	@GetMapping(value = "/list")
	public JSONObject list() {

		JSONObject jsonObject = JSON.parseObject(getList(url+"/list"));
        return jsonObject;

	}

	private String doGet(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpurl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			connection.disconnect();
		}

		return result;
	}

	private String getList(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpurl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = br.readLine();
				return temp;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			connection.disconnect();
		}

		return result;
	}
}
