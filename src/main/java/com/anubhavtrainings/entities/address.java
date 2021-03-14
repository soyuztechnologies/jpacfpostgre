package com.anubhavtrainings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.hibernate.annotations.GenericGenerator;

@EdmEntityType
@EdmEntitySet
@Entity
public class address {
	
	@Id
	@EdmKey
	@EdmProperty
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(nullable=false, name="ID")
	private String addressId;
	@EdmProperty
	@Column(name="TYPE")
	private String addressType;
	@EdmProperty
	@Column(name="STREET")
	private String street;
	@EdmProperty
	@Column(name="CITY")
	private String city;
	@EdmProperty
	@Column(name="COUNTRY")
	private String country;
	@EdmProperty
	@Column(name="REGION")
	private String region;
	

	@ManyToOne  
	@JoinColumn(name="vendor_id", referencedColumnName="id")
    public Vendor vendor;  
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public address() {
		
	}
	public address(String addressId, String addressType, String street, String city, String country, String region) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
