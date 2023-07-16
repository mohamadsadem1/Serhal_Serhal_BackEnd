package com.example.SerhalAndSerhal.Product;



import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
import com.example.SerhalAndSerhal.Product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceIMPL productServiceIMPL;

    @PostMapping
    public ResponseEntity<ProductResponse> createBrand(@RequestBody ProductRequest productRequest){
     ProductResponse productResponse=productServiceIMPL.createProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){

        return productServiceIMPL.getAllProducts();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable ("id") Long productId,
                                                     @RequestBody ProductRequest productRequest) {
        ProductResponse updatedBrand= productServiceIMPL.updateProductById(productRequest,productId);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    @GetMapping({"/id-{id}"})
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId){

        return new ResponseEntity<>(productServiceIMPL.getProductById(productId), HttpStatus.OK);
    }
    @GetMapping({"/name-{name}"})
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable("name") String name){

        return new ResponseEntity<>(productServiceIMPL.getProductByName(name), HttpStatus.OK);
    }
}
