package algs;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int components;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        components = N;
    }

    public int find(int p){
        while(p != id[p]){
            //One line code to implement path compression
            //one pass
            //pointing current node to its grandparent node
            //make the tree almost flat
            id[p] = id[id[p]];

            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return components;
    }

    public void weightedQuickUnion(int p, int q){
        if(isConnected(p,q)){
            return;
        }
        int pRoot = find(p);
        int qRoot = find(q);
        if(sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

}
