/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.PenyewaanHelper;
import java.util.List;
import pojos.Penyewaan;

/**
 *
 * @author danielbram
 */
public class testPenyewaan {
    public static void main(String[] args) {
         PenyewaanHelper test = new PenyewaanHelper();
        List<Penyewaan> list = test.getAllPenyewaan();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
