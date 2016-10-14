package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Rostyslav.Pash on 20.09.2016.
 */
/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class LoggingStateThread extends Thread {
    private Thread t;

    public LoggingStateThread(Thread t) {
        this.t = t;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = t.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != t.getState()) {
                state = t.getState();
                System.out.println(state);
            }
        }
    }
}

