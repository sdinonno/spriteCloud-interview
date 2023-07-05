package models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import util.Helper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    //First approach, should improve it in order to accomplish scalability
    public User(){
        this.id = 100;
        this.username = Helper.generateRandomText(10);
        this.firstName = Helper.generateRandomText(6);
        this.lastName = Helper.generateRandomText(8);
        this.email = this.firstName +this.lastName + "@mail.com";
        this.password = Helper.generateRandomText(12);
        this.phone = String.valueOf(54545454);
        this.userStatus = 3;
    }

    //Create all getters, setters, etc and delete all the login from the constructor.
}


