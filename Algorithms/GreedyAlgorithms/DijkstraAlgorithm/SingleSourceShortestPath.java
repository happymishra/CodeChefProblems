public class SingleSourceShortestPath {
    static final int noOfVertices = 9;
    static Boolean[] visited = new Boolean[noOfVertices];
    static int[] distanceFromSource = new int[noOfVertices];
    static int path[] = new int[noOfVertices];
    
    public static void main(String[] args) {
        int graph[][] = 
                new int[][]{
                            {0, 4, 0, 0, 0, 0, 0, 8, 0},
                            {4, 0, 8, 0, 0, 0, 0, 11, 0},
                            {0, 8, 0, 7, 0, 4, 0, 0, 2},
                            {0, 0, 7, 0, 9, 14, 0, 0, 0},
                            {0, 0, 0, 9, 0, 10, 0, 0, 0},
                            {0, 0, 4, 14, 10, 0, 2, 0, 0},
                            {0, 0, 0, 0, 0, 2, 0, 1, 6},
                            {8, 11, 0, 0, 0, 0, 1, 0, 7},
                            {0, 0, 2, 0, 0, 0, 6, 7, 0}
                           };
        
        shortestPathAlgo(graph, 0);
    }
    private static void shortestPathAlgo(int [][] graph, int source){
        init();
        distanceFromSource[source] = 0;
        
        for(int vertex = 0; vertex < noOfVertices; vertex++){
            int minDistVertex = getMinimumDistanceNotVisitedVetex();
            visited[minDistVertex] = true;
            
            for(int v = 0; v < noOfVertices; v++){
                
                if(!visited[v] 
                        && graph[minDistVertex][v] !=0 
                        && (distanceFromSource[minDistVertex] + graph[minDistVertex][v]) < distanceFromSource[v])
                {
                    distanceFromSource[v] = distanceFromSource[minDistVertex] + graph[minDistVertex][v];
                }
            }
        }
        
        printSolution();
    }
    
    private static void init(){
        for (int i = 0; i < noOfVertices; i++){
            visited[i] = false;
            distanceFromSource[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
    }
    
    private static int getMinimumDistanceNotVisitedVetex(){
        int minimumDistanceVetex = -1,
            mimumDistance = Integer.MAX_VALUE;
        
        for (int vertex = 0; vertex < noOfVertices; vertex++){
            if(!visited[vertex] && (distanceFromSource[vertex] <= mimumDistance)){
                mimumDistance = distanceFromSource[vertex];
                minimumDistanceVetex = vertex;
            }
        }
        
        return minimumDistanceVetex;
    }
    
    static void printSolution()
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < noOfVertices; i++)
            System.out.println(i+" \t\t "+distanceFromSource[i]);
    }
}
