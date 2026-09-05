import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // Add {score, original index}
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{score[i], i});
        }

        String[] answer = new String[n];

        int rank = 1;

        while (!pq.isEmpty()) {

            int[] athlete = pq.poll();

            int index = athlete[1];

            if (rank == 1) {
                answer[index] = "Gold Medal";
            }
            else if (rank == 2) {
                answer[index] = "Silver Medal";
            }
            else if (rank == 3) {
                answer[index] = "Bronze Medal";
            }
            else {
                answer[index] = String.valueOf(rank);
            }

            rank++;
        }

        return answer;
    }
}