package ru.geekbrains.jee.Lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DB db = context.getBean("db",DB.class);
        for (int i = 0; i < 10; i++) {
            Product product = context.getBean("product",Product.class);
            product.setId(i);
            product.setTitle("product "+i);
            product.setCost((float) (1000*Math.random()));
            db.creat(product);
        }
        for (int i = 0; i < 10; i++) {
            db.read(i).info();
        }
        System.out.printf("Количество продуктов :%d, средняя цена: %s%n",db.count(),String.valueOf(db.avr()));
    context.close();
    }

}
