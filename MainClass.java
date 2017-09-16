import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
public static void main(String[] args){
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int testCasesCount = Integer.parseInt(firstLine);
        for(int i = 0; i < testCasesCount; i++){
            int arrayLength = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();
            String[] arrayStrArr = arrayStr.split(" ");
            int[] arr = new int[arrayLength];
            for(int j = 0; j < arrayLength; j++){
                arr[j] = Integer.parseInt(arrayStrArr[j]);
            }

            int min = arr[0];
            for(int j = 0; j < arrayLength; j++){
                if(min > suffixSum(j, arr) + prefixSum(j, arr)){
                    min = suffixSum(j, arr) + prefixSum(j, arr);
                }
            }
            System.out.println(min+1);
        }
    } catch(IOException e){
        e.printStackTrace();
    }
}

private static Integer suffixSum(int beginPos,int[] arr){
    int sum = 0;
    for(int i = beginPos; i < arr.length; i++){
        sum += arr[i];
    }
    return sum;
}

private static Integer prefixSum(int beginPos, int[] arr){
    int sum = 0;
    for(int i = 0; i < beginPos; i++){
        sum += arr[i];
    }
    return sum;
}
}