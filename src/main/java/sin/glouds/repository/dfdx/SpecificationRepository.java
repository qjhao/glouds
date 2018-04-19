package sin.glouds.repository.dfdx;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.dfdx.Specification;


@org.springframework.stereotype.Repository
public interface SpecificationRepository extends JpaRepository<Specification, String> {

}
