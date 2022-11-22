public class Main {
    public static void main(String[] args) {

        Matrixgraph thisgraph = new Matrixgraph(7);
        int [] differenceGraph = new int[7];
        int biggest = 0;
        thisgraph.addEdge(0,3,2000);
        thisgraph.addEdge(0,2,2000);
        thisgraph.addEdge(1,3,5000);
        thisgraph.addEdge(1,2,3000);
        thisgraph.addEdge(1,4,2000);
        thisgraph.addEdge(1,5,7000);
        thisgraph.addEdge(1,6,7000);
        thisgraph.addEdge(2,1,5000);
        thisgraph.addEdge(2,0,3000);
        thisgraph.addEdge(2,5,2000);
        thisgraph.addEdge(3,6,2000);
        thisgraph.addEdge(3,5,500);

        thisgraph.printGraph();
        System.out.println("thisgraph printed");
        /*
        Calculating the difference, by checking if there is an edge.
        If there is it subtracts outgoing containers, and adds incoming containers.
         */
        for (int i = 0; i<thisgraph.matrixedgegraph.length; i++) {
            for (int j = 0; j < thisgraph.matrixedgegraph.length; j++) {
                if (thisgraph.matrixedgegraph[i][j] == 1) {
                    differenceGraph[i] = differenceGraph[i] - thisgraph.matrixweightgraph[i][j];
                    differenceGraph[j] = differenceGraph[j] + thisgraph.matrixweightgraph[i][j];
                }
            }
        }

        for(int i =0;i<differenceGraph.length; i++){
            System.out.println(differenceGraph[i]);
        }


        System.out.println("highest: "+ thisgraph.findBiggestindex(differenceGraph));
        System.out.println("Lowest: "+ thisgraph.findLowestindex(differenceGraph));
    }

}