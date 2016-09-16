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
        Map<String, String> m = new HashMap<>();
        m.put("name", "Ivanov");
        m.put("country", "Ukraine");
        m.put("age", null);
        System.out.println(getCondition(m));
    }
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> map : params.entrySet()) {
            if (map.getValue() != null) {
                sb.append(map.getKey()).append(" = ").append("\'").append(map.getValue()).append("\'").append(" and ");
            }
        }
        sb.setLength(sb.length() - 5);
        return sb;
    }
}
