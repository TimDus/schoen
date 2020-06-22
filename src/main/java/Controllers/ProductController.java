package Controllers;

import Models.Product;
import Services.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController
{
    @Autowired
    iProductService iproductService;

    @GetMapping("/winkel")
    public List<Product> GetAllProducts()
    {
        return iproductService.GetAllProducts();
    }

    @GetMapping("/product")
    public Optional<Product> GetProduct(int id)
    {
        return iproductService.GetProduct(id);
    }
}
