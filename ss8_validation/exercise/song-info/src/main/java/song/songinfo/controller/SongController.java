package song.songinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import song.songinfo.dto.SongDTO;
import song.songinfo.service.ISongService;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;
    @GetMapping(value = "/create")
    public String getPageCreate(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "index";
    }

    @PostMapping(value = "/create_done")
    public String createSong(@Valid @ModelAttribute("songDTO") SongDTO songDTO,
                             BindingResult bindingResult, Model model) {


        if(bindingResult.hasErrors()) {
            return "index";
        }else {
            iSongService.save(songDTO);
            return "result";
        }
    }

}
