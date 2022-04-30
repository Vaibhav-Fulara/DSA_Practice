public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); ++i){
            List<String> currEquation = equations.get(i);
            graph.putIfAbsent(currEquation.get(0), new HashMap<>());
            graph.putIfAbsent(currEquation.get(1), new HashMap<>());
            graph.get(currEquation.get(0)).put(currEquation.get(1), values[i]);
            graph.get(currEquation.get(1)).put(currEquation.get(0), 1/values[i]);
        }

        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i){
            results[i] = bfs(queries.get(i).get(0), queries.get(i).get(1),
                    1.0, graph, new HashSet<>());
        }
        return results;
    }

    public double bfs(String src, String des, double res, Map<String, Map<String, Double>> graph, Set<String> visited){
        Queue<BfsNode> queue = new LinkedList<>();
        queue.add(new BfsNode(src, res));
        while(!queue.isEmpty()){
            BfsNode node = queue.poll();
            Double currVal = node.Val;
            String currChar = node.Char;
            if(!graph.containsKey(currChar)) return -1.0;
            if(visited.contains(currChar)) continue;
            visited.add(currChar);
            if(Objects.equals(currChar, des)) return currVal;
            Map<String, Double> neighbours = graph.get(currChar);
            for(String neighbour : neighbours.keySet()){
                queue.add(new BfsNode(neighbour, currVal * neighbours.get(neighbour)));
            }
        }
        return -1;
    }

    static class BfsNode{
        public String Char;
        public Double Val;

        public BfsNode(String aChar, Double val) {
            Char = aChar;
            Val = val;
        }
    }
}