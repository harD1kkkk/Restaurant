package com.menu;

public final class PrintManager {
    private PrintManager() {
    }

    public static void printOption() {
        System.out.println("Виберіть опцію: ");
        System.out.println("1. Додати страву до замовлення");
        System.out.println("2. Видалити страву з замовлення");
        System.out.println("3. Показати замовлення");
        System.out.println("4. Розрахувати суму замовлення");
        System.out.println("5. Вибрати знижку(встановити свою знижку)");
        System.out.println("6. Вийти(неможна)");
    }

    public static void printMenu() {
        System.out.println("Виберіть страву: ");
        System.out.println("1. Яблуко");
        System.out.println("2. Банан");
        System.out.println("3. Апельсин");
        System.out.println("4. Полуниця");
        System.out.println("5. М'ясо");
        System.out.println("6. Курка");
        System.out.println("7. Картопля");
        System.out.println("8. Риба");
        System.out.println("9. Рис");
        System.out.println("10. Салат");
        System.out.println("11. Суп");
        System.out.println("12. Морква");
        System.out.println("13. Помідор");
        System.out.println("14. Цибуля");
    }

}
