package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File test = new File("C:\\!Work\\test.txt");
            OutputStream outputStream = new FileOutputStream(test);
            InputStream inputStream = new FileInputStream(test);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();
            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.name + " - " + ivanov.name);
            System.out.println(somePerson.assets.size() + " - " + ivanov.assets.size());
            System.out.println(somePerson.assets.get(0).getName() + " - " + ivanov.assets.get(0).getName());
            System.out.println(somePerson.assets.get(1).getName() + " - " + ivanov.assets.get(1).getName());
            inputStream.close();


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println(name);
            System.out.println(name);
            for (Asset a : assets) {
                System.out.println(a.getName());
                pw.println(a.getName());
                pw.println(a.getPrice());
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            name = br.readLine();
            System.out.println(name);
            while (br.ready()) {
                String asset = br.readLine();
                Double d = Double.parseDouble(br.readLine());
                Asset a = new Asset(asset);
                a.setPrice(d);
                assets.add(a);
                System.out.println(asset);
            }
        }
    }
}
