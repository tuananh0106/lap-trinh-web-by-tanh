/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

/**
 *
 * @author admin
 */
import murach.business.User;
import java.io.*;
import java.util.Scanner;
public class UserDB {
    private User user;
    public static void insert(User user,String path) throws IOException{
        String ans="";
        ans+=user.getEmail()+"|"+user.getFirstName()+"|"+user.getLastName();
        ans+="\n";
        FileWriter fw = new FileWriter(path,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ans);
        bw.close();
    }
    public static boolean emailExisted(String email,String path) throws FileNotFoundException{
        Scanner sc=new Scanner(new File(path));
        while(sc.hasNextLine()){
            String tmp=sc.nextLine().split("\\|")[0];
            if(tmp.equals(email)) return true;
        }
        return false;
    }
}
