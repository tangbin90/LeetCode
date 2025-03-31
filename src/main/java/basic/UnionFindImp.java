package basic;

public class UnionFindImp implements UnionFind {
    private int count;

    private int[] parent;

    private int[] size;

    public UnionFindImp(int count){
        this.count = count;
        parent = new int[count];
        for(int i=0; i< count; i++){
            parent[i] = i;
            size[i] = 1;
        }

    }
    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootQ == rootP)
            return;

        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] +=size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    private int find(int x){
        while(parent[x] != x)
            x = parent[x];

        return x;
    }

    private int find2(int x){
        while(parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
