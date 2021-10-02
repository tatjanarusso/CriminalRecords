package com.example.criminalrecords;

public class login {
    public static String check(String username, String pw, String logtxt){
        //Login data for each user
        //police
        String userpolice = "police";
        String pwpolice = "police1";

        //civil
        String usercivil = "civil";
        String pwcivil = "civil1";

        //prison
        String userprison = "prison";
        String pwprison = "prison1";

        //

        //checking users
        if (userpolice.equals(username) && pwpolice.equals(pw)) {
            logtxt = "Police user logging in.";

        }
        else if(usercivil.equals(username) && pwcivil.equals(pw)) {
            logtxt = "Civil user logging in.";

        }
        else if (userprison.equals(username) && pwprison.equals(pw)){
            logtxt = "Prison user logging in.";

        }
        else {
            System.out.println("Wrong username or/and password");
        }
       return logtxt;
    }
}
