package algs;

public class QuickFindUF {
    private int[] id;
    private int components;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        components = N;
    }

    public int quickFind(int p){
        return 0;
    }

    public boolean isConnected(int p, int q){
        return false;

    }

    public void union(int p, int q){

    }

    public int count(){
        return components;
    }

}
