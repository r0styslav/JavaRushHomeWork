package com.javarush.test.level20.lesson02.task02;

import com.javarush.test.level20.lesson02.task02.User.Country;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            //remove this


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Rost");
            user.setLastName("Last");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(Country.UKRAINE);
            javaRush.users.add(user);
            System.out.println(user);
            //================================================================
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.get(0));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            for (User u : users) {
                pw.println(u.getFirstName());
                pw.println(u.getLastName());
                pw.println(u.getBirthDate().getTime());
                pw.println(u.isMale());
                pw.println(u.getCountry());
            }
            pw.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready()) {
                User u = new User();
                u.setFirstName(br.readLine());
                u.setLastName(br.readLine());
                u.setBirthDate(new Date(Long.parseLong(br.readLine())));
                u.setMale(Boolean.parseBoolean(br.readLine()));
                u.setCountry(User.Country.valueOf(br.readLine()));
                users.add(u);
            }
        }
    }
}
