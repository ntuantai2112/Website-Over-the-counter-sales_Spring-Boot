package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.NhanVienDTO;
import com.fpoly.ptpm.sd18203.entities.NhanVien;
import com.fpoly.ptpm.sd18203.repositories.NhanVienRepository;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {


    private List<NhanVienDTO> listNV;

    @Autowired
    private NhanVienRepository nhanVienRepository;


    @GetMapping("show-employee")
    public String getEmployee(Model model,
                              @RequestParam("page") Optional<Integer> pageParam

    ) {

        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<NhanVien> pageNhanVien = nhanVienRepository.findAll(p);


        model.addAttribute("pageNhanVien", pageNhanVien);

        return "admin/nhan_vien/indexNV";
    }


    @GetMapping("create-employee")
    public String createEmployee(Model model) {

        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        model.addAttribute("employee", nhanVienDTO);
        return "admin/nhan_vien/create";
    }

    @PostMapping("/create-employee")
    public String createEmployee(
            @Valid @ModelAttribute("employee") NhanVienDTO req,
            BindingResult result) {

        if (result.hasErrors()) {
            return "admin/nhan_vien/create";
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(req.getMa());
        nhanVien.setTen(req.getTen());
        nhanVien.setTenDangNhap(req.getTenDangNhap());
        nhanVien.setMatKhau(req.getMatKhau());
        nhanVien.setTrangThai(req.getTrangThai());

        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/show-employee";
    }

    @GetMapping("delete-employee/{id}")
    public String deleteEmployee(Model model, @PathVariable(name = "id") int idEmployee) {
        this.nhanVienRepository.deleteById(idEmployee);
        return "redirect:/nhan-vien/show-employee";
    }

    @GetMapping("/edit-employee/{id}")
    public String editEmployee(Model model, @PathVariable(name = "id") NhanVien nhanVien) {

        model.addAttribute("employee", nhanVien);

        return "admin/nhan_vien/edit";
    }


    @PostMapping("/edit-employee/{id}")
    public String editEmployee(
            @Valid
            @ModelAttribute("employee") NhanVienDTO req,
            BindingResult result,
            @PathVariable(name = "id") NhanVien nhanVien) {

        if (result.hasErrors()) {
            return "admin/nhan_vien/edit";
        }

        nhanVien.setMa(req.getMa());
        nhanVien.setTen(req.getTen());
        nhanVien.setTenDangNhap(req.getTenDangNhap());
        nhanVien.setMatKhau(req.getMatKhau());
        nhanVien.setTrangThai(req.getTrangThai());
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/show-employee";
    }


}
