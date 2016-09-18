package in.xgen.service.user;

import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;
import in.xgen.web.profile.user.domain.State;

import java.util.List;

public interface AddressService {

	public List<Country> getAllCountries();
	public List<State> getAllState();
	public List<City> getAllCity();
	public Country getCountryById(int id);
	public int saveCountry(Country country);

}
