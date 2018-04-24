package sin.glouds.repository.dfdx;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.dfdx.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, String>, JpaSpecificationExecutor<Store> {

	Page<Store> findAllByDelFlagAndStatusAndType(Boolean flag, String status, String type, Pageable page);
	
}
