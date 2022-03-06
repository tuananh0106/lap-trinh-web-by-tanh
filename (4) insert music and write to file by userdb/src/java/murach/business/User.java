package murach.business;
import java.io.Serializable;
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String education;
    private String music[];
    public User() {
        firstName = "";
        lastName = "";
        email = "";
        sex = "";
        education= "";
    }

    public User(String firstName, String lastName, String email,String sex, String education,String music[]) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.education = education;
        this.music = music;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String[] getMusic() {
        return music;
    }

    public void setMusic(String[] music) {
        this.music = music;
    }
    
}
