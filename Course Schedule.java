class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];

        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new java.util.ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course,
                        java.util.List<java.util.List<Integer>> graph,
                        int[] visited) {
        if (visited[course] == 1) {
            return false;
        }

        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;

        for (int next : graph.get(course)) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }

        visited[course] = 2;
        return true;
    }
}
