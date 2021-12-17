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

        model.addAttribute("hoTen", medicalDeclaration.getHoTen());
        model.addAttribute("namSinh", medicalDeclaration.getNamSinh());
        model.addAttribute("gioiTinh", medicalDeclaration.getGioiTinh());
        model.addAttribute("quocTich", medicalDeclaration.getQuocTich());
        model.addAttribute("soCMND", medicalDeclaration.getSoCMND());
        model.addAttribute("thongTinDiLai", medicalDeclaration.getThongTinDiLai());
        model.addAttribute("bienSoXe", medicalDeclaration.getBienSoXe());
        model.addAttribute("soGhe", medicalDeclaration.getSoGhe());
        model.addAttribute("ngayKhoiHanh", medicalDeclaration.getNgayKhoiHanh());
        model.addAttribute("ngayKetThuc", medicalDeclaration.getNgayKetThuc());
        model.addAttribute("moTa", medicalDeclaration.getMoTa());
        model.addAttribute("diaChiLienLac", medicalDeclaration.getDiaChiLienLac());
        model.addAttribute("diaChiNoiO", medicalDeclaration.getDiaChiNoiO());
        model.addAttribute("soDienThoai", medicalDeclaration.getSoDienThoai());
        model.addAttribute("email", medicalDeclaration.getEmail());
        model.addAttribute("trieuChung", medicalDeclaration.getTrieuChung());
        model.addAttribute("lichSuPhoiNhiem", medicalDeclaration.getLichSuPhoiNhiem());
//        model.addAttribute("medicalDeclaration",medicalDeclaration);
        return "info";
    }
}
