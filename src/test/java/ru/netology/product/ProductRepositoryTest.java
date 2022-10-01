package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(12, "Война и мир", 800, "Лев Толстой");
    Product book2 = new Book(22, "Евгений Онегин", 500, "Александр Пушкин");
    Product book3 = new Book(252, "Заводной апельсин", 500, "Энтони Берджесс");
    Product smartphone1 = new Smartphone(29, "Iphone 13", 122500, "Apple");
    Product smartphone2 = new Smartphone(14, "Samsung A22", 30000, "Samsung");
    Product smartphone3 = new Smartphone(300, "Huawei P30", 70000, "Huawei");
    Product smartphone4 = new Smartphone(301, "Huawei P30", 75000, "Huawei");

    @Test
    public void RemoveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.removeById(book2.getId());

        Product[] expected = {book1, book3, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveMoreThanOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.removeById(book2.getId());
        repo.removeById(smartphone2.getId());

        Product[] expected = {book1, book3, smartphone1, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void RemoveNotFoundId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(1015);
        });
    }

}
