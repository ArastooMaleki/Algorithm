import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DynamicConnectivity {
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new FileReader("Un.txt"));
            int N = sc.nextInt();
            WeightedQuickUnionPathCompression qf = new WeightedQuickUnionPathCompression(N);
            while(sc.hasNext()){
                int f = sc.nextInt();
                int l = sc.nextInt();
                qf.union(f,l);

            }
            for (int i :qf.id){
                System.out.println(i);
            }
        }catch(Exception e){e.printStackTrace();}


    }
}
class UnionFind{
    int[] id;
    int N;
    public UnionFind(){}
    public UnionFind(int N){
        this.N = N ;
        id = IntStream.range(0,N).toArray();
    }
    public int find(int i){
        return id[i] ;// this should be overrided
    }
    public void union(int i , int j){
        System.out.println("primary union");
    }
    public boolean connected(int i , int j ){
        return id[i]==id[j];
    }
}
class QuickFind extends UnionFind{
    public QuickFind(int N){
        super(N);
    }
    @Override
    public void union(int i , int j ){
        for (int k = 0 ; k<N ;k++){
            if (id[k]==id[j]){
                id[k] = id[i];
            }
        }
    }
}
class QuickUnion extends UnionFind{
    public QuickUnion(){}
    public QuickUnion(int N){
        super(N);
    }
    @Override
    public int find(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i ;
    }
    @Override
    public boolean connected(int i, int j){
        return find(i)==find(j);
    }
    @Override
    public void union(int i , int j){
        int firstRoot = find(i);
        int secondRoot = find(j);
        id[secondRoot] = firstRoot;
    }
}

class WeightedQuickUnion extends QuickUnion{
    public int[] size ;
    public WeightedQuickUnion(){}
    public WeightedQuickUnion(int N){
        super(N);
        size = new int[N];
        Arrays.fill(size,1);
    }
    @Override
    public void union(int i, int j){
        int firstRoot = find(i);
        int secondRoot = find(j);
        if (size[firstRoot]>=size[secondRoot]){
            size[firstRoot]++;
            id[secondRoot] = firstRoot;
        }else{
            size[secondRoot]++;
            id[firstRoot] = secondRoot;
        }
    }
}
class PathCompressionQuickUnion extends QuickUnion{
    public PathCompressionQuickUnion(int N){
        super(N);
    }
    @Override
    public int find(int i){
        while (i != id[i]){
            id[i] = id[id[i]] ;
            i = id[i];
        }
        return i ;
    }
}

class WeightedQuickUnionPathCompression extends WeightedQuickUnion{
    public WeightedQuickUnionPathCompression(int N){
        super(N);
    }
    @Override
    public int find(int i){
        while (i != id[i]){
            id[i] = id[id[i]] ;
            i = id[i];
        }
        return i ;
    }

}