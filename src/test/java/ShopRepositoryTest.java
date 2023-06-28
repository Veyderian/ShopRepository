import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    private ShopRepository repo;
    private Product product1;
    private Product product2;
    private Product product3;

    @Test
    public void shouldSuccessDeleteElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(17, "диван", 145_000);
        Product product2 = new Product(77, "кровать", 60_000);
        Product product3 = new Product(35, "матрац", 180_000);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(17);


        Product[] expected = {product2, product3};

        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteElementNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(17, "диван", 145_000);
        Product product2 = new Product(77, "кровать", 60_000);
        Product product3 = new Product(35, "матрац", 180_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(66);
        });
    }
}

