package com.heeexy.example.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.heeexy.example.citys.FavoriteCitys;
import com.heeexy.example.service.IStationsService;
import com.heeexy.example.service.UserService;
import com.heeexy.example.stations.Stations;

@Component
public class StationListener  implements ApplicationListener<ApplicationReadyEvent> {
	
	
	@Autowired
	IStationsService  stationsService;
	
	

	//初始化 城市车站
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		//加载普通城市 普通车站
		/*Stations.init();
		List<HashMap<String,Object>>  listSta =Stations.listRes;
		userService.getAllRoles();
		for(HashMap<String,Object> map:listSta) {

			stationsService.insertStations(map);
		}*/
		//加载热门城市 热门车站
		
		/*FavoriteCitys.init();
		List<HashMap<String,Object>>  listSta =FavoriteCitys.listRes;
		for(HashMap<String,Object> map:listSta) {

			stationsService.updateStations(map);
		}
		*/
		
		
	}

}
