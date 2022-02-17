package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.RestaurantDto;

@Repository
public class RestaurantDaoImpl extends AbstractParentDao<Restaurant> implements RestaurantDao{

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RestaurantDto> getRestaurants() throws Exception {
		List<Restaurant> restaurants = null;
		try {
			Query query = getEntityManager().createQuery("select r from Restaurant r");
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}

	private List<RestaurantDto> convertRestaurantsIntoDto(List<Restaurant> restaurants) {
		List<RestaurantDto> restaurantDtos = new ArrayList<>();
		try {
			if(restaurants != null && restaurants.isEmpty()==false) {
				for(Restaurant restaurant:restaurants) {
					RestaurantDto restaurantDto = new RestaurantDto();
					restaurantDto.setRestaurantId(restaurant.getRestaurantId());
					restaurantDto.setRestaurantName(restaurant.getRestaurantName());
					restaurantDto.setAddress(restaurant.getAddress());
					restaurantDto.setContact(restaurant.getContact());
					restaurantDto.setDescription(restaurant.getDescription());
					restaurantDto.setGstIn(restaurant.getGstIn());
					restaurantDto.setNonVeg(restaurant.isNonVeg());
					restaurantDtos.add(restaurantDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		
		return restaurantDtos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception {
		
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantName(restaurantDto.getRestaurantName());
			restaurant.setAddress(restaurantDto.getAddress());
			restaurant.setGstIn(restaurantDto.getGstIn());
			restaurant.setContact(restaurantDto.getContact());
			restaurant.setDescription(restaurantDto.getDescription());
			restaurant.setNonVeg(restaurantDto.isNonVeg());
			Query query = getEntityManager().createQuery("Select u from User u where u.userId=1");
			User user = (User) query.getSingleResult();
			restaurant.setOwner(user);
			getEntityManager().persist(restaurant);
			return restaurant.getRestaurantId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RestaurantDto> getRestaurantById(int restaurantId) throws Exception {
		List<Restaurant> restaurants = null;
		try {
			Query query = getEntityManager().createQuery("select r from Restaurant r where r.restaurantId = :id").setParameter("id",restaurantId);
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int deleteRestaurant(int restaurantId) throws Exception {
		return 0;
	}

}
