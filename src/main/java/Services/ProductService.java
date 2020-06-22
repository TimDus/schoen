package Services;

import Models.Product;
import Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements iProductService
{
    @Autowired
    private ProductRepository productRepository;
      
    public Optional<Product> GetProduct(int id)
    {
        return productRepository.findById(id);
    }

    public List<Product> GetAllProducts()
    {
        return productRepository.findAll();
    }
}
