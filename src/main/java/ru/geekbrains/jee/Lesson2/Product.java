package ru.geekbrains.jee.Lesson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Product {
    private long id;
    private String title;
    private float cost;

    public Product(long id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void info(){
        System.out.println("ID:"+getId()+" Продукт :"+getTitle() + " Цена :" + getCost());
    }
}
