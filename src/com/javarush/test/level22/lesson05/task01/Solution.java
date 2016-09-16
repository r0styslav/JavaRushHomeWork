
package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(""));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException("Incorrect string: too short");
        StringBuilder result = new StringBuilder();
        String arr[] = string.split(" ");
        if (arr.length < 5) throw new TooShortStringException("Incorrect string: too short");
        for (int i = 1; i < 5; i++) {
            result.append(arr[i] + " ");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    public static class TooShortStringException extends Throwable {
        public TooShortStringException() {
        }

        public TooShortStringException(String message) {
            super(message);
        }
    }
}
