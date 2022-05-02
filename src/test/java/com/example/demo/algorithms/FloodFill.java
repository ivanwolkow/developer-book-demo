package com.example.demo.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Flood fill, also called seed fill, is a flooding algorithm that determines and alters the area connected
 * to a given node in a multi-dimensional array with some matching attribute. It is used in the "bucket" fill tool
 * of paint programs to fill connected, similarly-colored areas with a different color,
 * and in games such as Go and Minesweeper for determining which pieces are cleared.
 */
public class FloodFill {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testFloodFill(int[][] input, int sr, int sc, int newColor, int[][] expectedResult) {
        assertArrayEquals(expectedResult, floodFillRecursive(input, sr, sc, newColor));
        assertArrayEquals(expectedResult, floodFillQueue(input, sr, sc, newColor));
    }

    private static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        }, 1, 1, 2,
                        new int[][]{
                                {2, 2, 2},
                                {2, 2, 0},
                                {2, 0, 1}
                        }),
                Arguments.of(
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0}
                        }, 1, 1, 2,
                        new int[][]{
                                {2, 2, 2},
                                {2, 2, 2}
                        })
        );
    }

    public int[][] floodFillRecursive(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;

        image[sr][sc] = newColor;

        if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor) floodFillRecursive(image, sr - 1, sc, newColor);
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor) floodFillRecursive(image, sr, sc - 1, newColor);
        if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) floodFillRecursive(image, sr + 1, sc, newColor);
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) floodFillRecursive(image, sr, sc + 1, newColor);

        return image;
    }

    public int[][] floodFillQueue(int[][] image, int sr, int sc, int newColor) {

        int initColor = image[sr][sc];
        HashSet<List<Integer>> alreadyAdded = new HashSet<>();
        LinkedList<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.add(List.of(sr, sc));

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int r = current.get(0);
            int c = current.get(1);

            image[r][c] = newColor;
            if (r - 1 >= 0 && image[r - 1][c] == initColor) add(r - 1, c, queue, alreadyAdded);
            if (r + 1 < image.length && image[r + 1][c] == initColor) add(r + 1, c, queue, alreadyAdded);
            if (c - 1 >= 0 && image[r][c - 1] == initColor) add(r, c - 1, queue, alreadyAdded);
            if (c + 1 < image[0].length && image[r][c + 1] == initColor) add(r, c + 1, queue, alreadyAdded);
        }

        return image;
    }

    private void add(int r, int c, LinkedList<List<Integer>> queue, Set<List<Integer>> alreadyAdded) {
        List<Integer> item = List.of(r, c);
        if (!alreadyAdded.add(item)) return;
        queue.add(item);
    }
}
