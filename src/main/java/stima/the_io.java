package stima;

import java.io.File;
import java.util.Scanner;

public class the_io {

    public static matrix read_file(String source) throws Exception{
        File file = new File(source);
        Scanner sc = new Scanner(file);
        int i=0;
        int j=0;
        String line;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            if (j==0){
                j=line.length();
            }
            i++;
        }
        matrix mat = new matrix(i, j);
        sc.close();
        Scanner scr = new Scanner(file);
        int l=0;
        while(scr.hasNextLine()){
            line = scr.nextLine();
            for(int k=0;k<j;k++){
                mat.data[l][k]=line.charAt(k);
            }
            l++;
        }
        scr.close();
        return mat;
    }
}
