package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
/*        int x = 2;
        x = (x++) + (++x) + x + 1;
        System.out.println(x);*/
        Map<String, String> m = new HashMap<>();
        m.put("name", null );
        m.put("country", "Ukraine");
        m.put("age", null);
        System.out.println(getCondition(m));
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> map : params.entrySet()) {
            if (map.getKey() != null)
                if (map.getValue() != null) {
                    if (sb.length() > 0) sb.append(" and ");
                    sb.append(map.getKey()).append(" = ").append("\'").append(map.getValue()).append("\'");
                }
        }
        return sb;
    }
}
