package guru.springframework.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);

        // declaring and initializing 2D array
        int arr[][] = { {2,7,9},{3,6,1},{7,4,2},{8,9,7} };

        // printing 2D array
        for (int i=0; i< 4 ; i++)
        {
            for (int j=0; j < 3 ; j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }

        int array[] = {3, 1, 2, 5, 4};
        sum(array);
    }

    public static void sum(int[] arr){
        int sum = 0;
        for(int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println("Sum of Array Values = "+ sum);
    }
}
