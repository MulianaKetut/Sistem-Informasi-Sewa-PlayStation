/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.PlaystationHelper;
import java.util.List;
import pojos.Playstation;

/**
 *
 * @author danielbram
 */
public class testPlaystation {
    public static void main(String[] args) {
         PlaystationHelper test = new PlaystationHelper();
        List<Playstation> list = test.getAllPlaystation();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
