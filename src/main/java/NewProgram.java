import java.util.Arrays;

public class NewProgram {


    public static void main(String[] args) {
        
        // arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
        // Output: 3 4 5 6 7 1 2        

        int arr[]={1, 2, 3, 4, 5, 6, 7};
        int d=2;
        System.out.println(Arrays.toString(programOut(arr,d)));
    }

    public static int[] programOut(int arr[],int d){
        while(d>0){
            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++){              
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=temp;
            d--;
        }
        System.out.println(Arrays.toString(arr));

    return arr;
    }
}
