/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuis;

/**
 *
 * @author pradhumna dhungana
 */
public class MenuItem {
    private int dishNumber;
    private String dishName;
    private String category;
    private String spiciness;
    private double price;
    
    public MenuItem(int dishNumber, String dishName, String category, String spiciness, double price)
    {
        this.dishNumber = dishNumber;
        this.dishName = dishName;
        this.category = category;
        this.spiciness = spiciness;
        this.price = price;        
    }
    
    public int getDishNumber()
    {
        return dishNumber;
    }
    
    public void setDishNumber(int dishNumber)
    {
        this.dishNumber = dishNumber;
    }
    
    public void setDishName(String dishName)
    {
        this.dishName = dishName;
    }
    
    public String getDishName()
    {
        return dishName;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setSpiciness(String spiciness)
    {
        this.spiciness = spiciness;
    }
    
    public String getSpiciness()
    {
        return spiciness;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public double getPrice()
    {
        return price;
    }
}
