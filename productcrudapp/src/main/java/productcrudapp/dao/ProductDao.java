package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	


	@Autowired
	HibernateTemplate hibernatetTemplate;
	
	@Transactional
	public void createProduct(Product product) {
		this.hibernatetTemplate.save(product);
	}
	
	@Transactional
	public List<Product> getProducts() {
		
		List<Product> loadAll = this.hibernatetTemplate.loadAll(Product.class);
		
		return loadAll;
	
	}
	
	@Transactional
	public void deleteProduct(int pid) {
		Product load = this.hibernatetTemplate.load(Product.class, pid);
		this.hibernatetTemplate.delete(load);
	}
	
	
	@Transactional
	public Product getProduct(int pid) {
		
		return this.hibernatetTemplate.get(Product.class, pid);
	}
	
//	public HibernateTemplate getHibernatetTemplate() {
//		return hibernatetTemplate;
//	}
//
//	public void setHibernatetTemplate(HibernateTemplate hibernatetTemplate) {
//		this.hibernatetTemplate = hibernatetTemplate;
//	}
}
