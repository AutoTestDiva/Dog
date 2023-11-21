package org.nat.dog.utils;

import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders { //этот класс с методами позволяет добавлять данные из таблицы, созданного мной файла, в котором хранятся данные для подставки в тест
    @DataProvider
    public Iterator<Object[]> positiveLoginDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/positiveLogin.csv")));//достаем данные из файла и добавляем их  в лист
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeLoginDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/negativeLogin.csv")));//достаем данные из файла и добавляем их  в лист
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> positiveRegistrationDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/positiveRegistration.csv")));//достаем данные из файла и добавляем их  в лист
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeRegistrationDataFormCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/negativeRegistration.csv")));//достаем данные из файла и добавляем их  в лист
        String line = reader.readLine();
        while (line !=null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }
}
