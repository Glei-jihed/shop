package education.shop.controllers;


import education.shop.entities.Dto.ProductAdminRespDto;
import education.shop.entities.Dto.ProductDto;
import education.shop.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins/operations")
public class AdminController {
   private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path="/products/build")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAdminRespDto addProduct(@RequestBody ProductDto dto){
        return adminService.addProduct(dto);
    }

    @GetMapping(path = "/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> getAllProducts(){
        return adminService.findAllProducts();
    }


    @GetMapping(path="/products/{reference}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductAdminRespDto> findProductById(@PathVariable String reference)
    {
        return adminService.findProductById(reference);
    }

    @PatchMapping(path = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductAdminRespDto updateProduct(@RequestBody ProductDto product)
    {
        return adminService.updateProduct(product);
    }

    @DeleteMapping(path = "/products/{reference}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable String reference)
    {
        adminService.deleteProduct(reference);
    }

    @GetMapping(path = "/products/{instock}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> findProducts(@PathVariable boolean inStock){
        return adminService.findProductInStock(inStock);
    }

    @GetMapping(path = "/products/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> findByCategory(@PathVariable String category){
        return adminService.findProductByCategory(category);
    }

    @GetMapping(path = "/products/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> findByPrice(@PathVariable double price)
    {
        return adminService.findProductByPrice(price);
    }

    @GetMapping(path = "/products/prices/{min}/{max}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> findByPriceMinMax(@PathVariable double min,@PathVariable double max)
    {
        return adminService.findProductByPriceBetween(min, max);
    }


    @GetMapping(path = "/product/{word}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductAdminRespDto> findByNameLike(@PathVariable String word)
    {
        return adminService.findByName(word);
    }











}
