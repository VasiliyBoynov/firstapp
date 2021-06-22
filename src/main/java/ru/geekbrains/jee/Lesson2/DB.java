package ru.geekbrains.jee.Lesson2;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("db")
public class DB {
    private static DB instance;

    private static Map<Long,Product> list;

    private DB() {
        list = new HashMap< Long, Product >() {
        };
    }

    public static DB getInstance() {
        if (instance==null) instance = new DB();
        return instance;
    }

    public void creat(Product product){
        getInstance().list.put(product.getId(),product);
    }

    public Product read(long id){
        if(!getInstance().list.containsKey(id)) return null;
        return getInstance().list.get(id);
    }

    public void update(Product product){
        creat(product);
    }

    public void delte(long id){
        getInstance().list.remove(id);
    }

    public long count(){
        return getInstance().list.size();
    }

    public float avr(){
        float sum=0;
        sum = getInstance().list.values().stream().map(s-> s.getCost()).reduce((float) 0, (acc, x) -> acc+x).floatValue();
        return sum/count();
    }

}
