import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Assignment12_15 {

    public static void main(String[] args) throws Exception{
        String filepath = "Exercise12_15.txt";
        File text = new File(filepath);
        
        if(!text.isFile()){
            try(PrintWriter integers = new PrintWriter(filepath)){
                Random rand = new Random();
                for(int i = 1;i<=100;i++){
                    integers.print(rand.nextInt(101) + " ");
                }
                integers.close();
            }
            catch(FileNotFoundException e){
                
            }
        }
        Scanner reader = new Scanner(text);
        String content = reader.nextLine();
        
        String intBuild = "";
        int[] contents = new int[100];
        int arrayCount = 0;
        for(int i = 0;i<content.length();i++){
            if(content.charAt(i) != ' '){
                intBuild += content.charAt(i);
            }
            else{
                contents[arrayCount] = Integer.parseInt(intBuild);
                arrayCount++;
                intBuild = "";
            }
            
        }
        Arrays.sort(contents);
        for(int i = 1;i<=100;i++){
            System.out.print(contents[i-1] + " ");
            if(i%5 == 0){
                System.out.print("\n");
            }
        }
        reader.close();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Erase file to reset numbers next time?"
                + "\nType (1) to confirm\nAny other number to quit");
        if(scan.nextInt() == 1){
            text.delete();
        }
    }
}