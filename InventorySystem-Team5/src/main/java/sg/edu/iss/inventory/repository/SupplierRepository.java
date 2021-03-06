package sg.edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.inventory.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>  {

	@Query("SELECT s FROM Supplier s where s.supplierId = :supplierId")
	Supplier findSupplierBysupplierId(@Param("supplierId") Integer supplierId);
	
	@Query("SELECT s FROM Supplier s where s.supplierName = :supplierName")
	Supplier findSupplierBysupplierName(@Param("supplierName") String supplierName);
}
