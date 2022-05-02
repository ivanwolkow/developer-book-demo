package com.example.demo.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
 * and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 */
public class EvaluateDivision {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testEquationSystemSolution(List<List<String>> equations,
                                    double[] values,
                                    List<List<String>> queries,
                                    double[] expected) {
        assertArrayEquals(expected, calcEquation(equations, values, queries));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);

            String a = pair.get(0);
            String b = pair.get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).putIfAbsent(b, values[i]);

            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).putIfAbsent(a, 1 / values[i]);
        }


        double[] result = new double[queries.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = depthFirstSearch(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return result;
    }

    private double depthFirstSearch(HashMap<String, HashMap<String, Double>> graph, String a, String b, Set<String> visited) {

        if (!graph.containsKey(a)) return -1.0d;

        if (graph.get(a).containsKey(b)) return graph.get(a).get(b);

        for (Map.Entry<String, Double> node : graph.get(a).entrySet()) {
            if (visited.contains(node.getKey())) continue;

            visited.add(node.getKey());
            double result = depthFirstSearch(graph, node.getKey(), b, visited);
            if (result != -1.0d) return result * node.getValue();
        }

        return -1.0d;
    }

    private static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("a", "b"),
                                List.of("b", "c")
                        ),
                        new double[]{2.0, 3.0},
                        List.of(
                                List.of("a", "c"),
                                List.of("b", "a"),
                                List.of("a", "e"),
                                List.of("a", "a"),
                                List.of("x", "x")
                        ),
                        new double[]{6.0, 0.5, -1.0, 1.0, -1.0}
                ),
                Arguments.of(
                        List.of(
                                List.of("a", "b"),
                                List.of("b", "c"),
                                List.of("bc", "cd")
                        ),
                        new double[]{1.5, 2.5, 5.0},
                        List.of(
                                List.of("a", "c"),
                                List.of("c", "b"),
                                List.of("bc", "cd"),
                                List.of("cd", "bc")
                        ),
                        new double[]{3.75, 0.4, 5.0, 0.2}
                )
        );
    }

}
