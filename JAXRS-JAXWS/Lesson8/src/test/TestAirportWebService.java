package test;

import net.webservicex.Airport;
import net.webservicex.AirportSoap;

public class TestAirportWebService {

	
	public static void main(String[] args) {
		Airport airport = new Airport();
		AirportSoap airportSOAP = airport.getAirportSoap();
		
		//
		String IST = airportSOAP.getAirportInformationByAirportCode("IST");
		System.out.println(IST);
		//
		String ANKARA_ESENBOGA = airportSOAP.getAirportInformationByCityOrAirportName("ANKARA ESENBOGA");
		System.out.println(ANKARA_ESENBOGA);
		//
		String TURKEY = airportSOAP.getAirportInformationByCountry("TURKEY");
		System.out.println(TURKEY);
	}
}
