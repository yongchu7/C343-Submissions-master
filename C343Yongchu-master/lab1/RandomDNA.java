import java.util.Random;
public class RandomDNA{
    public static void main(String []args){
        String s = new String();
        Random rnd = new Random();
        for (int i = 0;i<= 20;i++){
          int t = rnd.nextInt(4);
            if(t == 0){
                s = s +"A";
            }
            if(t == 1){
                s = s +"T";
            }
            if(t == 2){
                s = s +"C";
            }
            if(t == 3){
                s = s +"G";
            }
}
        System.out.print(s);
    }
}
