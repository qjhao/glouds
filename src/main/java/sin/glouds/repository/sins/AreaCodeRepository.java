package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.AreaCode;

@org.springframework.stereotype.Repository
public interface AreaCodeRepository extends JpaRepository<AreaCode, Integer> {

}
