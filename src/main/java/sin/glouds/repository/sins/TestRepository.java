package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.Test;

@org.springframework.stereotype.Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
