package song.songinfo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {
    @NotBlank(message = "không được phép để trống")
    @Size(max = 800,message = "không được phép quá 800 kí tự")
    @Pattern(regexp = "^[A-z ]+$", message = "tên bài hát không được chứa kí tự đặc biệt")
    private String name;
    @NotBlank(message = "không được phép để trống")
    @Size(max = 300,message = "không được phép quá 300 kí tự")
    @Pattern(regexp = "^[A-z ]+$", message = "Tên ca sĩ không được chứa kí tự đặc biệt")
    private String singer;
    @NotBlank(message = "không được phép để trống")
    @Size(max = 1000,message = "không được phép quá 1000 kí tự")
    @Pattern(regexp = "^[A-z ]+$", message = "Tên Loại nhạc không được chứa kí tự đặc biệt")
    private String kindOfMusic;

    public SongDTO() {
    }

    public SongDTO(String name, String singer, String kindOfMusic) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
