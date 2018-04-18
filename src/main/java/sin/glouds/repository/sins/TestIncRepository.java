package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.TestInc;

@org.springframework.stereotype.Repository
public interface TestIncRepository extends JpaRepository<TestInc, Integer> {

}
