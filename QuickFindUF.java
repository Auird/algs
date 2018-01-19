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
        return id[p];
    }

    public boolean isConnected(int p, int q){
        return quickFind(p) == quickFind(q);
    }

    public void union(int p, int q){
        if(!isConnected(p , q)){
            int pId = quickFind(p);
            int qId = quickFind(q);
            for(int i = 0; i < id.length; i++){
                if(quickFind(i) == pId){
                    id[i] = qId;
                }
            }
            components--;
        }
    }

    public int count(){
        return components;
    }

}
