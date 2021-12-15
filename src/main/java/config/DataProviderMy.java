package config;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderMy {

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("telranrk25@gmail.com").password("Tlrk12345$").build()});
        list.add(new Object[]{Auth.builder().email("telranrk25@gmail.com").password("Tlrk12345$").build()});
        list.add(new Object[]{Auth.builder().email("telranrk@gmail.com").password("Tlrk12345$").build()});


        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> loginDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/logindata.csv")));

    String line = reader.readLine();
    while (line!=null){
        String [] split = line.split(",");
        list.add(new Object[]{Auth.builder().email(split[0]).password(split[1]).build()});
        line = reader.readLine();
    }

        return list.iterator();

    }
}
