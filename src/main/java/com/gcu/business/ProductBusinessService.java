package com.gcu.business;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.IDataAccess;

import com.gcu.data.ProductService;
import com.gcu.model.ProductModel;

/**
 * Business logic for products
 */
@Service
public class ProductBusinessService implements IDataAccess<ProductModel> 
{
	@Autowired
	ProductService DAO;
	
	/**
	 * Test method for debugging
	 */
	public void test() 
	{
		System.out.println("Hello");
	}
	/** Creates a product by calling data layer
	 * @param model (Product model)
	 * @return true/false
	 */
	@Override
	public boolean create(ProductModel model) {
		//call DAO to create this model and insert into database, will return true or false
		return DAO.create(model);
	}


	/** finds all products
	 * @return list of products
	 */
	@Override
	public List<ProductModel> findAll() {
		//Instantiate new list of products and call DAO to retrieve all products
		List<ProductModel> productsList = DAO.findAll();
		//return list
        return productsList;
	}


	/** finds a product model by its id
	 * @param id (product id)
	 * @return product model found
	 */
	@Override
	public ProductModel findById(int id) {
		//retrieve product from database with id passed as parameter, will return this product
		ProductModel product = DAO.findById(id);
		return product;
	}


	/** updates a product model in the database
	 * @param oldProduct (original)
	 * @param newProduct (updated)
	 * @return true/false
	 */
	@Override
	public boolean update(ProductModel oldProduct, ProductModel newProduct) {
		//update the database, replacing oldProduct with newProduct, will return true or false
		return DAO.update(oldProduct, newProduct);
	}


	/** deletes a product from the database
	 * @param productModel (to be deleted)
	 * @return true/false
	 */
	@Override
	public boolean delete(ProductModel productModel) 
	{
		//delete product passed as parameter from the database, will return true or false
		return DAO.delete(productModel);
	}
	@Override
	public ProductModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
