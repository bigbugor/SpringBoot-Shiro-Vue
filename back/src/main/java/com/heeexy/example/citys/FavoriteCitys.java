package com.heeexy.example.citys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.heeexy.example.util.HttpClientUtil;

public class FavoriteCitys {

	
	private static final Logger logger = Logger.getLogger(FavoriteCitys.class);

	public static Map<String, String> favoriteCityMap = new HashMap<>();

	public static Map<String, String> favoriteCityMap2 = new HashMap<>();
	

	public static List<HashMap<String,Object>> listRes = new ArrayList<>();

	/**
	 * 热门城市 strings[0] 城市名 strings[1]  城市名代码
	 * 
	 */
	public static void init() {
		String result = HttpClientUtil
				.sendGet("https://kyfw.12306.cn/otn/resources/js/framework/favorite_name.js");

		int l1 = result.indexOf("'");
		int l2 = result.length();
		String city = result.substring(l1 + 1, l2);
		String[] c = city.split("@");
		// 导入二维数组
		int l = c.length - 1;
		String[][] str = new String[l][2];
		for (int i = 1; i < c.length; i++) {
			
			HashMap<String,Object> params = new HashMap<>();
			//[bjd, 北京东, BOP, beijingdong, bjd, 1]
			String[] cc = c[i].split("[|]");
			str[i - 1][0] = cc[1];
			str[i - 1][1] = cc[2];
			
			params.put("jianpin", cc[0]);
			params.put("name", cc[1]);
			params.put("code", cc[2]);
			listRes.add(params);
		}
		for (String[] strings : str) {
			favoriteCityMap.put(strings[0], strings[1]);
			favoriteCityMap2.put(strings[1], strings[0]);
		}
		logger.info("初始化车站信息完成");
	}

	public static void main(String[] args) {
		FavoriteCitys.init();
		for(String key :favoriteCityMap2.keySet()) {
			System.out.println(key+"=="+favoriteCityMap2.get(key));
			
		}
	}

	public static Map<String, String> getFavoriteCityMap() {
		return favoriteCityMap;
	}

	public static void setFavoriteCityMap(Map<String, String> favoriteCityMap) {
		FavoriteCitys.favoriteCityMap = favoriteCityMap;
	}

	public static Map<String, String> getFavoriteCityMap2() {
		return favoriteCityMap2;
	}

	public static void setFavoriteCityMap2(Map<String, String> favoriteCityMap2) {
		FavoriteCitys.favoriteCityMap2 = favoriteCityMap2;
	}

	
	
	
}
