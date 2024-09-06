import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class WordProgram{
    public static void main(String []args) throws FileNotFoundException, IOException{
         HashMap<String,String> map = new HashMap<>();
        String splitedStr[]=null;
        try{
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader("/Users/kimwoohee/nhn_ps/lec/WordProgram/words.txt"));
            String line;
       
            while((line=reader.readLine())!=null){
               line = line.trim();
                splitedStr = line.split("\\.");
                line = splitedStr[1];
                String word = new String();
                String value = new String();

                for(int i=0;i<line.length();i++){
                    if(line.charAt(i)>='a' && line.charAt(i)<='z'){
                        word+=line.charAt(i);
                    }else{
                        value+=line.charAt(i);
                    }
                }
                map.put(word,value.trim());
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("write a word: ");
            String find = sc.nextLine();
            System.out.println(map.get(find));
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found!");
        }
    }
}