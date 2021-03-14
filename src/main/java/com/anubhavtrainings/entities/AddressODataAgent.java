package com.anubhavtrainings.entities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.anubhavtrainings.annotation.processor.ODataInterface;
import com.anubhavtrainings.service.IAddressPersistence;
import com.anubhavtrainings.service.IVendorPersistence;
import com.anubhavtrainings.service.vendorService;

import lombok.extern.slf4j.Slf4j;
import com.anubhavtrainings.entities.*;

@Slf4j
public class AddressODataAgent implements ODataInterface{
	
	@Autowired
	IAddressPersistence addressAPI;
	
	public List<?> getEntitySet(){
		log.debug("createEntity called");
		return addressAPI.findAll();
	}

	@Override
	public Object getEntity(Map<String, ?> keys) {
		log.debug("createEntity called");
		return keys;
	}
	
	@Override
	public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
			Field sourceField) {
		log.debug("createEntity called");
		return null;
	}
	
	@Override
	public void createEntity(Object dataToCreate) {
		log.debug("createEntity called");
		addressAPI.save((address)dataToCreate);
	}

	@Override
	public void deleteEntity(Map<String, ?> keys) {
		log.debug("deleteEntity called");
	}

	@Override
	public void updateEntity(Object dataToUpdate) {
		log.debug("updateEntity called");
	}

	@Override
	public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
			Map<String, Object> targetKeys) {
		// TODO Auto-generated method stub
		log.debug("write Relations called");
		Vendor vendor = (Vendor)sourceData;
		Optional<address> existingAddr =  addressAPI.findById((String) targetKeys.get("AddressId"));
		address newAddr = existingAddr.get();
		newAddr.setVendor(vendor);
		addressAPI.save(newAddr);
		//targetKeys.put("vendor", vendor.getId());
	}

}
