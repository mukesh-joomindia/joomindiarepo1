package in.xgen.web.profile.user.dao;

import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.xgen.web.profile.user.domain.Address;
import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;
import in.xgen.web.profile.user.domain.State;
import in.xgen.web.profile.user.domain.User;
import in.xgen.web.profile.user.utils.SessionUtils;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO{

	Logger logger = Logger.getLogger("AddressDAOImpl");
	private Session sess = null;
	//@Autowired
	private SessionFactory sessFactory = null;
	private String hqlQuery = null;
	private Criteria crit = null;
	private Transaction trans = null;
	 
	public void saveAddress(Address addr) {
		// TODO Auto-generated method stub
	
	try{
		sess = sessFactory.getCurrentSession();
		sess.beginTransaction().begin();
		sess.save(addr);
		sess.beginTransaction().commit();
	
		logger.info("Address is saved:"+addr);
	
	}catch(Exception e){
		logger.error(e);
		sess.beginTransaction().rollback();
	}
	finally{
		sess.close();
	}
	}
	 
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		
		sess = SessionUtils.getSession();
		
		
		return null;
	}
	 
	public Integer updateAddress(Address addr) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public Integer deleteAddress(Address addr) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public int saveCountry(Country country) {
		// TODO Auto-generated method stub
		
		int id  = 0;
		logger.info("Saving Country Object:"+country);
		sess = sessFactory.getCurrentSession();
		sess.beginTransaction().begin();
		id = (Integer)sess.save(country);
		sess.beginTransaction().commit();
		logger.info("Country is saved:"+country+" Id:"+id);
		return id ;
	
	}
	 
	public void deleteCountry(Country country) {
		// TODO Auto-generated method stub
		
	}
	 
	public void updateCountry(Country country) {
		// TODO Auto-generated method stub
		logger.info("Updating country data");
		sess = sessFactory.getCurrentSession();
		trans = sess.beginTransaction();
		sess.saveOrUpdate(Country.class);
		trans.commit();
		logger.info("Update finish");
		
	}
	 
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Country> countries = null;
		sess = sessFactory.getCurrentSession();
		tx = sess.beginTransaction();
		crit = sess.createCriteria(Country.class);
		
		countries = crit.list();
		tx.commit();
		logger.debug("No of Countries:"+countries.size());
		crit = null;
		return countries;
		
	}
	 
	public List<Country> getCountryById(Integer id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Country> countries = null;
		sess = sessFactory.getCurrentSession();
		tx = sess.beginTransaction();		
		crit = sess.createCriteria(Country.class);
		
		crit.add(Restrictions.eq("id", id));
		countries = crit.list();
		tx.commit();
		return countries;
	}
	 
	public List<Country> getCountryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public Country getCountryByStateId(int stateId) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public void saveState(State state) {
		// TODO Auto-generated method stub
		
		
		
	}
	 
	public List<Country> getStateById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public List<Country> getStateByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public List<State> getAllState() {
		// TODO Auto-generated method stub
		
		Transaction tx = null;
		List<State> states = null;
		sess = sessFactory.getCurrentSession();
		tx = sess.beginTransaction();
		crit = sess.createCriteria(State.class);
		
		states = crit.list();
		tx.commit();
		logger.debug("No of states:"+states.size());
		crit = null;
		return states;
		
		
	}

	public Country getStateByCountryId(int countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteState(State state) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateState(State state) {
		// TODO Auto-generated method stub
		logger.info("Updating State start");
		logger.debug("State Name:"+state.getName());
		try{
		sess = sessFactory.getCurrentSession();
		trans = sess.beginTransaction();
		sess.update(state);
		return 1;
		}catch(HibernateException he){
			logger.error("Hibernate Exception:"+he);
			return 0;	
		}
		
	}
	
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		logger.info("fetching all list of the city");
		List<City> cities  = null;
		Transaction tx = null;
		sess = sessFactory.getCurrentSession();
		tx = sess.beginTransaction();
		crit = sess.createCriteria(City.class);
		cities = crit.list();
		tx.commit();
		logger.debug("No of the city"+cities.size());
		return cities;
	}
	
	
	 
	public Integer saveCity(City city) {
		// TODO Auto-generated method stub
		Integer id = null;
		logger.info("Starting the saving cities"+city);
		sess = sessFactory.getCurrentSession();
		
		trans = sess.beginTransaction();
		id = (Integer)sess.save(city);
		logger.info("City Save with the Id"+id);
		trans = null;
		return id;
	}
	
	
	 
	public void updateCity(City city) {
		// TODO Auto-generated method stub
		logger.info("Starting the saving cities"+city);
		try{
		sess = sessFactory.getCurrentSession();
		trans = sess.beginTransaction();
		sess.saveOrUpdate(city);
		}catch(HibernateException he){
			logger.error("Exception is raised while saving the objetc"+he);
		}
		finally{
			if(trans!=null || trans.isActive()) 
				trans=null;
			 if(sess!=null)
				 sess=null;
		}
		
	}
	
	
	 
	public City findCityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	 
	public List<City> findCityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	 
	public List<Object[]> findCityByCountryId(int countryId) {
		// TODO Auto-generated method stub
		//SELECT distinct (c.name) FROM city c INNER JOIN state s ON c.state_id in (select id from state where country_id=1)
		logger.info("start");
		List<Object[]> cityNames = null;
		Query sqlQry = null;
		String sqlQuery = "SELECT distinct (c.name) as city_name FROM city c INNER JOIN state s ON c.state_id in (select id from state where country_id=?)";
		sess = sessFactory.getCurrentSession();
		sqlQry = sess.createSQLQuery(sqlQuery);
		sqlQry.setInteger(1, countryId);
		cityNames = sqlQry.list();
		logger.info("End fetching the city name from country id:"+countryId+" Total Number of the cities: "+cityNames.size());
		return cityNames;
	}
	
	
	/**
	 * 
	 * Setting the sessionFactory
	 * */
	public void setSessionFactory(SessionFactory sessFactory){
		this.sessFactory = sessFactory;
	}

	
	
}
