package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        while (!fileName.equals("exit")) {
            new ReadThread(fileName).start();
            fileName = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                Map<Integer, Integer> fileEntry = new HashMap<>();

                while (inputStream.available() > 0) {
                    Integer currentByte = inputStream.read();
                    if (fileEntry.containsKey(currentByte))
                        fileEntry.put(currentByte, fileEntry.get(currentByte) + 1);
                    else fileEntry.put(currentByte, 1);
                }

                Integer maxValue = Collections.max(fileEntry.values());

                for (Map.Entry<Integer, Integer> map :
                        fileEntry.entrySet()) {
                    if (maxValue == map.getValue()) {
                        resultMap.put(fileName, map.getKey());
                    }
                }

                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
