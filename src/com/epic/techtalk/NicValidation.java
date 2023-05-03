package com.epic.techtalk;

import com.epic.techtalk.util.DBUtil;

import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicValidation {

    public boolean validate(String nic){
        if (nic != null){
            if (nic.length() == 10){
                String regex = "[0-9VX]{10}";
                Pattern pattern = Pattern.compile(regex);

                Matcher matcherText = pattern.matcher(nic);

                Boolean textMatches = matcherText.matches();
                if (textMatches){
                    return false;
                }else {
                    return true;
                }
            } else {
                if (nic.length() == 12){
                    String regex = ".*[a-zA-Z].*";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcherText = pattern.matcher(nic);
                    Boolean textMatches = matcherText.matches();
                    if (textMatches){
                        return false;
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
class AppRunner{
    public static void main(String[] args) {
        try {
            ResultSet search = DBUtil.search("select * from employee");
            long startTime = System.currentTimeMillis();
            NicValidation nicValidation = new NicValidation();
            while (search.next()) {
                boolean validate = nicValidation.validate(search.getString("nic"));
               // System.out.println(validate);

            }
                long endTime = System.currentTimeMillis();
                System.out.println("That took " + (endTime - startTime) + " milliseconds");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
