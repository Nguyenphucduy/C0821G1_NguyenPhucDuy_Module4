package song.songinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import song.songinfo.model.Song;
@Repository
public interface ISongRepository extends JpaRepository <Song,Integer> {
}
