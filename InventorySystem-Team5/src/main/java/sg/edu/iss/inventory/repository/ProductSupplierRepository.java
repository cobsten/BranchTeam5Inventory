package sg.edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.inventory.model.ProductSupplier;
import sg.edu.iss.inventory.model.ProductSupplierId;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductSupplierId> {
	// specified return type as array lists as multiple supplier will be returned
	// per productID
	@Query("SELECT p FROM ProductSupplier p where p.id.partNo = :partNo")
	ArrayList<ProductSupplier> findProductSupplierByProductId(@Param("partNo") String partNo);


}
