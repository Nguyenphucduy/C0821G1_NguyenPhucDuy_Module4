package song.songinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import song.songinfo.dto.SongDTO;
import song.songinfo.model.Song;
import song.songinfo.repository.ISongRepository;
import song.songinfo.service.ISongService;

import java.time.LocalTime;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public void save(SongDTO songDTO) {
        Song song = new Song();
        song.setName(songDTO.getName());
        song.setSinger(songDTO.getSinger());
        song.setKindOfMusic(songDTO.getKindOfMusic());
        song.setCreateDate(String.valueOf(LocalTime.now()));
        iSongRepository.save(song);
    }
}
