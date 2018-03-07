package sin.test.activiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.test.activiti.model.Comp;

@Repository
public interface CompRepository extends JpaRepository<Comp, Long> {

}
