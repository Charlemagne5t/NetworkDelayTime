import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }



        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.pathCost));
        priorityQueue.offer(new Pair(0, k));
        Set<Integer> visited = new HashSet<>();

        int result = 0;
        while (!priorityQueue.isEmpty()){
            Pair current = priorityQueue.poll();

            int currentCost = current.pathCost;
            int currentNode = current.node;

            if(visited.contains(currentNode)){
                continue;
            }

            visited.add(currentNode);

            result = Math.max(result, currentCost);

            for (int i = 0; i < adjList.get(currentNode).size(); i++) {
                if(!visited.contains(adjList.get(currentNode).get(i)[0])){
                    priorityQueue.offer(new Pair(adjList.get(currentNode).get(i)[1] + currentCost ,adjList.get(currentNode).get(i)[0]));
                }
            }

        }

        return visited.size() == n ? result : -1;

    }
}

class Pair{
    int pathCost;
    int node;

    public Pair(int pathCost, int node) {
        this.pathCost = pathCost;
        this.node = node;
    }
}