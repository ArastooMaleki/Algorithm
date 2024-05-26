import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AlgorithmAnalysis {
    public static void main(String[] args ){

        try {
            int N = 0 ;
            long tic = 0 ;
            long toc = 0 ;
            BufferedWriter bw  = new BufferedWriter(new FileWriter("ThreeSumRuntime.txt"));
            BufferedWriter bw2  = new BufferedWriter(new FileWriter("ThreeSumDeluxeRuntime.txt"));
            for (int i = 1 ; i < 21 ; i++) {
                N = 1000 * i ;
                int[] arr = IntStream.generate(()->new Random().nextInt(100)).limit(N).toArray();
                Arrays.sort(arr , 0 , N);
                tic = System.nanoTime();
                threeSum(arr);
                toc = System.nanoTime();
                bw.write(N+" "+(toc-tic)+"\n");
                tic = System.nanoTime();
                threeSumDeluxe(arr);
                toc = System.nanoTime();
                bw2.write(N+" "+(toc-tic)+"\n");
                System.out.println(N+" "+(toc-tic)+"\n");
            }
            bw2.close();
            bw.close();
        }
        catch(Exception e){System.out.println("writing file error");}
    }
    public static int binary_search(int[] array , int key){
        int low = 0 ;
        int high = array.length -1 ;
        while (low<=high){
            int mid = low +(high - low )/2;
            int midword = array[mid] ;
            if (key< midword) high = mid -1 ;
            else if (key>midword) low = mid +1 ;
            else return  mid ;
        }
        return -1 ;

    }

    public int binarySearch_recursive(int arr[], int low, int high, int x)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch_recursive(arr, low, mid - 1, x);

            return binarySearch_recursive(arr, mid + 1, high, x);
        }

        return -1;
    }

    public static void threeSum(int[] arr){
        for (int i = 0 ; i<arr.length ; i++){
            for (int j = i+1 ; j<arr.length ; j++){
                for (int k = j+1 ; k<arr.length ; k++){
//                    if (arr[i] + arr[j]+arr[k] == 0 ){
//                        //for analysis purpose we make this a comment
//                        //System.out.println("" + arr[i] + arr[j] + arr[k]+);
//                    }
                }
            }
        }
    }

    public static void threeSumDeluxe(int[]arr){
        for (int i = 0 ; i<arr.length ; i++){
            for (int j = i+1 ; j<arr.length ;j++){
                int index = binary_search(arr,(-arr[i]-arr[j]));
//                if (index != -1 ){
//                    //for analysis purpose we make this a comment
//                    //System.out.println(arr[i]+" "+arr[j]+" "+arr[index]);
//                }
            }
        }

    }
}

