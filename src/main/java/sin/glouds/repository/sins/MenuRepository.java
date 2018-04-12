package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.Menu;

@org.springframework.stereotype.Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
