package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(file);
        prop.load(input);
        input.close();
        Enumeration names = prop.propertyNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement().toString();
            properties.put(key, prop.getProperty(key));
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String, String> m : properties.entrySet()) {
            prop.setProperty(m.getKey(), m.getValue());
        }
        prop.save(outputStream, null);
        /*PrintWriter pw = new PrintWriter(outputStream);
        for (Map.Entry<String, String> m : properties.entrySet() ) {
            pw.println(m.getKey() + " " + m.getValue());
        }
        pw.close();*/
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration names = prop.propertyNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement().toString();
            properties.put(key, prop.getProperty(key));
        }
        /*BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line[];
        while (br.ready()) {
            line = br.readLine().split(" ");
            properties.put(line[0], line[1]);
        }
        br.close();*/
    }

   /* public static void main(String[] args) throws Exception {
        File file = new File("C:\\!Work\\test.properties");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(file);
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        System.out.println(solution);
        solution.save(os);
        Solution solutionAfterLoad = new Solution();
        solutionAfterLoad.load(is);
        System.out.println(solutionAfterLoad);

    }

    @Override
    public String toString() {
        for (Map.Entry<String, String> m : properties.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        return "";
    }*/
}
