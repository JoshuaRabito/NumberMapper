package com.mapping.number;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		System.out.println("Welcome to my number mapping demo.");
		int [] numbers = new int[] { 1, 2, 3, 1, 5 };
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 10);
		numberMap.put(2, 33);
		NumberMap mapper = new NumberMap( numberMap);
		mapper.map(numbers);


	}

}
