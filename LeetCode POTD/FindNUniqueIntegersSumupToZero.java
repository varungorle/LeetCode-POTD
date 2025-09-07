public class FindNUniqueIntegersSumupToZero 
{
    public static int[] sumZero(int n) 
    {
        int[] result = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) 
        {
            result[index++] = -i;
            result[index++] = i;
        }
        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }
    public static void printArray(int[] arr) 
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) 
    {
        int n = 5;
        int[] arr = sumZero(n);

        System.out.println("Array of " + n + " unique integers that sum to 0:");
        printArray(arr);
    }
}
