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
        String file1 = reader.readLine();
        //String file1 = "c:\\1.txt";
        String file2 = reader.readLine();
        //String file2 = "c:\\2.txt";
        ArrayList<String> file1Lines = new ArrayList<>();
        ArrayList<String> file2Lines = new ArrayList<>();
        ArrayList<String> SAME = new ArrayList<>();
        ArrayList<String> ADDED = new ArrayList<>();
        ArrayList<String> REMOVED = new ArrayList<>();

        reader.close();
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        while (br1.ready()) {
            file1Lines.add(br1.readLine());
        }
        while (br2.ready()) {
            file2Lines.add(br2.readLine());
        }
        for (int i = 0; i < file1Lines.size(); i++) {
            for (int j = 0; j < file1Lines.size(); j++) {
                if (file1Lines.contains(file2Lines.get(j))) {
                    //if (!SAME.contains(file2Lines.get(j)))
                        SAME.add(file2Lines.get(j));
                    file2Lines.remove(j);
                } else if (!file2Lines.contains(file1Lines.get(i))) {
                    if (!REMOVED.contains(file1Lines.get(i)))
                        REMOVED.add(file1Lines.get(i));
                } else if (!file1Lines.contains(file2Lines.get(j))) {
                    if (!ADDED.contains(file2Lines.get(j)))
                        ADDED.add(file2Lines.get(j));
                }
            }

        }

        int max = Math.max(SAME.size(), Math.max(REMOVED.size(), ADDED.size()));
        for (int i = 0; i < max; i++) {
            if (!ADDED.isEmpty()) {
                lines.add(new LineItem(Type.ADDED, ADDED.get(0)));
                ADDED.remove(0);
            }

            if (!SAME.isEmpty()) {
                lines.add(new LineItem(Type.SAME, SAME.get(0)));
                SAME.remove(0);
            }

            if (!REMOVED.isEmpty()) {
                lines.add(new LineItem(Type.REMOVED, REMOVED.get(0)));
                REMOVED.remove(0);
            }

            if (!SAME.isEmpty()) {
                lines.add(new LineItem(Type.SAME, SAME.get(0)));
                SAME.remove(0);
            }

        }
/*
        for (LineItem li : lines) {
            System.out.println(li);
        }
        System.out.println();*/

        reader.close();
        br1.close();
        br2.close();
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
            return "Type: " + type + " line: " + line;
        }
    }

}
