package ru.geekbrains.jee.Lesson1;

public class Product {
    private long id;
    private String title;
    private float cost;

    public Product(long id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

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

    public String info(){
        return String.format("id:%d title:%s cost:%s%n",getId(),getTitle(),String.valueOf(getCost()));
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
