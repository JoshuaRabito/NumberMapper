package com.mapping.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void mapNumbers_withValidInput_numbersinSeriesMapped() {
		//given
		int [] numbers = new int[] { 1, 2, 3, 1, 5 };
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 10);
		numberMap.put(2, 33);
		MyNumberMapper mapper = new MyNumberMapper(numbers, numberMap);

		//when
		int[] mappedNumbers = mapper.mapNumbers();

		//then
		int[] expected = new int[] {10, 33, 3, 10, 5};
		assertThat(mappedNumbers).containsExactly(expected);
	}

	@Test
	void mapNumbers_withNullInputs_should_throwNullPointer() {
		//given
		assertThrows(NullPointerException.class, () -> new MyNumberMapper(null, null));
	}

}
