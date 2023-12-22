package com.menu;
import java.util.Scanner;

public class Start {
    Scanner sc = new Scanner(System.in);
    Order order = new Order();
    private boolean stop = true;
    private int food;
    private Eat eat = null;
   public void printOption(){
        System.out.println("Виберіть опцію: ");
        System.out.println("1. Додати страву до замовлення");
        System.out.println("2. Видалити страву з замовлення");
        System.out.println("3. Показати замовлення");
        System.out.println("4. Розрахувати суму замовлення");
        System.out.println("5. Вибрати знижку(встановити свою знижку)");
        System.out.println("6. Вийти(неможна)");
    }
    public void printMenu(){
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

    public void addDish(){
        try {
            printMenu();
            food = sc.nextInt();
            eat = Eat.values()[food - 1];
            order.setEat(eat);
            System.out.println("Страву додано до замовлення \uD83D\uDE42 ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeDish(){
        try {
            if (eat == null) {
                System.out.println("Друже в тебе корзинка пуста купи шось пж \uD83E\uDD7A ");
            } else {
                System.out.println("Виберіть страву для видалення: ");

                order.getEat();
                food = sc.nextInt();

                eat = Eat.values()[food - 1];
                order.removeEat(eat);
                System.out.println("Страву видалено з замовлення \uD83E\uDD7A ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printOrder(){
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

    public void calculateOrder(){
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
    	 double saleFruit = 0.0;
    	 double saleMeat = 0.0;
    	 double saleVeg = 0.0;
    	   
    	 int countFruitUser = 0;
    	 int countMeatUser = 0;
    	 int countVegUser = 0;
    	 
    	System.out.println("Введіть знижку фруктів: ");
    	 saleFruit = sc.nextDouble();
    	 if(saleFruit<=0.0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 System.out.println("Введіть кількість фруктів при якій спрацьовує знижка: ");
    	 countFruitUser = sc.nextInt();
    	 if(countFruitUser<=0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 
    	 
    	 System.out.println("Введіть знижку м'яса: ");
    	 saleMeat = sc.nextDouble();
    	 if(saleMeat<=0.0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 System.out.println("Введіть кількість м'яса при якій спрацьовує знижка: ");
    	 countMeatUser = sc.nextInt();
    	 if(countMeatUser<=0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 
    	 
    	 System.out.println("Введіть знижку овочів: ");
    	 saleVeg = sc.nextDouble();
    	 if(saleVeg<=0.0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 System.out.println("Введіть кількість овочів при якій спрацьовує знижка: ");
    	 countVegUser = sc.nextInt();
    	 if(countVegUser<=0) {
    		 System.out.println("Ви ввели некоректне значення спробуйте ще раз");
    		 return;
    	 }
    	 else {
    		 System.out.println("Успішно");
    	 }
    	 order.setSale(saleFruit, saleMeat, saleVeg);
    	 order.setCount(countFruitUser, countMeatUser, countVegUser);
    }

    public void start() {
        
            while (stop) {
                printOption();
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