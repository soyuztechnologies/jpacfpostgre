package com.anubhavtrainings.entities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.anubhavtrainings.annotation.processor.ODataInterface;
import com.anubhavtrainings.service.IVendorPersistence;
import com.anubhavtrainings.service.vendorService;

import lombok.extern.slf4j.Slf4j;
import com.anubhavtrainings.entities.*;

@Slf4j
public class VendorODataAgent implements ODataInterface{
	
	@Autowired
	IVendorPersistence vendorAPI;
	
	public List<?> getEntitySet(){
		log.debug("createEntity called");
		return vendorAPI.findAll();
	}

	@Override
	public Object getEntity(Map<String, ?> keys) {
		log.debug("getEntity called");
		String id = (String) keys.get("Id");
		return vendorAPI.findById(id).get();
	}
	
	@Override
	public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
			Field sourceField) {
		log.debug("getRelatedEntity called");
		log.debug("relatedEntityName is " + relatedEntityName);
		Vendor p;
		//
		try {
			p = (Vendor)source;
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> targetKeys = (Map<String, String>) source;
			String vendorId = targetKeys.get("Id");
			p = vendorAPI.findById(vendorId).get();
		}
		
		
		if (relatedEntityName.equalsIgnoreCase("AddressSet")) {
			return p.getAddresses();
		}
		return new ArrayList<>();
	}
	
	@Override
	public void createEntity(Object dataToCreate) {
		log.debug("createEntity called");
		vendorAPI.save((Vendor)dataToCreate);
	}

	@Override
	public void deleteEntity(Map<String, ?> keys) {
		log.debug("deleteEntity called");
		String id = (String)keys.get("Id");
		vendorAPI.deleteById(id);
	}

	@Override
	public void updateEntity(Object dataToUpdate) {
		log.debug("updateEntity called");
		Vendor p = (Vendor)dataToUpdate;
		vendorAPI.save(p);
	}

	@Override
	public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
			Map<String, Object> targetKeys) {
		// TODO Auto-generated method stub
		
		
	}

}
