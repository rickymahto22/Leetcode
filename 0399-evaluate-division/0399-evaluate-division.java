class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int id = 0;

        for(List<String> s : equations){
            if(!map.containsKey(s.get(0))){
                map.put(s.get(0), id++);
            }
            if(!map.containsKey(s.get(1))){
                map.put(s.get(1), id++);
            }
        }

        List<Pair<Integer,Double>> graph[] = new ArrayList[id];

        for(int i = 0; i < id; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < equations.size(); i++){
            List<String> s = equations.get(i);

            int u = map.get(s.get(0));
            int v = map.get(s.get(1));

            graph[u].add(new Pair<>(v, values[i]));
            graph[v].add(new Pair<>(u, 1.0 / values[i]));
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){

            List<String> src = queries.get(i);

            if(!map.containsKey(src.get(0)) || !map.containsKey(src.get(1))){
                ans[i] = -1.0;
                continue;
            }

            int s = map.get(src.get(0));
            int d = map.get(src.get(1));

            if(s == d){
                ans[i] = 1.0;
                continue;
            }

            boolean[] vis = new boolean[id];
            Queue<Pair<Integer,Double>> qu = new LinkedList<>();

            qu.offer(new Pair<>(s, 1.0));
            vis[s] = true;

            ans[i] = -1.0;

            while(!qu.isEmpty()){

                Pair<Integer,Double> c = qu.poll();

                int cur = c.getKey();
                double ratio = c.getValue();

                for(Pair<Integer,Double> nei : graph[cur]){

                    int n = nei.getKey();
                    double v = nei.getValue();

                    if(vis[n]){
                        continue;
                    }

                    double vv = ratio * v;

                    if(n == d){
                        ans[i] = vv;
                        break;
                    }

                    vis[n] = true;
                    qu.offer(new Pair<>(n, vv));
                }

                if(ans[i] != -1.0){
                    break;
                }
            }
        }

        return ans;
    }
}