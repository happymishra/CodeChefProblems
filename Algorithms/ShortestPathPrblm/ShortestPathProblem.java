// Shortest path problem.

public class ShortestPathProblem {

    public static void main(String[] args) {
        int graphMatrix[][] = new int[5][5];
        int source = 0, destination = 4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                graphMatrix[i][j] = 999;
            }
        }
        graphMatrix[0][1] = 10;
        graphMatrix[0][4] = 50;
        graphMatrix[1][2] = 5;
        graphMatrix[1][4] = 20;
        graphMatrix[2][3] = 5;
        graphMatrix[3][4] = 5;

        shortestPath(graphMatrix, 0, 4);

    }

    private static void shortestPath(int graphMatrix[][], int source, int destination) {
        int vertex[] = {0, 0, 0, 0, 0};
        int shortestPathValue[] = {0, 999, 999, 999, 999};
        int parent[] = new int[5];
        parent[0] = -1;
        for (int i = 0; i < 5; i++) {
            int shortestValue = 999;
            int index = 0;
            if (vertex[i] != 1) {
                for (int j = 0; j < 5; j++) {
                    if (graphMatrix[i][j] != 999 && shortestPathValue[j] > (graphMatrix[i][j] + shortestPathValue[i])) {
                        shortestPathValue[j] = graphMatrix[i][j] + shortestPathValue[i];
                        parent[j] = i;

                    }

                }
            }
            vertex[0] = 1;
        }

        System.out.println("Shortest path value of destination: " + shortestPathValue[destination]);
         System.out.print("Shortest path: ");
        for(int i = destination; i > 0;)
        {
            System.out.print(parent[i]);
            i = parent[i];
        }
    }
}
