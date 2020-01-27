import java.util.Scanner;

public class TrafficLights {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();
        int lightCount = in.nextInt();
        int[][] input = new int[lightCount][2];
        for (int i = 0; i < lightCount; i++) {
             input[i][0] = in.nextInt() * 18;
             input[i][1] = in.nextInt();
        }
        while(speed > 0){
            int speedInMS = speed * 5 ;
            boolean valid = true;
            for (int i = 0; i < lightCount; i++) {
                int distance = input[i][0];
                int duration = input[i][1];
                int miniDistance = duration*speedInMS;
                if (!(distance == 0 || (distance/miniDistance % 2 == 0))){
                    valid=false;
                    break;
                }
            }
            if (valid){
                System.out.println(speed);
                break;
            }
            speed--;
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

//        System.out.println("answer");
    }
}
