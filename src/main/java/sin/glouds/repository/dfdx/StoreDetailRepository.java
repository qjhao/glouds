package sin.glouds.repository.dfdx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.dfdx.StoreDetail;


@Repository
public interface StoreDetailRepository extends JpaRepository<StoreDetail, String> {

}
