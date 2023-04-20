package com.mapping.demo;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class MyNumberMapper {

  private final int[] numbers;
  private final Map<Integer, Integer> numberMap;

  public MyNumberMapper(int[] numbers, Map<Integer, Integer> numberMap) {
    Objects.requireNonNull(numbers, "Number series must not be null");
    Objects.requireNonNull(numberMap, "Number Map must not be null");

    this.numbers = numbers;
    this.numberMap = numberMap;
  }

  public int[] mapNumbers() {
    System.out.println("Mapping numbers "+ Arrays.toString(numbers));
    String keyValuesString = numberMap.entrySet().stream().map(e -> e.toString())
        .collect(Collectors.joining(","));
    System.out.println("To values of keys "+ keyValuesString);

    numberMap.keySet().forEach(numberToMap -> {
      for (int numbersIndex = 0; numbersIndex < numbers.length; numbersIndex++) {
        int maybeMapNumber = numbers[numbersIndex];
        if(maybeMapNumber == numberToMap){
          numbers[numbersIndex] = numberMap.get(numberToMap);
        }

      }
    });
    System.out.println("Mapping numbers "+ Arrays.toString(numbers));
    return numbers;
  }
}
