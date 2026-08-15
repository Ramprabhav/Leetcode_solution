import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        // Add all students to queue
        for (int student : students) {
            q.add(student);
        }

        int sandwichIndex = 0;
        int count = 0;

        while (!q.isEmpty() && count < q.size()) {

            // Front student wants the current sandwich
            if (q.peek() == sandwiches[sandwichIndex]) {
                q.remove();
                sandwichIndex++;
                count = 0; // reset because someone ate
            } 
            else {
                // Move front student to the end
                q.add(q.remove());
                count++;
            }
        }

        return q.size();
    }
}