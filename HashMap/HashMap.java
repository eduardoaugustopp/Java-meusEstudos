package com.map.pacote;

import java.util.HashMap;

public class HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> empIds = new HashMap<>();
		
		empIds.put("Eduardo", 12345);
		empIds.put("Augusto", 67891);
		empIds.put("Teste", 62291);
		
		System.out.println(empIds);
		
		System.out.println(empIds.get("Eduardo"));
		
		System.out.println(empIds.containsKey("Augusto"));
		
		System.out.println(empIds.containsValue(1235));
		
		empIds.put("Eduardo", 77777);
		System.out.println(empIds);
		
		empIds.replace("Teste2", 12345);
		System.out.println(empIds);
		
		empIds.replace("Augusto", 20);
		System.out.println(empIds);
		
		empIds.putIfAbsent("Teste2", 222);
		System.out.println(empIds);
		
		empIds.remove("Teste2");
		System.out.println(empIds);
	}

}
