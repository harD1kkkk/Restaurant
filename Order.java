
package com.menu;

import java.util.ArrayList;
import java.util.List;

public class Order implements Menu {
    private double saleFruit = 0.0;
    private double saleMeat = 0.0;
    private double saleVeg = 0.0;

    private int countFruitUser = 0;
    private int countMeatUser = 0;
    private int countVegUser = 0;


    List<Eat> orderList = new ArrayList<>();

    @Override
    public void setEat(Eat eat) {
        orderList.add(eat);
    }


    @Override
    public void removeEat(Eat eat) {
        orderList.remove(eat);
    }


    @Override
    public void setSale(double saleFruit, double saleMeat, double saleVeg) {
        this.saleFruit = saleFruit;
        this.saleMeat = saleMeat;
        this.saleVeg = saleVeg;
    }

    @Override
    public void setCount(int countFruitUser, int countMeatUser, int countVegUser) {
        this.countFruitUser = countFruitUser;
        this.countMeatUser = countMeatUser;
        this.countVegUser = countVegUser;
    }


    @Override
    public double getCountForFruit() {
        return countFruitUser;
    }

    @Override
    public double getCountForMeat() {
        return countMeatUser;
    }

    @Override
    public double getCountForVeg() {
        return countVegUser;
    }


    @Override
    public double getSaleForFruit() {
        return saleFruit;
    }

    @Override
    public double getSaleForMeat() {
        return saleMeat;
    }

    @Override
    public double getSaleForVeg() {
        return saleVeg;
    }

    @Override
    public double calculateSaleUser(double price, int countFruit, int countMeat, int countVeg) {
        double saleUser = 0.0;
        if (countFruit >= getCountForFruit() && countMeat < getCountForMeat() && countVeg < getCountForVeg()) {
            saleUser = price * getSaleForFruit();
        } else if (countFruit < getCountForFruit() && countMeat >= getCountForMeat() && countVeg < getCountForVeg()) {
            saleUser = price * getSaleForMeat();
        } else if (countFruit < getCountForFruit() && countMeat < getCountForMeat() && countVeg >= getCountForVeg()) {
            saleUser = price * getSaleForVeg();
        } else if (countFruit >= getCountForFruit() && countMeat >= getCountForMeat() && countVeg < getCountForVeg()) {
            saleUser = price * (getSaleForFruit() + getSaleForMeat());
        } else if (countFruit >= getSaleForFruit() && countMeat < getCountForMeat() && countVeg >= getCountForVeg()) {
            saleUser = price * (getSaleForFruit() + getSaleForVeg());
        } else if (countFruit < getCountForFruit() && countMeat >= getCountForMeat() && countVeg >= getCountForVeg()) {
            saleUser = price * (getSaleForMeat() + getSaleForVeg());
        } else if (countFruit >= getCountForFruit() && countMeat >= getCountForMeat() && countVeg >= getCountForVeg()) {
            saleUser = price * (getSaleForFruit() + getSaleForMeat() + getSaleForVeg());
        }
        return saleUser;
    }

    @Override
    public double calculateSale(double price, int countFruit, int countMeat, int countVeg) {
        double sale = 0.0;
        if (countFruit >= 5 || countMeat >= 5 || countVeg >= 5) {
            sale = price * 0.25;
        } else if (countVeg == 4 && countMeat < 4 && countFruit < 4) {
            sale = price * 0.15;
        } else if (countMeat == 4 && countFruit < 4 && countVeg < 4) {
            sale = price * 0.10;
        } else if (countFruit == 4 && countMeat < 4 && countVeg < 4) {
            sale = price * 0.05;
        } else if (countFruit == 4 && countMeat == 4 && countVeg < 4) {
            sale = price * 0.15;
        } else if (countFruit == 4 && countMeat < 4 && countVeg == 4) {
            sale = price * 0.2;
        } else if (countFruit < 4 && countMeat == 4 && countVeg == 4) {
            sale = price * 0.25;
        } else if (countFruit <= 3 && countMeat <= 3 && countVeg <= 3) {
            sale = 0;
        }
        return sale;
    }

    @Override
    public void calculate(List<Eat> eats) {
        double price = 0.0;
        double sale;
        double totalPrice;

        int countFruit = 0;
        int countVeg = 0;
        int countMeat = 0;
        for (Eat eat : eats) {
            if (eat == Eat.APPLE) {
                price += 2.99;
                countFruit++;
            } else if (eat == Eat.BANANA) {
                price += 4.99;
                countFruit++;
            } else if (eat == Eat.ORANGE) {
                price += 4.99;
                countFruit++;
            } else if (eat == Eat.STRAWBERRY) {
                price += 3.99;
                countFruit++;
            } else if (eat == Eat.MEAT) {
                price += 50.99;
                countMeat++;
            } else if (eat == Eat.CHICKEN) {
                price += 30.99;
                countMeat++;
            } else if (eat == Eat.POTATO) {
                price += 5.99;
                countVeg++;
            } else if (eat == Eat.FISH) {
                price += 20.99;
                countMeat++;
            } else if (eat == Eat.RICE) {
                price += 6.99;
                countVeg++;
            } else if (eat == Eat.SALAD) {
                price += 7.99;
                countVeg++;
            } else if (eat == Eat.SOUP) {
                price += 8.99;
            } else if (eat == Eat.CARROT) {
                price += 4.99;
                countVeg++;
            } else if (eat == Eat.TOMATO) {
                price += 4.99;
                countVeg++;
            } else if (eat == Eat.ONION) {
                price += 4.99;
                countVeg++;
            }
        }

        if (getSaleForFruit() == 0.0 && getSaleForMeat() == 0.0 && getSaleForVeg() == 0.0) {
            sale = calculateSale(price, countFruit, countMeat, countVeg);
            totalPrice = price - sale;
            System.out.println("Кінцеваь ціна: " + totalPrice + " знижкка(стандартна): " + sale);
        } else {
            sale = calculateSaleUser(price, countFruit, countMeat, countVeg);
            totalPrice = price - sale;
            System.out.println("Кінцева ціна: " + totalPrice + " знижка(Ваша власна): " + sale);
        }
    }

    @Override
    public void getEat() {
        for (Eat item : orderList) {
            System.out.println("Страва: " + item);
        }
    }
}