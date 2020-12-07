package com.kharitonov.jpa.dao;

import com.kharitonov.jpa.entity.City;
import com.kharitonov.jpa.entity.Country;

import java.util.List;

public interface CountryDao extends BaseDao<Country, String> {
    List<City> findCities(String code);
}
