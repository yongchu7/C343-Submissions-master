import java.net.URL;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.*;


public class search {
    public static void main(String[] args){
        Hashtable search = new Hashtable();
        Integer line = 1;
        try {
            URL url = new URL("http://homes.soic.indiana.edu/classes/spring2016/csci/c343-yye/docu.txt");
            Scanner read = new Scanner(url.openStream());

            while (read.hasNextLine()) {
                String str = read.nextLine();
                String[] word = str.split("\\s");
                for (String s :word){
                    if(search.containsKey(s)){
                        ArrayList<Integer> ls = new ArrayList();
                        ls = (ArrayList<Integer>)search.get(s);
                        if(! ls.contains(line)){
                            ls.add(line);
                        }

                    }
                    else{
                        ArrayList<Integer> ls1 = new ArrayList();
                        ls1.add(line);
                        search.put(s, ls1);
                        }
                    }
                line++;
                    }
            read.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("error");
        }
        System.out.println(search.toString());
    }
}
