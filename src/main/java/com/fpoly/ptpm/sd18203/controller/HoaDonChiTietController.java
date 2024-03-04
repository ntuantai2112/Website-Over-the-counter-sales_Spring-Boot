package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.HoaDonChiTietDTO;
import com.fpoly.ptpm.sd18203.dto.HoaDonDTO;
import com.fpoly.ptpm.sd18203.entities.*;
import com.fpoly.ptpm.sd18203.repositories.HoaDonChiTietRepository;
import com.fpoly.ptpm.sd18203.repositories.HoaDonRepository;
import com.fpoly.ptpm.sd18203.repositories.SanPhamChiTietRepository;
import com.fpoly.ptpm.sd18203.repositories.SanPhamRepository;
import com.fpoly.ptpm.sd18203.service.ProductService;
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
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {


    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;


    // Xử lý lấy ra sản phẩm chi tiết
    @GetMapping("/show-billDetail")
    public String showBillDetail(Model model, @RequestParam("page") Optional<Integer> pageParam) {

        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<HoaDonChiTiet> pageHoaDonChiTiet = this.hoaDonChiTietRepository.findAll(p);
        model.addAttribute("pageHoaDonChiTiet", pageHoaDonChiTiet);
        return "admin/hoa_don_chi_tiet/indexBillDetail";
    }


    @GetMapping("create-billDetail")
    public String createBillDetail(Model model) {

        HoaDonChiTietDTO hoaDonChiTietDTO = new HoaDonChiTietDTO();
        model.addAttribute("billDetail", hoaDonChiTietDTO);
        model.addAttribute("listBill", hoaDonRepository.findAll());
        model.addAttribute("listProductDetail", sanPhamChiTietRepository.findAll());
        return "admin/hoa_don_chi_tiet/create";
    }


    //    Hàm xử lý thêm mới hóa đơn
    @PostMapping("/create-billDetail")
    public String createBillDetail(Model model,
                                   @Valid @ModelAttribute("billDetail") HoaDonChiTietDTO req,
                                   BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("listBill", hoaDonRepository.findAll());
            model.addAttribute("listProductDetail", sanPhamChiTietRepository.findAll());
            return "admin/hoa_don_chi_tiet/create";
        }

        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

        HoaDon hoaDon = this.hoaDonRepository.findById(req.getIdHoaDon()).get();
        SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepository.findById(req.getIdSanPhamChiTiet()).get();

        hoaDonChiTiet.setIdHoaDon(hoaDon);
        hoaDonChiTiet.setIdSanPhamChiTiet(sanPhamChiTiet);
        hoaDonChiTiet.setThoiGian(req.getThoiGian());
        hoaDonChiTiet.setSoLuong(req.getSoLuong());
        hoaDonChiTiet.setDonGia(req.getDonGia());
        hoaDonChiTiet.setTrangThai(req.getTrangThai());

        this.hoaDonChiTietRepository.save(hoaDonChiTiet);

        return "redirect:/hoa-don-chi-tiet/show-billDetail";
    }

    @GetMapping("delete-billDetail/{id}")
    public String deleteBillDetail(Model model, @PathVariable(name = "id") int idBillDetail) {
        this.hoaDonChiTietRepository.deleteById(idBillDetail);
        return "redirect:/hoa-don-chi-tiet/show-billDetail";
    }

    @GetMapping("/edit-billDetail/{id}")
    public String editBillDetail(Model model, @PathVariable(name = "id") HoaDonChiTiet req) {

        model.addAttribute("billDetail", req);
        model.addAttribute("listBill", hoaDonRepository.findAll());
        model.addAttribute("listProductDetail", sanPhamChiTietRepository.findAll());

        return "admin/hoa_don_chi_tiet/edit";
    }


    @PostMapping("/update-billDetail/{id}")
    public String editBillDetail(Model model,
                                 @Valid
                                 @ModelAttribute("billDetail") HoaDonChiTietDTO req,
                                 BindingResult result,
                                 @PathVariable(name = "id") HoaDonChiTiet hoaDonChiTiet) {

        if (result.hasErrors()) {
            model.addAttribute("listBill", hoaDonRepository.findAll());
            model.addAttribute("listProductDetail", sanPhamChiTietRepository.findAll());
            return "admin/hoa_don_chi_tiet/edit";
        }


        HoaDon hoaDon = this.hoaDonRepository.findById(req.getIdHoaDon()).get();
        SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepository.findById(req.getIdSanPhamChiTiet()).get();

        hoaDonChiTiet.setIdHoaDon(hoaDon);
        hoaDonChiTiet.setIdSanPhamChiTiet(sanPhamChiTiet);
        hoaDonChiTiet.setThoiGian(req.getThoiGian());
        hoaDonChiTiet.setSoLuong(req.getSoLuong());
        hoaDonChiTiet.setDonGia(req.getDonGia());
        hoaDonChiTiet.setTrangThai(req.getTrangThai());

        this.hoaDonChiTietRepository.save(hoaDonChiTiet);

        return "redirect:/hoa-don-chi-tiet/show-billDetail";

    }


}
