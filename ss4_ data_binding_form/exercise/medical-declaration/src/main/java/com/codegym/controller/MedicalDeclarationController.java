package com.codegym.controller;


import com.codegym.entity.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {

    @GetMapping("")
    public String medicalDeclaration(Model model){
        String[] gioiTinh = {"Nam","Nu"};
        String[] thongTinDiLai = {"May Bay","Tau Thuyen","O To","Khac"};
        String[] trieuChung = {"Sốt","Ho","Khó thở","Đau họng","Nôn/Buồn Nôn","Tiêu chảy","Xuất huyết ngoài da","Nổi ban ngoài da","Không"};
        String[] lichSuPhoiNhiem = {"Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vậy",
        "Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV","Không"};
        model.addAttribute("gioiTinh",gioiTinh);
        model.addAttribute("thongTinDiLai",thongTinDiLai);
        model.addAttribute("trieuChung",trieuChung);
        model.addAttribute("lichSuPhoiNhiem",lichSuPhoiNhiem);


        model.addAttribute("medicalDeclaration",new MedicalDeclaration());
        return "medical_declaration";
    }

    @PostMapping("updateMedicalDeclaration")
    public String updateMedicalDeclaration(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model){
        model.addAttribute("medicalDeclaration",medicalDeclaration);
        return "info";
    }
}
