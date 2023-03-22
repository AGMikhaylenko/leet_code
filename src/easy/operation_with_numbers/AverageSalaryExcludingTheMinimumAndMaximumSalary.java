package easy.operation_with_numbers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * Runtime 7% Memory 65.10%
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {
        return Arrays.stream(salary).boxed().
                sorted()
                .skip(1)
                .limit(salary.length-2)
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }
}
