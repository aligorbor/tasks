package ru.geekbrains.javaCoreProf.tasks.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Arrays14Test {
    private Arrays14 arrays14;

    @BeforeEach
    public void init() {
        arrays14 = new Arrays14();

    }

    static Stream<Arguments> twoArraysProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                arguments(new int[]{1, 2, 1, 4, 2, 3, 2, 1, 3}, new int[]{2, 3, 2, 1, 3}),
                arguments(new int[]{4, 2, 4, 4, 2, 3, 1, 1, 7}, new int[]{2, 3, 1, 1, 7}),
                arguments(new int[]{1, 2, 4, 5, 2, 3, 2, 1, 7}, new int[]{5, 2, 3, 2, 1, 7}),
                arguments(new int[]{1, 2, 4, 4, 2, 3, 1, 1, 3}, new int[]{2, 3, 1, 1, 3})

        );
    }

    static Stream<Arguments> throwProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4}),
                arguments(new int[]{1, 2, 1, 3, 2, 3, 3, 1, 1}),
                arguments(new int[]{4}),
                arguments(new int[]{}),
                arguments(new int[]{1, 2, 3, 5, 2, 3, 2, 1, 7})

        );
    }

    @ParameterizedTest
    @MethodSource("twoArraysProvider")
    void testArrayAfter4(int[] input, int[] result) {
        Assertions.assertArrayEquals(result, arrays14.arrayAfter4(input));
    }

    @ParameterizedTest
    @MethodSource("throwProvider")
    void testThrowArrayAfter4(int[] input) {
        Assertions.assertThrows(RuntimeException.class, () -> arrays14.arrayAfter4(input));
    }

    static Stream<Arguments> arrayBooleanProvider() {
        return Stream.of(
                arguments(new int[]{1, 1, 4, 4, 1, 1, 4, 1, 1}, true),
                arguments(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, false),
                arguments(new int[]{4, 4, 4, 4}, false),
                arguments(new int[]{1, 1, 4, 1, 1, 1, 1, 1, 1}, true),
                arguments(new int[]{1, 2, 4, 4, 1, 1, 4, 1, 4}, false)

        );
    }

    @ParameterizedTest
    @MethodSource("arrayBooleanProvider")
    void testArrayTrue14(int[] input, boolean result) {
        Assertions.assertEquals(result, arrays14.arrayTrue14(input));
    }
}