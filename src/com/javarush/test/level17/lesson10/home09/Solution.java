package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public void joinData () throws CorruptedDataException {
        for (String str :
                forRemoveLines) {
            if (allLines.contains(str)) {
                allLines.remove(str);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }



    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String path1, path2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            path1 = br.readLine();
            path2 = br.readLine();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path1)));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(path2)));
            String line;
            while ((line = reader1.readLine()) != null) {
                allLines.add(line);
            }
            while ((line = reader2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            br.close();
            reader1.close();
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }


}
