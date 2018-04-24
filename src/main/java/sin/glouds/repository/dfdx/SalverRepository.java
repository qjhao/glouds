package sin.glouds.repository.dfdx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.dfdx.Salver;


@Repository
public interface SalverRepository extends JpaRepository<Salver, String> {

}
