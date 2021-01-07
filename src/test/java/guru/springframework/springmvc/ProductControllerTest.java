package guru.springframework.springmvc;


import guru.springframework.springmvc.controllers.ProductController;
import guru.springframework.springmvc.domain.Product;
import guru.springframework.springmvc.services.ProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void openMocks() throws Exception{
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testList() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        when(productService.listAll()).thenReturn((List) products);
        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/list"))
                .andExpect(model().attribute("products", hasSize(2)));
    }

    @Test
    public void testShow() throws Exception {

        Integer id = 1;

        when(productService.getById(id)).thenReturn(new Product());
        mockMvc.perform(get("/product/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/show"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testEdit() throws Exception {

        Integer id = 1;

        when(productService.getById(id)).thenReturn(new Product());
        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testNew() throws Exception {
        verifyNoInteractions(productService);
        mockMvc.perform(get("/product/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {

        Integer id=1;
        String description = "Testing New Product Description";
        BigDecimal price = new BigDecimal("14.00");
        String imageUrl = "google.com";

        Product returnProduct = new Product();
        returnProduct.setId(id);
        returnProduct.setDescription(description);
        returnProduct.setPrice(price);
        returnProduct.setImageUrl(imageUrl);

        when(productService.saveOrUpdate(any())).thenReturn(returnProduct);

        mockMvc.perform(post("/product")
                .param("id", "1")
                .param("description", description)
                .param("price", "14.00")
                .param("imageUrl", "google.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/show/1"))
                .andExpect(model().attribute("product", instanceOf(Product.class)))
                .andExpect(model().attribute("product", hasProperty("id", is(id))))
                .andExpect(model().attribute("product", hasProperty("description", is(description))))
                .andExpect(model().attribute("product", hasProperty("price", is(price))))
                .andExpect(model().attribute("product", hasProperty("imageUrl", is(imageUrl))));

        //verify properties of bound object
        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productService).saveOrUpdate(boundProduct.capture());

        assertEquals(id, boundProduct.getValue().getId());
        assertEquals(description, boundProduct.getValue().getDescription());
        assertEquals(price, boundProduct.getValue().getPrice());
        assertEquals(imageUrl, boundProduct.getValue().getImageUrl());

    }

    @Test
    public void testDelete() throws Exception{
        Integer id = 1;

        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/list"));

        verify(productService, times(1)).delete(id);
    }
}
