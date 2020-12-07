package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    private void loadProducts(){

        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Watch");
        product1.setPrice(new BigDecimal("200.00"));
        product1.setImageURL("http://example.com/product1");

        products.put(1,product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Fitbit");
        product2.setPrice(new BigDecimal("140.00"));
        product2.setImageURL("http://example.com/product2");

        products.put(2,product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("TV");
        product3.setPrice(new BigDecimal("850.00"));
        product3.setImageURL("http://example.com/product3");

        products.put(3,product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("ThreadMill");
        product4.setPrice(new BigDecimal("1200.00"));
        product4.setImageURL("http://example.com/product4");

        products.put(4,product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDescription("Microwave");
        product5.setPrice(new BigDecimal("100.00"));
        product5.setImageURL("http://example.com/product5");

        products.put(5,product5);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {

        if(product != null){
            if(product.getId() == null) {
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);

            return product;
        }else {
            throw new RuntimeException("Product can't be null");
        }
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) +1;
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }
}
