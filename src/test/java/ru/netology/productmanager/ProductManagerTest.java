package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.ProductRepository;
import ru.netology.product.Smartphone;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(12, "Война и мир", 800, "Лев Толстой");
    Product book2 = new Book(22, "Евгений Онегин", 500, "Александр Пушкин");
    Product book3 = new Book(252, "Заводной апельсин", 500, "Энтони Берджесс");
    Product smartphone1 = new Smartphone(29, "Iphone 13", 122500, "Apple");
    Product smartphone2 = new Smartphone(14, "Samsung A22", 30000, "Samsung");
    Product smartphone3 = new Smartphone(300, "Huawei P30", 70000, "Huawei");
    Product smartphone4 = new Smartphone(301, "Huawei P30", 75000, "Huawei");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }


    @Test
    public void SearchByFullExistingName() {

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Евгений Онегин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchByNotFullExistingName() {

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Онегин");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void SearchByNonExistingName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Мертвые души");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchByTwoEqualNames() {

        Product[] expected = {smartphone3, smartphone4};
        Product[] actual = manager.searchBy("Huawei P30");

        Assertions.assertArrayEquals(expected, actual);
    }


}
