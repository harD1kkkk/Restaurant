package com.menu;
import java.util.List;
public interface Menu {

    void setEat(Eat eat);

    void getEat();

    void removeEat(Eat eat);

    void calculate(List<Eat> eats);
    
    double calculateSaleUser(double price, int countFruit, int countMeat, int countVeg);
    double calculateSale(double price, int countFruit, int countMeat, int countVeg);

    void setSale(double saleFruit, double saleMeat, double saleVeg);
    void setCount(int countFruitUser, int countMeatUser, int countVegUser);
    
    double getSaleForFruit();
    double getSaleForMeat();
    double getSaleForVeg();
    
    double getCountForFruit();
    double getCountForMeat();
    double getCountForVeg();
}