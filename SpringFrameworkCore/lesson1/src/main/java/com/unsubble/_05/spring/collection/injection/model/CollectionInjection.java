package com.unsubble._05.spring.collection.injection.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.unsubble._04.spring.setter.injection.model.Employee;

public class CollectionInjection {

	private List<String> myList;
	private List<Employee> myEmployeeList;
	private Set<Integer> mySet;
	private Map<String, Object> myMap;
	private Properties properties;

	public List<String> getMyList() {
		return myList;
	}

	public void setMyList(List<String> myList) {
		this.myList = myList;
	}

	public Set<Integer> getMySet() {
		return mySet;
	}

	public void setMySet(Set<Integer> mySet) {
		this.mySet = mySet;
	}

	public Map<String, Object> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<String, Object> myMap) {
		this.myMap = myMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Employee> getMyEmployeeList() {
		return myEmployeeList;
	}

	public void setMyEmployeeList(List<Employee> myEmployeeList) {
		this.myEmployeeList = myEmployeeList;
	}

	@Override
	public String toString() {
		return "CollectionInjection [myList=" + myList + ", myEmployeeList=" + myEmployeeList + ", mySet=" + mySet
				+ ", myMap=" + myMap + ", properties=" + properties + "]";
	}

}
