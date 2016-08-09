package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        //String f1 = "c:\\1.txt";
        String f2 = reader.readLine();
        //String f2 = "c:\\2.txt";
        ArrayList<String> file1Lines = new ArrayList<>();
        ArrayList<String> file2Lines = new ArrayList<>();

        reader.close();
        BufferedReader br1 = new BufferedReader(new FileReader(f1));
        BufferedReader br2 = new BufferedReader(new FileReader(f2));
        while (br1.ready()) {
            file1Lines.add(br1.readLine());
        }
        while (br2.ready()) {
            file2Lines.add(br2.readLine());
        }
        int max = Math.max(file1Lines.size(), file2Lines.size());
        for (int i = 0; i < max; i++) {
            if (!file1Lines.isEmpty()) {
                // SAME: when line1[0] == line2[0]
                if (!file2Lines.isEmpty() && file1Lines.get(0).equals(file2Lines.get(0))) {
                    sameLines(file1Lines, file2Lines);
                } else
                    // ADDED: when line1[0] != line2[0] but
                    // SAME: line1[0] == lien2[1]
                    if ((file2Lines.size() > 1) && file1Lines.get(0).equals(file2Lines.get(1))) {
                        addLine(file2Lines);
                        i--;
                    } else {
                        // REMOVED: when line1[0] != line2[0] != line2[1]
                        removeLine(file1Lines);
                    }
            } else if (file1Lines.isEmpty() && !file2Lines.isEmpty()) {
                addLine(file2Lines);
            }
        }
/*
        for (LineItem li : lines) {
            System.out.println(li);
        }*/
        reader.close();
        br1.close();
        br2.close();
    }

    private static void removeLine(ArrayList<String> line1) {
        lines.add(new LineItem(Type.REMOVED, line1.get(0)));
        line1.remove(0);
    }

    private static void addLine(ArrayList<String> line2) {
        lines.add(new LineItem(Type.ADDED, line2.get(0)));
        line2.remove(0);
    }

    private static void sameLines(ArrayList<String> line1, ArrayList<String> line2) {
        lines.add(new LineItem(Type.SAME, line1.get(0)));
        line1.remove(0);
        line2.remove(0);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }

}
