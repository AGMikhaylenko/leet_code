package medium.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
 * Runtime 55.52% Memory 96.41%
 */
public class MinimumFuelCostToReportToTheCapital {

    private int seats;

    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {1, 2}};
        int seats = 2;

        long res = new MinimumFuelCostToReportToTheCapital().minimumFuelCost(roads, seats);
        System.out.println(res);
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        City capital = prepareData(roads);
        this.seats = seats;

        return travelCity(capital, null).fuel;
    }

    private Result travelCity(City city, City parent) {
        if (city.neighbours.size() == 1 && parent != null) {
            return new Result(0, 1, 1);
        }

        long fuel = 0;
        long count = 1;
        long cars = 0;
        Result result;
        for (City neighbour : city.neighbours) {
            if (neighbour != parent) {
                result = travelCity(neighbour, city);
                fuel += result.fuel;
                count += result.passengers;
                cars += result.cars;
            }
        }
        fuel += cars;
        cars = count % seats == 0 ? count / seats : count / seats + 1;
        return new Result(fuel, count, cars);
    }

    private City prepareData(int[][] roads) {
        int n = 0;
        for (int[] line : roads) {
            for (int i : line) {
                n = Integer.max(n, i);
            }
        }

        City[] cities = new City[n + 1];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        for (int[] road : roads) {
            cities[road[0]].neighbours.add(cities[road[1]]);
            cities[road[1]].neighbours.add(cities[road[0]]);
        }

        return cities[0];
    }

    class City {
        List<City> neighbours = new ArrayList<>();
    }

    class Result {
        long fuel;
        long passengers;
        long cars;

        public Result(long fuel, long passengers, long cars) {
            this.fuel = fuel;
            this.passengers = passengers;
            this.cars = cars;
        }
    }
}
