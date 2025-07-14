package tech;

import java.util.ArrayList;
import java.util.List;

public class ServerLocales {
	
	
	List<String> parseAcceptedLaguage(String clientLocale, String [] serverLocales) {
		
		List<String> supportedLcalesList= new ArrayList<>();
		List<String> serverLocaleList = List.of(serverLocales);
		
		for(String locale : clientLocale.split(",")) {
			
			if(serverLocaleList.contains(locale)){
				supportedLcalesList.add(locale);
			}
			
		}
		
		
		return supportedLcalesList;
	}
	
	public static void main(String[] args) {
		
		ServerLocales locales = new ServerLocales();
		
		System.out.println(locales.parseAcceptedLaguage("en_US,en_GB", new String[]{"en_GB","en_US","de_DE"}));
		
	}

}
