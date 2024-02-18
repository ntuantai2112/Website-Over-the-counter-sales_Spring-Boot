package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.HoaDonDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamDTO;
import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.KhachHang;
import com.fpoly.ptpm.sd18203.entities.NhanVien;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import com.fpoly.ptpm.sd18203.repositories.HoaDonRepository;
import com.fpoly.ptpm.sd18203.repositories.KhachHangRepository;
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

import java.util.Optional;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {


  @Autowired
  private HoaDonRepository hoaDonRepository;

  @Autowired
  private NhanVienRepository nhanVienRepository;

  @Autowired
  private KhachHangRepository khachHangRepository;

    @GetMapping("show-bill")
    public String showBill(Model model,   @RequestParam("page") Optional<Integer> pageParam){

        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<HoaDon> pageHoaDon = this.hoaDonRepository.findAll(p);
        model.addAttribute("pageHoaDon", pageHoaDon);
        return "admin/hoa_don/indexBill";
    }

    @GetMapping("create-bill")
    public String createBill(Model model) {

        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        model.addAttribute("bill", hoaDonDTO);
        model.addAttribute("listCustomer", khachHangRepository.findAll());
        model.addAttribute("listEmp", nhanVienRepository.findAll());
        return "admin/hoa_don/create";
    }


    //    Hàm xử lý thêm mới hóa đơn
    @PostMapping("/create-bill")
    public String createBill(Model model,
            @Valid @ModelAttribute("bill") HoaDonDTO req,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("listCustomer", khachHangRepository.findAll());
            model.addAttribute("listEmp", nhanVienRepository.findAll());
            return "admin/hoa_don/create";
        }

        HoaDon hoaDon = new HoaDon();

        KhachHang khachHang = this.khachHangRepository.findById(req.getIdKhachHang()).get();
        NhanVien nhanVien = this.nhanVienRepository.findById(req.getIdNhanVien()).get();

        hoaDon.setIdKhachHang(khachHang);
        hoaDon.setIdNhanVien(nhanVien);
        hoaDon.setNgayMuaHang(req.getNgayMuaHang());
        hoaDon.setTrangThai(req.getTrangThai());

        this.hoaDonRepository.save(hoaDon);

        return "redirect:/hoa-don/show-bill";
    }


    @GetMapping("delete-bill/{id}")
    public String deleteBill(Model model, @PathVariable(name = "id") int idBill) {
        this.hoaDonRepository.deleteById(idBill);
        return "redirect:/hoa-don/show-bill";
    }

    //Xem chi tiết hóa đơn
    @GetMapping("bill-detail/{id}")
    public String DetailBill(Model model, @PathVariable(name = "id") int idBill) {
        this.hoaDonRepository.deleteById(idBill);
        return "redirect:/hoa-don/show-bill";
    }

    @GetMapping("/edit-bill/{id}")
    public String editBill(Model model, @PathVariable(name = "id") HoaDon hoaDon) {

        model.addAttribute("bill", hoaDon);
        model.addAttribute("listCustomer", khachHangRepository.findAll());
        model.addAttribute("listEmp", nhanVienRepository.findAll());

        return "admin/hoa_don/edit";
    }


    @PostMapping("/update-bill/{id}")
    public String editBill(
            @Valid
            @ModelAttribute("bill") HoaDonDTO req,
            BindingResult result,
            @PathVariable(name = "id") HoaDon hoaDon) {

        if (result.hasErrors()) {
            return "admin/hoa-don/edit";
        }


         KhachHang khachHang = this.khachHangRepository.findById(req.getIdKhachHang()).get();
        NhanVien nhanVien = this.nhanVienRepository.findById(req.getIdNhanVien()).get();

        hoaDon.setIdKhachHang(khachHang);
        hoaDon.setIdNhanVien(nhanVien);
        hoaDon.setNgayMuaHang(req.getNgayMuaHang());
        hoaDon.setTrangThai(req.getTrangThai());

        this.hoaDonRepository.save(hoaDon);

        return "redirect:/hoa-don/show-bill";
    }




}
