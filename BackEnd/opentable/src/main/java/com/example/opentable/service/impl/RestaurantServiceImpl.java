package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.service.RestaurantService;
import com.example.opentable.transport.dto.RestaurantDto;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Override
	public List<RestaurantDto> getRestaurants() throws Exception {
		return restaurantDao.getRestaurants();
	}

	@Override
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception {
		return restaurantDao.createRestaurant(restaurantDto);
	}

	@Override
	public List<RestaurantDto> getRestaurantById(int restaurantId) throws Exception {
		return restaurantDao.getRestaurantById(restaurantId);
	}

	@Override
	public int deleteRestaurant(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}