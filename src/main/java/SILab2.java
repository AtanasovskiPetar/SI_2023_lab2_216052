import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //1
            throw new RuntimeException("Mandatory information missing!"); //2
        } //3

        if (user.getUsername()==null){ //4
            user.setUsername(user.getEmail()); //5
        } //6

        int same = 1; //7
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //8
            same = 0; //9
            for (int i=0;i<allUsers.size();i++) { //10
                User existingUser = allUsers.get(i); //11
                if (existingUser.getEmail() == user.getEmail()) { //12
                    same += 1; //13
                } //14
                if (existingUser.getUsername() == user.getUsername()) { //15
                    same += 1; //16
                } //17
            } //18
        } //19

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //20
        String password = user.getPassword(); //20
        String passwordLower = password.toLowerCase(); //20

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //21
            return false; //22
        } //23
        else { //24
            if (!passwordLower.contains(" ")) { //25
                for (int i = 0; i < specialCharacters.length(); i++) { //26
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //27
                        return same == 0; //28
                    } //29
                } //30
            } //31
        } //32
        return false; //33
    } //34

}
