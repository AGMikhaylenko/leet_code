package hard.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/ipo/
 * Runtime 5.15% Memory 19.28%
 */
public class IPO {
    public static void main(String[] args) {

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        projects.sort(Comparator.naturalOrder());

        int projectCount = 0;
        int i;

        while (projectCount < k) {
            for (i = 0; i < projects.size(); i++) {
                if (projects.get(i).capital <= w) {
                    break;
                }
            }
            if (i == projects.size()) {
                return w;
            } else {
                w += projects.get(i).profit;
                projects.remove(i);
                projectCount++;
            }
        }

        return w;
    }

    class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project o) {
            int c = o.profit - this.profit;
            if (c == 0) {
                return this.capital - o.capital;
            } else {
                return c;
            }
        }
    }
}
