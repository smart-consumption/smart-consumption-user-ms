package com.unicauca.smart_consumption.domain.product.ports.in;

import com.unicauca.smart_consumption.domain.common.ResponseDto;
import com.unicauca.smart_consumption.domain.product.Product;
import java.util.List;

/**
 * Interface that defines CRUD operations for the {@link Product} entity.
 */
public interface IProductService {

  /**
   * Creates a new product in the system.
   *
   * @param product The {@link Product} to be created.
   * @return A {@link ResponseDto} containing the created product and an HTTP status code.
   */
  ResponseDto<Product> createProduct(Product product);

  /**
   * Updates an existing product in the system.
   *
   * @param id The ID of the {@link Product} to be updated.
   * @param product The {@link Product} with updated information.
   * @return A {@link ResponseDto} containing the updated product and an HTTP status code.
   */
  ResponseDto<Product> updateProduct(String id, Product product);

  /**
   * Deletes an existing product from the system.
   *
   * @param id The ID of the {@link Product} to be deleted.
   * @return A {@link ResponseDto} indicating the result of the operation with an HTTP status code.
   */
  ResponseDto<Void> deleteProduct(String id);

  /**
   * Finds a product in the system by its ID.
   *
   * @param id The ID of the {@link Product} to be retrieved.
   * @return A {@link ResponseDto} containing the found product if it exists, and an HTTP status code.
   */
  ResponseDto<Product> findProductById(String id);

  /**
   * Retrieves a list of all products in the system.
   *
   * @return A {@link ResponseDto} containing the list of all products and an HTTP status code.
   */
  ResponseDto<List<Product>> findAllProducts();


}
