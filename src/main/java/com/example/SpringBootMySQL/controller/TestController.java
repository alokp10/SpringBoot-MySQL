    package com.example.SpringBootMySQL.controller;

    import com.example.SpringBootMySQL.entity.Product;
    import com.example.SpringBootMySQL.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    public class TestController {

        @Autowired
        private ProductService productService;

        @RequestMapping(value = "/")
        public String welcome()
        {
            return "Hello World";
        }

        @PostMapping(value="/addProduct")
        public Product addProduct(@RequestBody Product product){
            return productService.saveProduct(product);
        }

        @PostMapping(value="/addProducts")
        public List<Product> saveProducts (@RequestBody List<Product> products){
            return productService.saveProducts(products);
        }

        @GetMapping(value="/products")
        public List<Product> getProducts(){
            return productService.getProducts();
        }

        @GetMapping(value = "/product/{id}")
        public Product findProductById( @PathVariable int id){
            return productService.getProductById(id);
        }

        @GetMapping(value = "/product/{name}")
        public Product findProductByName(@PathVariable String name){
            return productService.getProductByName(name);
        }

        @PutMapping(value = "/update")
        public Product updateProduct(@RequestBody Product product){
            return productService.updateProduct(product);
        }

        @DeleteMapping(value="/product/{id}")
        public String deleteProduct(@PathVariable int id){
            return productService.deleteProduct(id);
        }
    }
