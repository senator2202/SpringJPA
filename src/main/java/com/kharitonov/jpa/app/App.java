package com.kharitonov.jpa.app;

import com.kharitonov.jpa.dao.CityDao;
import com.kharitonov.jpa.dao.CountryDao;
import com.kharitonov.jpa.entity.City;
import com.kharitonov.jpa.entity.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        deleteCity(context);
        context.close();
    }

    static void printCities(ClassPathXmlApplicationContext context) {
        CityDao dao = context.getBean(CityDao.class);
        City city = dao.findById(1255);
        System.out.println(city);
        /*List<City> cities = dao.findAll();
        cities.forEach(System.out::println);*/
    }

    static void printCountries(ClassPathXmlApplicationContext context) {
        CountryDao dao = context.getBean(CountryDao.class);
        Country country = dao.findById("USA");
        System.out.println(country);
        List<Country> countries = dao.findAll();
        countries.forEach(System.out::println);
        context.close();
    }

    static void insertCity(ClassPathXmlApplicationContext context) {
        City city = new City();
        city.setName("Novogrudok");
        city.setCountry(new Country("BLR"));
        city.setDistrict("Grodno");
        city.setPopulation(122000);
        CityDao dao = context.getBean(CityDao.class);
        dao.insert(city);
        System.out.println(city.getId());
    }

    static void updateCity(ClassPathXmlApplicationContext context) {
        CityDao dao = context.getBean(CityDao.class);
        City city = dao.findById(4088);
        city.setName("Staryi Gorod");
        dao.update(city);
        city = dao.findById(4088);
        System.out.println(city);
    }

    static void deleteCity(ClassPathXmlApplicationContext context) {
        CityDao dao = context.getBean(CityDao.class);
        dao.delete(4089);
        City city = dao.findById(4089);
        System.out.println(city);
    }

    static void printCountryCities(ClassPathXmlApplicationContext context) {
        CountryDao dao = context.getBean(CountryDao.class);
        dao.findCities("RUS").forEach(System.out::println);
    }
}
