package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.NovelChapter;

@org.springframework.stereotype.Repository
public interface NovelChapterRepository extends JpaRepository<NovelChapter, Integer> {

}
