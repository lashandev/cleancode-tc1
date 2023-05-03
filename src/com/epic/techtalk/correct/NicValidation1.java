package com.epic.techtalk.correct;

import com.epic.techtalk.NicValidation;
import com.epic.techtalk.util.DBUtil;

import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicValidation1 {
    public boolean isValid(String nic) {
        if (nic == null || nic.trim().isEmpty()) {
            return false;
        }
        return validateOldNic(nic) || validateNewNic(nic);
    }

    private boolean validateOldNic(String nic) {
        if (nic.length() != 10) {
            return false;
        }
        return nic.matches("[0-9VX]{10}");
    }

    private boolean validateNewNic(String nic) {
        if (nic.length() != 12) {
            return false;
        }
        return nic.matches("[0-9]{12}");
    }
}

class AppRunner{
    public static void main(String[] args) {
        try {
            ResultSet search = DBUtil.search("select * from employee");
            long startTime = System.currentTimeMillis();
            NicValidation1 nicValidation = new NicValidation1();
            while (search.next()) {
                boolean validate = nicValidation.isValid(search.getString("nic"));
                //System.out.println(validate);

            }
            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
