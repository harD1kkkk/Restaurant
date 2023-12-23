package com.menu;

import java.util.Scanner;

public class Start {
    private boolean checkSale(double sale) {
        return !(sale < 0.0);
    }

    private boolean checkCount(int count) {
        return count > 0;
    }

    Scanner sc = new Scanner(System.in);
    Order order = new Order();
    private boolean stop = true;
    private int food;
    private Eat eat = null;


    public void addDish() {
        try {
            PrintManager.printMenu();
            food = sc.nextInt();
            eat = Eat.values()[food - 1];
            order.setEat(eat);
            System.out.println("Страву додано до замовлення \uD83D\uDE42 ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeDish() {
        try {
            if (eat == null) {
                System.out.println("Друже в тебе корзинка пуста купи шось пж \uD83E\uDD7A ");
            } else {
                PrintManager.printMenu();

                System.out.println("Ваше замовлення: ");
                order.getEat();

                System.out.println("Виберіть страву для видалення: ");
                food = sc.nextInt();


                eat = Eat.values()[food - 1];
                order.removeEat(eat);
                System.out.println("Страву видалено з замовлення \uD83E\uDD7A ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printOrder() {
        try {
            if (eat == null) {
                System.out.println("Ваше замовлення пусте \uD83D\uDE41 ");
            } else {
                System.out.println("Ваше замовлення(пупс) \uD83D\uDE09 : ");
                order.getEat();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculateOrder() {
        try {
            if (eat == null) {
                System.out.println("Нема нічого щоб порахувати, замовте щось попоїсти,а тоді порахуєм \uD83D\uDE00 ");
            } else {
                System.out.println("Сума вашого замовлення:  \uD83D\uDC4D ");
                order.calculate(order.orderList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSaleAndCount() {
        try {
            double saleFruit;
            double saleMeat;
            double saleVeg;

            int countFruitUser;
            int countMeatUser;
            int countVegUser;

            System.out.println("Введіть знижку фруктів: ");
            saleFruit = sc.nextDouble();
            boolean f = checkSale(saleFruit);

            if (!f) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }
            System.out.println("Введіть кількість фруктів при якій спрацьовує знижка: ");
            countFruitUser = sc.nextInt();
            boolean fc = checkCount(countFruitUser);
            if (!fc) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }


            System.out.println("Введіть знижку м'яса: ");
            saleMeat = sc.nextDouble();
            boolean m = checkSale(saleMeat);
            if (!m) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }
            System.out.println("Введіть кількість м'яса при якій спрацьовує знижка: ");
            countMeatUser = sc.nextInt();
            boolean mc = checkCount(countMeatUser);
            if (!mc) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }


            System.out.println("Введіть знижку овочів: ");
            saleVeg = sc.nextDouble();
            boolean v = checkSale(saleVeg);
            if (!v) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }
            System.out.println("Введіть кількість овочів при якій спрацьовує знижка: ");
            countVegUser = sc.nextInt();
            boolean vc = checkCount(countVegUser);
            if (!vc) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз");
                return;
            } else {
                System.out.println("Успішно");
            }


            if (saleFruit == 0 && saleMeat == 0 && saleVeg == 0) {
                System.out.println("Ви ввели некоректне значення спробуйте ще раз(Ви ввели на всі товари знижку 0 так не може бути принаймі хоч 1 товар на знижці)");
                return;
            }
            order.setSale(saleFruit, saleMeat, saleVeg);
            order.setCount(countFruitUser, countMeatUser, countVegUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {

        while (stop) {

            PrintManager.printOption();
            int option = sc.nextInt();
            switch (option) {
                case 1 -> addDish();
                case 2 -> removeDish();
                case 3 -> printOrder();
                case 4 -> calculateOrder();
                case 5 -> setSaleAndCount();
                case 6 -> {
                    System.out.println("Дякую за використання моєї програми ");
                    System.out.println("P.S. наступного разу не дам вийти \uD83D\uDE21 ");
                    stop = false;
                }
                default -> System.out.println("Ромео стоп ти направильно ввів го ще разок \uD83D\uDE09 ");
            }
        }
    }
}