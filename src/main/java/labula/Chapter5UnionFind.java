package labula;

public class Chapter5UnionFind {
    private int count;

    private int[] parent;

    private int[] size;

    public Chapter5UnionFind(int n){
        this.count = n;
        size = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootQ==rootP)
            return;
        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean connected(int p, int q){
        int rootP= find(p);
        int rootQ = find(q);
        return  rootQ==rootP;
    }

    public int find(int p){
        while(parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
