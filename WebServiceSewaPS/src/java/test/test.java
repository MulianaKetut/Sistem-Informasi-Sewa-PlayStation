/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.PenyewaanHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Afra Rian
 */
public class test {
    public static void main(String[] args) throws ParseException {
        PenyewaanHelper test = new PenyewaanHelper();
        String date = "20181111";     
//        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        test.searchBulan(Integer.parseInt(date));
    }
}
