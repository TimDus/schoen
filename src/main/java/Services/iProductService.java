package Services;

import Models.Product;

import java.util.List;
import java.util.Optional;

public interface iProductService
{
    Optional<Product> GetProduct(int id);
    List<Product> GetAllProducts();
}
