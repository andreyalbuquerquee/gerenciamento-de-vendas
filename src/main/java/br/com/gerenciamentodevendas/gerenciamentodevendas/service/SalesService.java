package br.com.gerenciamentodevendas.gerenciamentodevendas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.client.Client;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.sale.Sale;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.sale.SaleItem;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests.CreateSaleRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests.SaleItemRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses.CreateSaleResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.mapper.SaleMapper;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ClientRepository;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ProductRepository;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.SaleRepository;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation.ClientValidator;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation.ProductValidator;

@Service
public class SalesService {
    private final SaleRepository repository;
    private final ClientValidator clientValidator;
    private final ProductValidator productValidator;
    private final SaleMapper saleMapper;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public SalesService(
        SaleRepository repository, 
        ClientValidator clientValidator, 
        ProductValidator productValidator,
        SaleMapper saleMapper,
        ProductRepository productRepository,
        ClientRepository clientRepository) {
        this.repository = repository;
        this.clientValidator = clientValidator;
        this.productValidator = productValidator;
        this.saleMapper = saleMapper;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }


    public CreateSaleResponseDTO create(CreateSaleRequestDTO request) {
        clientValidator.validateClientExistence(request.clientId());
    
        List<UUID> productsIds = request.items()
        .stream()
        .map(i -> i.productId())
        .toList();

        productValidator.validateProductsExistence(productsIds);

        Sale newSale = saleMapper.toEntity(request);
        
        Client saleClient = clientRepository.findById(request.clientId()).get();
        newSale.setClient(saleClient);
        
        List<SaleItem> saleItems = new ArrayList<>();

        for (SaleItemRequestDTO itemRequestDTO : request.items()) {
            SaleItem item = saleMapper.toSaleItem(itemRequestDTO);
            item.setSale(newSale);

            Product itemProduct = this.productRepository.findById(itemRequestDTO.productId()).get();

            item.setProduct(itemProduct);

            saleItems.add(item);
        }   

        newSale.setItems(saleItems);

        Sale savedSale = repository.save(newSale);

        return saleMapper.toCreateSaleResponse(repository.save(savedSale));
    }
}
