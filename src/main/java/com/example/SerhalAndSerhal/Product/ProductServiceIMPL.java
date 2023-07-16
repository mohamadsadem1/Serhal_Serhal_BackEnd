    package com.example.SerhalAndSerhal.Product;

    import com.example.SerhalAndSerhal.Brand.Brand;
    import com.example.SerhalAndSerhal.Brand.BrandRepository;

    import com.example.SerhalAndSerhal.Exceptions.BrandNotFoundException;
    import com.example.SerhalAndSerhal.Exceptions.ProductAlreadyExistException;
    import com.example.SerhalAndSerhal.Exceptions.ProductNotFoundException;
    import com.example.SerhalAndSerhal.Exceptions.ResourceNotFoundException;
    import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
    import com.example.SerhalAndSerhal.Product.dto.ProductResponse;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    @AllArgsConstructor
    @Slf4j
    public class ProductServiceIMPL implements ProductService{

        private final ProductRepository productRepository;
        private BrandRepository brandRepository;



        public ProductResponse createProduct(ProductRequest productRequest) {

            Optional<Product> optionalProduct= productRepository.findProductsByName(productRequest.getName());

            if(optionalProduct.isPresent()){
                throw new ProductAlreadyExistException("Product " + productRequest.getName()+" already exist");
            }

            Product product = mapToProduct(productRequest);

           productRepository.save(product);


           return mapToProductResponse(product);
        }

        @Override
        public ProductResponse updateProductById(ProductRequest productRequest,Long productId) {

            Optional<Product> optionalProduct = productRepository.findProductsById(productId);
            if(optionalProduct.isPresent()){
                throw new ProductNotFoundException("Product " + productRequest.getName());
            }

            Optional<Brand> optionalBrand= brandRepository.findBrandByName(productRequest.getBrandRequest().getName());
            if(!optionalProduct.isPresent()){
                throw new BrandNotFoundException("Product " + productRequest.getName()+" not found");
            }


            Product product=optionalProduct.get();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setDescription(product.getDescription());
            product.setBrand(optionalBrand.get());

           Product savedProduct = productRepository.save(product);
            return mapToProductResponse(savedProduct);
        }

        @Override
        public void deleteProduct(Long id) {

            Optional<Product> optionalProduct= productRepository.findById(id);
            if(optionalProduct.isPresent()) {
            productRepository.deleteById(id);}
            else throw new ProductNotFoundException("Product not found");

        }

        @Override
        public ProductResponse getProductById(Long id) {
            Optional<Product> optionalProduct= productRepository.findById(id);
            if(optionalProduct.isEmpty()) {
                throw new ProductNotFoundException("Product not found");
               }

                Product product = optionalProduct.get();

                return mapToProductResponse(product);

        }

        @Override
        public ProductResponse getProductByName(String name) {
            Optional<Product> optionalProduct= productRepository.findProductsByName(name);
            if(optionalProduct.isEmpty()) {
                throw new ProductNotFoundException("Product not found");
            }

                Product product = optionalProduct.get();

                return mapToProductResponse(product);
        }



        public List<ProductResponse> getAllProducts() {
            List<Product> products= productRepository.findAll();
           return products.stream().map(this :: mapToProductResponse).toList();

        }



    // MAPPING METHODS ----------------------------------------------------------------
        private ProductResponse mapToProductResponse(Product product) {
            return ProductResponse.builder()
                  .id(product.getId())
                  .name(product.getName())
                  .description(product.getDescription())
                  .price(product.getPrice())
                    .timeCreated(product.localTimeCreatedToString())
                    .timeUpdated(product.localTimeUpdatedToString())
                  .build();
        }



        private Product mapToProduct(ProductRequest productRequest){

            Optional<Brand> optionalBrand= brandRepository.findBrandByName(productRequest.getBrandRequest().getName());
            if(optionalBrand.isEmpty()){
                throw new BrandNotFoundException("Product " + productRequest.getName()+" not found");
            }

            return Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .brand(optionalBrand.get())
                    .build();
        }
    }
