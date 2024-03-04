package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.KhachHangDTO;
import com.fpoly.ptpm.sd18203.entities.KhachHang;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.repositories.KhachHangRepository;
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
@RequestMapping("/khach-hang")
public class KhachHangController {


    private List<KhachHangDTO> listKH;

    @Autowired
    private KhachHangRepository khachHangRepository;


    @GetMapping("show-customer")
    public String getAllCustomer(Model model,
                                 @RequestParam("page") Optional<Integer> pageParam

    ) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<KhachHang> pageKhachHang = this.khachHangRepository.findAll(p);
        model.addAttribute("pageKhachHang", pageKhachHang);

        return "admin/khach_hang/indexKH";
    }


    @GetMapping("create-customer")
    public String createCustomer(Model model) {

        KhachHangDTO khachHangDTO = new KhachHangDTO();
        model.addAttribute("customer", khachHangDTO);
        return "admin/khach_hang/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(
            @Valid @ModelAttribute("customer") KhachHangDTO req,
            BindingResult result) {

        if (result.hasErrors()) {
            return "admin/khach_hang/create";
        }

        KhachHang khachHang = new KhachHang(req.getMa(), req.getTen(), req.getSdt(), (req.getTrangThai()));

        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/show-customer";
    }


    @GetMapping("delete-customer/{id}")
    public String deleteCustomer(Model model, @PathVariable(name = "id") int idCustomer) {
        this.khachHangRepository.deleteById(idCustomer);
        return "redirect:/khach-hang/show-customer";
    }

    @GetMapping("/edit-customer/{id}")
    public String editCustomer(
            Model model,
            @PathVariable(name = "id") KhachHang khachHang) {

        model.addAttribute("customer", khachHang);

        return "admin/khach_hang/edit";
    }


    @PostMapping("/edit-customer/{id}")
    public String editCustomer(
            @Valid @ModelAttribute("customer") KhachHangDTO khachHangDTO,
            BindingResult result,
            @PathVariable(name = "id") KhachHang khachHang) {

        if (result.hasErrors()) {
            return "admin/khach_hang/edit";
        }

        khachHang.setMa(khachHangDTO.getMa());
        khachHang.setTen(khachHangDTO.getTen());
        khachHang.setSdt(khachHangDTO.getSdt());
        khachHang.setTrangThai((khachHangDTO.getTrangThai()));

        this.khachHangRepository.save(khachHang);


        return "redirect:/khach-hang/show-customer";
    }


}
