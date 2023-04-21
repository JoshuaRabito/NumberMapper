package com.mapping.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberMapTest {

	@Test
	void map_with_arrayInput_withOutput_10_33_3_10_5() {
		//given
		int [] numbers = new int[] { 1, 2, 3, 1, 5 };
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 10);
		numberMap.put(2, 33);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		int[] mappedNumbers = mapper.map(numbers);

		//then
		int[] expected = new int[] {10, 33, 3, 10, 5};
		assertThat(mappedNumbers).containsExactly(expected);
	}

	@Test
	void map_withNullInput_should_throwNullPointer() {
		//given
		assertThrows(NullPointerException.class, () -> new NumberMap( null));
	}

	@Test
	void map_with_arrayInput_withOutput2121() {
		//given
		int [] numbers = new int[] { 1, 2, 1,2 };
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 2);
		numberMap.put(2, 1);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		int[] mappedNumbers = mapper.map(numbers);

		//then
		int[] expected = new int[] {2, 1, 2, 1};
		assertThat(mappedNumbers).containsExactly(expected);
	}

	@Test
	void map_with_arrayInput_withOut21213() {
		//given
		int [] numbers = new int[] { 1, 2, 1,2,3 };
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 2);
		numberMap.put(2, 1);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		int[] mappedNumbers = mapper.map(numbers);

		//then
		int[] expected = new int[] {2, 1, 2, 1, 3};
		assertThat(mappedNumbers).containsExactly(expected);
	}

	@Test
	void map_with_listInput_withOutput_10_33_3_10_5() {
		//given
		List<Integer> numberList = IntStream.of( 1, 2, 3, 1, 5 ).boxed().collect(Collectors.toList());

		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 10);
		numberMap.put(2, 33);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		Collection<Integer> mappedNumbers = mapper.map(numberList);

		//then
		List<Integer> expected = List.of(10, 33, 3, 10, 5);
		assertThat(mappedNumbers).isEqualTo(expected);
	}

	@Test
	void map_with_setInput_withOutput_10_33_3_5() {
		//given
		Set<Integer> numberSet = new HashSet<>(  );
		numberSet.add(1);
		numberSet.add( 2);
		numberSet.add(3);
		numberSet.add( 1);
		numberSet.add( 5);

		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 10);
		numberMap.put(2, 33);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		Collection<Integer> mappedNumbers = mapper.map(numberSet);

		//then
		List<Integer> expected = List.of(10, 33, 3, 5);
		assertThat(mappedNumbers).isEqualTo(expected);
	}


	@Test
	void map_with_varArgsInput_withOutput2121() {
		//given
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 2);
		numberMap.put(2, 1);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		Integer[] mappedNumbers = mapper.map(1, 2, 1,2);

		//then
		Integer[] expected = new Integer[] {2, 1, 2, 1};
		assertThat(mappedNumbers).containsExactly(expected);
	}

	@Test
	void map_with_varArgsInput_withOut21213() {
		//given
		Map<Integer, Integer> numberMap = new HashMap<>();
		numberMap.put(1, 2);
		numberMap.put(2, 1);
		NumberMap mapper = new NumberMap( numberMap);

		//when
		Integer[] mappedNumbers = mapper.map( 1, 2, 1,2,3 );

		//then
		Integer[] expected = new Integer[] {2, 1, 2, 1, 3};
		assertThat(mappedNumbers).containsExactly(expected);
	}



}
