package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants {
        public static final String ACCESS = "Server is not accessible for now.";
        public static final String AUTHORIZATION = "User is not authorized.";
        public static final String BAN = "User is banned.";
        public static final String DENIED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.ACCESS);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.ACCESS, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.AUTHORIZATION);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.AUTHORIZATION, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BAN);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BAN, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.DENIED, cause);
        }
    }
}
