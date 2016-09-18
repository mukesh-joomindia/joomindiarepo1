package in.xgen.service.user;

import in.xgen.web.profile.user.dao.AddressDAO;
import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;
import in.xgen.web.profile.user.domain.State;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {


	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		logger.info("Getting all countries information");
		List<Country> countries=null;
		countries = addressDAO.getAllCountry();
		logger.debug("No of Countries:"+countries.size());
		return countries;
		
	}

	
	public List<State> getAllState() {
		// TODO Auto-generated method stub
		logger.info("Getting all State information");
		List<State> states=null;
		states = addressDAO.getAllState();
		logger.debug("No of State:"+states.size());
		return states;
		
		
				
	}

	
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		logger.info("Getting all City information");
		List<City> cities=null;
		cities = addressDAO.getAllCity();
		logger.debug("No of City:"+cities.size());
		return cities;
		
		
	}

	
	
	
	AddressDAO addressDAO = null;
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	
	
	public Country getCountryById(int id){
		List<Country> countries = null;
		logger.info("In CountryById");
		Country country = null;
		countries = addressDAO.getCountryById(id);
		return (countries.size()==0)?null:countries.get(0);
	}




	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);
	
	
	
	//@Override
	public int saveCountry(Country country) {
		// TODO Auto-generated method stub
		
		int id = 0;
		
		if(country==null||country.getName().equalsIgnoreCase(" ")||country.getName().equals(null)){
			logger.info("Country is empty");
			return id;
		}
		 else
		 {
			 
			 id = addressDAO.saveCountry(country);
			 logger.info("Saved Country serial id:"+id+":Country name:"+country.getName());
		 }
		   return id;	
				
	}
	
	
	

	
	
}
