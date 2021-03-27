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
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemoController {

	@GetMapping(value = "/")
	public String aip(@RequestParam String x, @RequestParam String y, @RequestParam String method) {
		JSONObject jsonObject = new JSONObject();
		if (null == method || "".equals(method)) {
			jsonObject.put("error", true);
			jsonObject.put("reason", "method is null");
			return jsonObject.toJSONString();
		}
		if ("add".equals(method)) {
			return add(x, y);
		} else if ("subtract".equals(method)) {
			return subtract(x, y);
		} else if ("multiply".equals(method)) {
			return multiply(x, y);
		} else if ("division".equals(method)) {
			return division(x, y);
		} else if ("power".equals(method)) {
			return power(x, y);
		} else if ("modulo".equals(method)) {
			return modulo(x, y);
		} else {
			jsonObject.put("error", true);
			jsonObject.put("reason", "method[add,subtract,product,division,power,modulo]");
			return jsonObject.toJSONString();
		}
	}

	@GetMapping(value = "/add")
	public String add(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		String url = "http://add1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);
	}

	@GetMapping(value = "/subtract")
	public String subtract(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		String url = "http://subtract1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);
	}

	@GetMapping(value = "/multiply")
	public String multiply(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

		String url = "http://multiply1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);
	}

	@GetMapping(value = "/division")
	public String division(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

		String url = "http://division1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);

	}

	@GetMapping(value = "/power")
	public String power(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

		String url = "http://power1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);
	}

	@GetMapping(value = "/modulo")
	public String modulo(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {

		String url = "http://modulo1.40277434.qpc.hal.davecutting.uk";
		return doGet(url + "/?x=" + x + "&y=" + y);
	}

	@GetMapping(value = "/list")
	public JSONObject list() {
		String url = "";
		JSONObject jsonObject = JSON.parseObject(getList(url + "/list"));
		return jsonObject;

	}

	private String doGet(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpurl);
			System.out.println(httpurl);
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
