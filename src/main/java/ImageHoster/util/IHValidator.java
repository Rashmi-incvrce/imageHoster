package ImageHoster.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IHValidator {

    private static IHValidator ihValidator;

    private IHValidator(){

    }

    public static IHValidator getIHValidatorInstance(){
        if(ihValidator == null)
            ihValidator = new IHValidator();
        return ihValidator;
    }


    //Method to validate password strength
    //Returns true if Password contains at least 1 alphabet, 1 number & 1 special character
    //Else returns false
    public boolean validatePassword(String password){
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&].{3,}$";

        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);

        return m.matches();
    }
}
