package in.xgen.web.profile.user.dao;

import java.util.List;

import in.xgen.web.profile.user.domain.Address;
import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;
import in.xgen.web.profile.user.domain.State;
import in.xgen.web.profile.user.domain.User;

public interface AddressDAO {

	/**
	 * 
	 * 
	 * User opration
	 * 
	 * */
	public void saveAddress(Address addr);
	public Integer updateAddress(Address addr);
	public Integer deleteAddress(Address addr);
	public User getUserById(int userId);
	
	/**
	 * 
	 * 
	 * country operation
	 * 
	 * */
	public int saveCountry(Country country);
	public void deleteCountry(Country country);
	public void updateCountry(Country country);
	public List<Country> getAllCountry();
	public List<Country> getCountryById(Integer id);
	public List<Country> getCountryByName(String name);
	public Country getCountryByStateId(int stateId);
	/**
	 * 
	 * state operation
	 * 
	 * */
	
	public void saveState(State state);
	public List<Country> getStateById(Integer id);
	public List<Country> getStateByName(String name);
	public List<State> getAllState();
	public Country getStateByCountryId(int countryId);
	public int deleteState(State state);
	public int updateState(State state);
	
	/**
	 * city operation
	 */
	
	public List<City> getAllCity();
	public Integer saveCity(City city);
	public void updateCity(City city);
	public City findCityById(int id);
	public List<City> findCityByName(String name);
	public List<Object[]> findCityByCountryId(int countryId);
	
	
}
