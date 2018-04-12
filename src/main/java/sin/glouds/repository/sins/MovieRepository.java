package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.Movie;

@org.springframework.stereotype.Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
