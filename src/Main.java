public class Main {
    public static void main(String[] args) {

        Matrixgraph thisgraph = new Matrixgraph(7); //First graph, instantiated with numbers from the assignment
        Matrixgraph newgraph = new Matrixgraph(7); //second graph, calculated with the algorithm.
        int [] differenceGraph = new int[7]; //list made to save the difference in outgoing and incoming containers
        int moneyUsed = 0;

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

        System.out.println("Containers going out using these vertices: ");
        thisgraph.printGraph(); //Method to print the graph

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
        /*
        Finding the highest and lowest digits in the difference list, and their respective indexes.
         */
        int amountatlow = differenceGraph[thisgraph.findLowestindex(differenceGraph)];
        int amountathigh = differenceGraph[thisgraph.findBiggestindex(differenceGraph)];

        /*
        Using a while loop to calculate until the amount at low difference in the list is 0.
        Adding vertices to a new graph, and calculating the difference so it changes in the difference list.
        getting a new highest and lowest number from the difference list and continuing.
         */

        while (amountatlow!=0) {
            newgraph.addEdge(thisgraph.findBiggestindex(differenceGraph),thisgraph.findLowestindex(differenceGraph), amountathigh);
            differenceGraph[thisgraph.findLowestindex(differenceGraph)] = amountatlow + amountathigh;
            differenceGraph[thisgraph.findBiggestindex(differenceGraph)] = 0;

            amountatlow = differenceGraph[thisgraph.findLowestindex(differenceGraph)];
            amountathigh = differenceGraph[thisgraph.findBiggestindex(differenceGraph)];
            moneyUsed = moneyUsed + amountathigh;
        }

        System.out.println("Containers return to their origin at minimum cost: ");
        newgraph.printGraph();
        System.out.println("Total Costs using this algorithm: " + moneyUsed);
    }
}