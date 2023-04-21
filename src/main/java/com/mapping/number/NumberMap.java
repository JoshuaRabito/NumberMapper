package com.mapping.number;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * {@link NumberMap} class. This class takes a series of numbers and maps it to the values of
 * matches in a map.
 *
 * @author rabitoj
 */
class NumberMap {

  private final Map<Integer, Integer> numberMap;

  /**
   * @param numberMap - map of values to map where keys match the numbers in a series
   * @throws NullPointerException if numberMap is null
   */
  public NumberMap(Map<Integer, Integer> numberMap) {
    Objects.requireNonNull(numberMap, "Number Map must not be null");
    this.numberMap = numberMap;
  }

  public int[] map(int[] numbers) {
    return Arrays.stream(mapArray(Arrays.stream(numbers).boxed().toArray(Integer[]::new)))
        .mapToInt(value -> value).toArray();
  }

  public Collection<Integer> map(Collection<Integer> numbers) {
    return Arrays.stream(mapArray(numbers.toArray(Integer[]::new))).collect(Collectors.toList());
  }

  public Integer[] map(Integer... numbers) {
    mapArray(numbers);
    return numbers;
  }


  private Integer[] mapArray(Integer[] numbers) {
    System.out.println("Mapping numbers " + Arrays.toString(numbers));
    String keyValuesString = numberMap.entrySet().stream().map(Object::toString)
        .collect(Collectors.joining(","));
    System.out.println("To values of keys " + keyValuesString);

    for (int inputIndex = 0; inputIndex < numbers.length; inputIndex++) {
      int maybeMapNumber = numbers[inputIndex];

      if (numberMap.containsKey(maybeMapNumber)) {
        numbers[inputIndex] = numberMap.get(maybeMapNumber);

      }

    }
    System.out.println("Mapped numbers " + Arrays.toString(numbers));
    return numbers;

  }
}
