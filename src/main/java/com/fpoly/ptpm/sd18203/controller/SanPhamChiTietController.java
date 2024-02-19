package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.SanPhamChiTietDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamDTO;
import com.fpoly.ptpm.sd18203.entities.KichThuoc;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import com.fpoly.ptpm.sd18203.entities.SanPhamChiTiet;
import com.fpoly.ptpm.sd18203.repositories.KichThuocRepository;
import com.fpoly.ptpm.sd18203.repositories.MauSacRepository;
import com.fpoly.ptpm.sd18203.repositories.SanPhamChiTietRepository;
import com.fpoly.ptpm.sd18203.repositories.SanPhamRepository;
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
@RequestMapping("/san-pham-chi-tiet")
public class SanPhamChiTietController {

    //    Sản phẩm chi tiết Repository
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;


    //  Màu sắc Repository
    @Autowired
    private MauSacRepository mauSacRepository;

    // Kích Thước Repository
    @Autowired
    private KichThuocRepository kichThuocRepository;

    // Sản phẩm Repository
    @Autowired
    private SanPhamRepository sanPhamRepository;


    @GetMapping("show-product-detail")
    public String getProductDetail(Model model,   @RequestParam("page") Optional<Integer> pageParam) {



        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page,10);
        Page<SanPhamChiTiet> pageSanPhamChiTiet= this.sanPhamChiTietRepository.findByTrangThai(this.sanPhamChiTietRepository.ACTIVE,p);
        model.addAttribute("pageSanPhamChiTiet",pageSanPhamChiTiet);
//        model.addAttribute("listProductDetail", sanPhamChiTietRepository.findAll());
        return "admin/san_pham_chi_tiet/showProductDetail";
    }

    @GetMapping("create-product-detail")
    public String createProductDetail(Model model) {
        SanPhamChiTietDTO sanPhamChiTietDTO = new SanPhamChiTietDTO();
        model.addAttribute("productDetail", sanPhamChiTietDTO);
        model.addAttribute("colorList", this.mauSacRepository.findAll());
        model.addAttribute("sizeList", this.kichThuocRepository.findAll());
        model.addAttribute("productList", this.sanPhamRepository.findAll());

        return "admin/san_pham_chi_tiet/create";
    }

    @PostMapping("create-product-detail")
    public String createProductDetail(Model model,
                                      @Valid @ModelAttribute("productDetail") SanPhamChiTietDTO sanPhamChiTietDTO,
                                      BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("Lỗi");
            model.addAttribute("colorList", this.mauSacRepository.findAll());
            model.addAttribute("sizeList", this.kichThuocRepository.findAll());
            model.addAttribute("productList", this.sanPhamRepository.findAll());
            return "admin/san_pham_chi_tiet/create";
        }

        // Check if the product detail already exists for the given product, color, and size

        SanPhamChiTiet existingDetail = this.sanPhamChiTietRepository.findBySanPhamAndMauSacAndKichThuoc(
                sanPhamChiTietDTO.getIdSanPham(), sanPhamChiTietDTO.getIdMauSac(), sanPhamChiTietDTO.getIdKichThuoc());

        if (existingDetail != null) {
            // If the detail exists, update its quantity
            existingDetail.setSoLuong(existingDetail.getSoLuong() + sanPhamChiTietDTO.getSoLuong());
            this.sanPhamChiTietRepository.save(existingDetail);
        } else {
            // If the detail doesn't exist, create a new one
            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
            sanPhamChiTiet.setMaSPCT(sanPhamChiTietDTO.getMaSPCT());
            sanPhamChiTiet.setDonGia(sanPhamChiTietDTO.getDonGia());
            sanPhamChiTiet.setSoLuong(sanPhamChiTietDTO.getSoLuong());
            sanPhamChiTiet.setTrangThai(sanPhamChiTietDTO.getTrangThai());

            // Retrieve and set the selected MauSac, KichThuoc, and SanPham objects
            MauSac mauSac = this.mauSacRepository.findById(sanPhamChiTietDTO.getIdMauSac()).get();
            KichThuoc kichThuoc = this.kichThuocRepository.findById(sanPhamChiTietDTO.getIdKichThuoc()).get();
            SanPham sanPham = this.sanPhamRepository.findById(sanPhamChiTietDTO.getIdSanPham()).get();

            sanPhamChiTiet.setIdMauSac(mauSac);
            sanPhamChiTiet.setIdKichThuoc(kichThuoc);
            sanPhamChiTiet.setIdSanPham(sanPham);

            // Save the SanPhamChiTiet object
            this.sanPhamChiTietRepository.save(sanPhamChiTiet);
        }

        return "redirect:/san-pham-chi-tiet/show-product-detail";
    }

    @GetMapping("/edit-product-detail/{id}")
    public String editProductDetail(@PathVariable(name = "id") SanPhamChiTiet sanPhamChiTiet, Model model) {

        model.addAttribute("productDetail", sanPhamChiTiet);
        model.addAttribute("colorList", this.mauSacRepository.findAll());
        model.addAttribute("sizeList", this.kichThuocRepository.findAll());
        model.addAttribute("productList", this.sanPhamRepository.findAll());
        return "admin/san_pham_chi_tiet/edit";
    }

    @PostMapping("/edit-product-detail/{id}")
    public String editProductDetail(
            @Valid
            @ModelAttribute("productDetail") SanPhamChiTietDTO sanPhamChiTietDTO,
            BindingResult result,
            @PathVariable(name = "id") SanPhamChiTiet sanPhamChiTiet) {

        if (result.hasErrors()) {
            return "admin/san_pham_chi_tiet/editProductDetail";
        }


        sanPhamChiTiet.setMaSPCT(sanPhamChiTietDTO.getMaSPCT());
        sanPhamChiTiet.setDonGia(sanPhamChiTietDTO.getDonGia());
        sanPhamChiTiet.setSoLuong(sanPhamChiTietDTO.getSoLuong());
        sanPhamChiTiet.setTrangThai(sanPhamChiTietDTO.getTrangThai());

        // Retrieve and set the selected MauSac, KichThuoc, and SanPham objects
        MauSac mauSac = this.mauSacRepository.findById(sanPhamChiTietDTO.getIdMauSac()).get();
        KichThuoc kichThuoc = this.kichThuocRepository.findById(sanPhamChiTietDTO.getIdKichThuoc()).get();
        SanPham sanPham = this.sanPhamRepository.findById(sanPhamChiTietDTO.getIdSanPham()).get();

        if (mauSac != null && kichThuoc != null && sanPham != null) {
            sanPhamChiTiet.setIdMauSac(mauSac);
            sanPhamChiTiet.setIdKichThuoc(kichThuoc);
            sanPhamChiTiet.setIdSanPham(sanPham);
        } else {
            // Handle the case where one of the entities is not found
            return "admin/san_pham_chi_tiet/create";
        }

        // Save the SanPhamChiTiet object
        this.sanPhamChiTietRepository.save(sanPhamChiTiet);

        return "redirect:/san-pham-chi-tiet/show-product-detail";
    }

    @GetMapping("/delete-product-detail/{id}")
    public String deleteProductDetail(@PathVariable(name = "id") int idProductDetail) {
        // Xóa sản phẩm chi tiết
        this.sanPhamChiTietRepository.deleteById(idProductDetail);
        return "redirect:/san-pham-chi-tiet/show-product-detail";
    }


}
