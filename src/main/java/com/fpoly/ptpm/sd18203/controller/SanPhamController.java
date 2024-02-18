package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.KichThuocDTO;
import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamChiTietDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamDTO;
//import com.fpoly.ptpm.sd18203.service.ProductService;
import com.fpoly.ptpm.sd18203.entities.NhanVien;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import com.fpoly.ptpm.sd18203.repositories.NhanVienRepository;
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

import java.util.*;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {



    @Autowired
    private SanPhamRepository sanPhamRepository;


    @GetMapping("show-product")
    public String getProduct(Model model,   @RequestParam("page") Optional<Integer> pageParam) {


        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page,10);
        Page<SanPham> pageSanPham= this.sanPhamRepository.findAll(p);
        model.addAttribute("pageSanPham",pageSanPham);

//        model.addAttribute("pageSanPham", sanPhamRepository.findAll());
        return "admin/san_pham/indexSP";
    }


//    @GetMapping("show-product-detail")
//    public String getProductDetail(Model model) {
//        model.addAttribute("listProductDetail", sanPhamChiTietDTOList);
//        return "admin/san_pham_chi_tiet/showProductDetail";
//    }


    // Xử lý lấy ra sản phẩm chi tiết
//    @GetMapping("/product/{productId}")
//    public String showProductDetail(@PathVariable(name = "productId") int productId, Model model) {
//
//        System.out.println(productId);
////        SanPhamDTO sanPhamDTO = getSanPhamById(productId);
//
//        if (sanPhamDTO != null) {
//            SanPhamChiTietDTO sanPhamChiTietDTO = getSanPhamChiTietById(productId);
//            model.addAttribute("product", sanPhamDTO);
//            model.addAttribute("productDetail", sanPhamChiTietDTO);
//            return "admin/san_pham_chi_tiet/indexProductDetail";
//        }
//        return "redirect:/san-pham/show-product";
//    }


    @GetMapping("create-product")
    public String createProduct(Model model) {

        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        model.addAttribute("product", sanPhamDTO);
        return "admin/san_pham/create";
    }


//    Hàm xử lý thêm mới sản phẩm
    @PostMapping("/create-product")
    public String createProduct(
            @Valid @ModelAttribute("product") SanPhamDTO req,
            BindingResult result) {

        if (result.hasErrors()) {
            return "admin/san_pham/create";
        }

        SanPham sanPham = new SanPham();
        sanPham.setMa(req.getMa());
        sanPham.setTen(req.getTen());
        sanPham.setTrangThai(req.getTrangThai());
        this.sanPhamRepository.save(sanPham);

        return "redirect:/san-pham/show-product";
    }


    @GetMapping("delete-product/{id}")
    public String deleteProduct(Model model, @PathVariable(name = "id") int idProduct) {
        this.sanPhamRepository.deleteById(idProduct);
        return "redirect:/san-pham/show-product";
    }

    @GetMapping("/edit-product/{id}")
    public String editProduct(Model model, @PathVariable(name = "id") SanPham sanPham) {

        model.addAttribute("product", sanPham);

        return "admin/san_pham/edit";
    }


    @PostMapping("/edit-product/{id}")
    public String editProduct(
            @Valid
            @ModelAttribute("product") SanPhamDTO req,
            BindingResult result,
            @PathVariable(name = "id") SanPham sanPham) {

        if (result.hasErrors()) {
            return "admin/san_pham/edit";
        }

        sanPham.setMa(req.getMa());
        sanPham.setTen(req.getTen());
        sanPham.setTrangThai(req.getTrangThai());
        this.sanPhamRepository.save(sanPham);

        return "redirect:/san-pham/show-product";
    }


}
