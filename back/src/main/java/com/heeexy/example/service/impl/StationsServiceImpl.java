package com.heeexy.example.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heeexy.example.dao.StationsDao;
import com.heeexy.example.service.IStationsService;

@Service
public class StationsServiceImpl  implements IStationsService{

	
	@Autowired
	private StationsDao stationsDao;
	
	@Override
	public void insertStations(HashMap<String,Object> mapp) {
		// TODO Auto-generated method stub
		stationsDao.insertStations(mapp);
	}

	@Override
	public void updateStations(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		stationsDao.updateStations(map);
	}

}
