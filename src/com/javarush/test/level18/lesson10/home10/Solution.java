package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputBuffer;
        String line;
        String fileOutputName = null;
        Set<String> fileSet = new TreeSet<>();
        // Read all file names from console ans store
        while (!(line = br.readLine()).equals("end")) {
            fileSet.add(line);
            if (fileOutputName == null) {
                Pattern p = Pattern.compile("(.+)(\\.part\\d+)$");
                Matcher m = p.matcher(line);
                m.matches();
                fileOutputName = m.group(1);
            }
        }
        // Create new file
        FileOutputStream fileOutput = new FileOutputStream(new File(fileOutputName));
        outputBuffer = new BufferedWriter(new FileWriter(fileOutputName));
        // Write info into the new file fileOutput
        for (String file :
                fileSet) {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                outputBuffer.write(line);
            }
        }
        // close streams
        fileOutput.close();
        br.close();
        outputBuffer.close();
    }
}
