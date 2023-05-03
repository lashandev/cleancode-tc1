package com.epic.techtalk;

import com.epic.techtalk.util.DBUtil;

import java.sql.ResultSet;

public class DataInserter {
    public static void main(String[] args) {
        try {
            int x = 485853;
            int i = 0;
            while (i < 11) {
                ResultSet rs = DBUtil.search("select nic from employee");
                while (rs.next()) {
                    DBUtil.iud("INSERT INTO `mixfruit`.`employee`(`id`, `nic`) VALUES ('" + (++x) + "', '" + rs.getString("nic") + "')");
                }
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
