package algs;

public class QuickUnionUF {
    private int[] id;
    private int components;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        components = N;
    }

    public int count() {
        return components;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void quickUnion(int p, int q){
        if(!isConnected(p,q)){
            int pRoot = find(p);
            int qRoot = find(q);
            id[pRoot] = qRoot;
            components--;
        }
    }
}
