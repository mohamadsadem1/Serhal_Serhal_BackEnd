package com.example.SerhalAndSerhal.Brand;

import com.example.SerhalAndSerhal.Brand.DTO.BrandRequest;
import com.example.SerhalAndSerhal.Brand.DTO.BrandResponse;
import com.example.SerhalAndSerhal.Exceptions.BrandAlreadyExistException;
import com.example.SerhalAndSerhal.Exceptions.BrandNotFoundException;
import lombok.AllArgsConstructor;
import com.example.SerhalAndSerhal.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandServiceIMPL implements BrandService {

    private final BrandRepository brandRepository;


    @Override
    public BrandResponse createBrand(BrandRequest brandRequest) {
        brandRepository.findBrandByName(brandRequest.getName())
                .ifPresent(brand -> {
                    throw new BrandAlreadyExistException("This brand already exists");
                });

        // Convert the request to a brand class to be added
        Brand brand = Brand.builder()
                .name(brandRequest.getName())
                .build();

        // Save the brand
        Brand savedBrand = brandRepository.save(brand);
        return mapToBrandResponse(savedBrand);

    }

    @Override
    public BrandResponse updateBrandById(Long id, BrandRequest brandRequest) {

        // No need to check if the brand exists with the given name, as this method is for updating an existing brand
        // Directly create the Brand object with the updated name and save it to the repository
        Brand brand = Brand.builder()
                .name(brandRequest.getName())
                .build();

        // Save the updated brand and map to the response before returning
        Brand savedBrand = brandRepository.save(brand);
        return mapToBrandResponse(savedBrand);
    }


    @Override
    public void deleteBrandById(Long id) {

//        Brand existingBrand = brandRepository.findById(id)

        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if(!optionalBrand.isPresent()){
            throw new ResourceNotFoundException("brand ",id.toString(),"value");
        }
        Brand brand= optionalBrand.get();

        brandRepository.delete(brand);
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("brand", id.toString(), "brand"));
        return mapToBrandResponse(brand);

    }

    @Override
    public BrandResponse getBrandByName(String name) {

            return brandRepository.findBrandByName(name)
                    .map(this::mapToBrandResponse)
                    .orElseThrow(() -> new BrandNotFoundException("Brand does not exist"));
        }
    @Override
    public List<BrandResponse> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brandRepository.findAll().stream()
                .map(this::mapToBrandResponse)
                .collect(Collectors.toList());

    }

    private BrandResponse mapToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .name(brand.getName())
                .timeCreated(brand.localTimeCreatedToString())
                .timeUpdated(brand.localTimeUpdatedToString())
                .id(brand.getId())
                .build();
    }

    private Brand mapToBrand(BrandRequest brandRequest) {
        return Brand.builder()
                .name(brandRequest.getName())
                .build();
    }
}
