package in.xgen.web.profile.user.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_addr")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="addr_id_seq")
	@SequenceGenerator(name="addr_id_seq",sequenceName="addr_id_seq")
	@Column(name="addr_id")
	private Integer addrId ;
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	public List<State> getState() {
		return state;
	}
	public void setState(List<State> state) {
		this.state = state;
	}
	public List<Country> getCounty() {
		return county;
	}
	public void setCounty(List<Country> county) {
		this.county = county;
	}

	@Column(name="street_name")
	private String streetName ;
	@Column(name="office_name")
	private String officeName; 
	@Column(name="block_number")
	private String blockNumber ;
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	@Column
	private String houseNo;
	@OneToMany(cascade=CascadeType.ALL)
	
	private List<City>  city;
	@OneToMany(cascade=CascadeType.ALL)
	
	private List<State> state;
	@OneToMany(cascade=CascadeType.ALL)
	
	private List<Country> county;
	
	
}
