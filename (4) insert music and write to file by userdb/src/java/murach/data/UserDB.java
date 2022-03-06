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
public class UserDB {
    private User user;
    public static void insert(User user,String path) throws IOException{
        String ans="";
        ans+=user.getEmail()+"|"+user.getFirstName()+"|"+user.getLastName()+"|";
        for(String tmp:user.getMusic()){
            ans+=tmp+",";
        }
        ans+="\n";
        FileWriter fw = new FileWriter(path,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ans);
        bw.close();
    }
}
