package dao.test;

import java.util.List;

import in.xgen.web.profile.user.dao.AddressDAO;
import in.xgen.web.profile.user.dao.AddressDAOImpl;
import in.xgen.web.profile.user.domain.Address;
import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressDAOTest {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("/config/spring-doa.intergration.xml");
		AddressDAO aDAO = (AddressDAO)context.getBean("addressDAOImpl");
		Address address = new Address();
		
		List<City> countryList = aDAO.getAllCity();
			
	
		for(City count :countryList){
			System.out.println(count.getCityId()+" "+count.getName());
		}
		
	
	}
}
