package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.KichThuocDTO;
import com.fpoly.ptpm.sd18203.entities.KichThuoc;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.repositories.KichThuocRepository;
import com.fpoly.ptpm.sd18203.repositories.MauSacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kich-thuoc")
public class KichThuocController {


    @Autowired
    private KichThuocRepository kichThuocRepository;


    @GetMapping("show-size")
    public String getAllSize(Model model,
                             @RequestParam("page") Optional<Integer> pageParam) {

        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<KichThuoc> pageKichThuoc = this.kichThuocRepository.findAll(p);

        model.addAttribute("pageKichThuoc", pageKichThuoc);

        return "admin/ql_kichthuoc/indexSize";
    }


    @GetMapping("create-size")
    public String createSize(Model model) {

        KichThuocDTO kichThuocDTO = new KichThuocDTO();
        model.addAttribute("size",kichThuocDTO );
        return "admin/ql_kichthuoc/create";
    }

    //Chắc năng thêm kích thước
    @PostMapping("create-size")
    public String createSize(
            @Valid @ModelAttribute("size") KichThuocDTO req,
            BindingResult result)
    {

        if (result.hasErrors()) {
            System.out.println("Lỗi");
            return "admin/ql_kichthuoc/create";
        }



        KichThuoc  kichThuoc  = new KichThuoc(req.getMa(),req.getTen(),Integer.parseInt(req.getTrangThai()));
        this.kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/show-size";
    }


    //Chức năng xóa Kích thước
    @GetMapping("delete-size")
    public String deleteSize(Model model, @RequestParam(name = "id") int idKichThuoc) {
        System.out.println(idKichThuoc);
        // Lặp qua danh sách để tìm đối tượng có id cần xóa
        kichThuocRepository.deleteById(idKichThuoc);
        return "redirect:/kich-thuoc/show-size";
    }

    // Chức năng sửa kích thước
    @GetMapping("edit-size/{id}")
    public String editSize(
            Model model,
            @PathVariable(name = "id") KichThuoc kichThuoc)
    {
        model.addAttribute("size", kichThuoc);
        return "admin/ql_kichthuoc/edit";
    }


    @PostMapping("edit-size/{id}")
    public String editSize(
            @Valid @ModelAttribute("size") KichThuocDTO kichThuocDTO,
            BindingResult result,
            @PathVariable(name = "id") KichThuoc kichThuoc) {
        if (result.hasErrors()) {
            return "admin/ql_kichthuoc/edit";
        }

        kichThuoc.setMa(kichThuocDTO.getMa());
        kichThuoc.setTen(kichThuocDTO.getTen());
        kichThuoc.setTrangThai(Integer.parseInt(kichThuocDTO.getTrangThai()));

        kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/show-size";
    }


}
