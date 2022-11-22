public class Matrixgraph {

    /*
    Create two matrices containing the edges and weights of the vertices.
     */
    int [][] matrixedgegraph;
    int [][] matrixweightgraph;

    Matrixgraph(int vertices){
        matrixedgegraph = new int [vertices][vertices];
        matrixweightgraph = new int [vertices][vertices];
    }

    public void addEdge (int from, int to, int weight){
        matrixedgegraph[from][to]=1;
        matrixweightgraph[from][to]=weight;
    }
    /*
    Method for printing the graph
     */
    public void printGraph (){
        for (int fromi = 0; fromi< matrixedgegraph.length; fromi ++){
            System.out.println("Edge from vertex "+ fromi);
            for (int toj =0; toj< matrixedgegraph.length; toj ++){
                if (matrixedgegraph[fromi][toj]==1){
                    System.out.print(" to " + toj +": ");
                    System.out.println(" weight " + matrixweightgraph[fromi][toj]);
                }
            }
            System.out.println();
        }
    }
/*
Method for finding the index of the biggest number in a given list
 */
    public int findBiggestindex (int[] list) {
        int biggest = 0;
        int index = 0;
        for (int i = 0; i < list.length; i++){
            if (biggest == 0 || biggest < list[i]){
                biggest = list[i];
                index = i;
            }
        } return index;
    }
    /*
Method for finding the index of the lowest number in a given list
 */
    public int findLowestindex (int[] list) {
        int lowest = 0;
        int index = 0;
        for (int i = 0; i < list.length; i++){
            if (lowest == 0 || lowest > list[i]){
                lowest = list[i];
                index = i;
            }
        } return index;
    }
}
