import java.util.*;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        // Put all people into the queue
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        int time = 0;

        while (true) {

            // Person at the front
            int person = q.remove();

            // Buy one ticket
            tickets[person]--;

            // 1 second passed
            time++;

            // If our target person has finished
            if (person == k && tickets[person] == 0) {
                return time;
            }

            // If this person still needs tickets,
            // send them to the back
            if (tickets[person] > 0) {
                q.add(person);
            }
        }
    }
}