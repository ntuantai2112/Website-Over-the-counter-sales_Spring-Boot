package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.config.UserInfo;
import com.fpoly.ptpm.sd18203.dto.HoaDonChiTietDTO;
import com.fpoly.ptpm.sd18203.dto.HoaDonDTO;
import com.fpoly.ptpm.sd18203.entities.*;
import com.fpoly.ptpm.sd18203.repositories.*;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ban-hang")
public class BanHangController {

    private int stt = 0;

    @Autowired
    HttpSession session;


    @Autowired
    private HoaDonRepository hoaDonRepository;


    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichThuocRepository kichThuocRepository;
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    List<HoaDon> listHD;


    // Trang home giao diện Bán hàng
    @GetMapping("sell")
    public String sell(Model model, HoaDonDTO hoaDonDTO,
                       @RequestParam("page") Optional<Integer> reqParam,
                       RedirectAttributes redirectAttributes) {

        int page = reqParam.orElse(0);
        Pageable p = PageRequest.of(page, 5);
        model.addAttribute("listHD", this.hoaDonRepository.findAllByTrangThai(this.hoaDonRepository.INACTIVE));
        Page<SanPhamChiTiet> pageSanPhamChiTiet = this.sanPhamChiTietRepository.findByTrangThai(SanPhamRepository.ACTIVE, p);
        model.addAttribute("pageSanPhamChiTiet", pageSanPhamChiTiet);
        model.addAttribute("listKH", this.khachHangRepository.findAll());
        model.addAttribute("data", hoaDonDTO);

        if (redirectAttributes.containsAttribute("success")) {
            model.addAttribute("success", redirectAttributes.getAttribute("success"));
        }
        return "admin/ban_hang/banHang";
    }

    //Xóa hóa đơn chờ
    @GetMapping("delete-bill/{id}")
    public String deleteProduct(Model model, @PathVariable(name = "id") int idBill) {
        System.out.println(idBill);
        this.hoaDonRepository.deleteById(idBill);
        listHD = this.hoaDonRepository.findAllByTrangThai(HoaDonRepository.INACTIVE);
        model.addAttribute("listHD", listHD);
        return "redirect:/ban-hang/sell";
    }


    //Tạo hóa đơn chờ
    @GetMapping("add-hoa-don")
    public String addHoaDonGetMapring(Model model, HoaDonDTO data,
                                      @RequestParam("page") Optional<Integer> reqParam) {


        List<HoaDon> hoaDonList = this.hoaDonRepository.findAllByTrangThai(this.hoaDonRepository.INACTIVE);
        if (hoaDonList.size() >= 5) {
            model.addAttribute("error", "Không được vượi quá 5 hóa đơn chờ");
            model.addAttribute("listHD", hoaDonList);
            model.addAttribute("data", data);
            return "admin/ban_hang/banHang"; // Trả về trang banHang với thông báo lỗi
        }

//        Thêm mới hóa đơn chờ
        HoaDon hoaDon = new HoaDon();
        Date ngayTao = new Date();
        hoaDon.setNgayMuaHang(ngayTao);
        hoaDon.setIdNhanVien(this.nhanVienRepository.findById(1).get());
        hoaDon.setTrangThai(0);

        this.hoaDonRepository.save(hoaDon);
        model.addAttribute("listHD", this.hoaDonRepository.findAllByTrangThai(this.hoaDonRepository.INACTIVE));
        model.addAttribute("data", data);
        return "admin/ban_hang/banHang";


    }


    //  Thêm Sản Phẩm vào giỏ hàng
//    @GetMapping("gio-hang/add-to-cart/{idSanPhamChiTiet}")
//    public String addToCart(Model model,
//                            @PathVariable("idSanPhamChiTiet") Integer idSPCT,
//                            @ModelAttribute("data") HoaDon hoaDon,
//                            @RequestParam("page") Optional<Integer> reqParam) {
//
//
//        UserInfo userInfo = new UserInfo();
//        Integer idHoaDon = userInfo.idHoaDon;
//
//        if(idHoaDon == null){
//            System.out.println("Lỗi null");
//        }
//
////        Lấy ra Hóa đơn theo IdHoaDon
//        hoaDon = this.hoaDonRepository.findById(userInfo.idHoaDon).get();
//        if (hoaDon == null){
//            HoaDon newHoaDon = new HoaDon();
//            newHoaDon.setNgayMuaHang(new Date());
//            newHoaDon.setIdNhanVien(this.nhanVienRepository.findById(1).orElse(null));
//            newHoaDon.setTrangThai(0);
//            this.hoaDonRepository.save(newHoaDon);
//        }
//
//
////       Lấy ra Sản Phẩm chi Tiết Theo idSPCT
//        SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepository.findById(idSPCT).get();
//
//
////      Phân trang
//        int page = reqParam.orElse(0);
//        Pageable p = PageRequest.of(page, 5);
//        Page<SanPhamChiTiet> pageSanPhamChiTiet = this.sanPhamChiTietRepository.findByTrangThai(SanPhamRepository.ACTIVE, p);
//        model.addAttribute("pageSanPhamChiTiet", pageSanPhamChiTiet);
//
//        //Trường hợp : Sản phẩm đã có trong giỏ hàng thì cập nhật lại số lượng sản phẩm vào trong giỏ hàng
//
//        //        Tìm sản phẩm trong giỏ hàng
//        boolean spTonTaiTrongGioHang = false;
//        for (HoaDonChiTiet hoaDonChiTiet : this.hoaDonChiTietRepository.findAll()) {
//            if (hoaDonChiTiet.getIdSanPhamChiTiet().getId() == idSPCT && hoaDonChiTiet.getIdHoaDon().getId() == idHoaDon) {
//                if (sanPhamChiTiet.getSoLuong() <= 0) {
//                    model.addAttribute("errMessage", "Số lượng trong kho không đủ hàng");
//                }
//                sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() - 1);
//                hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + 1);// Nếu sản phẩm đã tồn tại, tăng số lượng lên
//                this.hoaDonChiTietRepository.save(hoaDonChiTiet);
//                this.sanPhamChiTietRepository.save(sanPhamChiTiet);
//                spTonTaiTrongGioHang = true;
//                break;
//            }
//        }
//
//
//        //Trường hợp : Sản phẩm chưa có trong giỏ hàng thì thêm mới sản phẩm vào trong giỏ hàng
//
//        BigDecimal donGia = BigDecimal.ZERO;
//        if (!spTonTaiTrongGioHang) {
//            sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() - 1);
//
//            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
//            hoaDonChiTiet.setIdSanPhamChiTiet(sanPhamChiTiet);
//            hoaDonChiTiet.setIdHoaDon(hoaDon);
//            hoaDonChiTiet.setSoLuong(1);
//            hoaDonChiTiet.setDonGia(sanPhamChiTiet.getDonGia());
//            hoaDonChiTiet.setThoiGian(new Date());
//            hoaDonChiTiet.setTrangThai(this.hoaDonChiTietRepository.DA_XU_LY);
//
//            this.hoaDonChiTietRepository.save(hoaDonChiTiet);
//            this.sanPhamChiTietRepository.save(sanPhamChiTiet);
//
//        }
//
//
//        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByHoaDonId(hoaDon.getId());
//        model.addAttribute("listHDCT", gioHangTheoHoaDon);
//
//
//        return "redirect:/ban-hang/detail/" + userInfo.idHoaDon;
//
//
//    }

    //  Thêm Sản Phẩm vào giỏ hàng
    @GetMapping("gio-hang/add-to-cart/{idSanPhamChiTiet}")
    public String addToCart(Model model,
                            @PathVariable("idSanPhamChiTiet") Integer idSPCT,
                            @ModelAttribute("data") HoaDon hoaDon,
                            @RequestParam("page") Optional<Integer> reqParam) {

        UserInfo userInfo = new UserInfo();
        Integer idHoaDon = userInfo.idHoaDon;

//        if (idHoaDon == null || idHoaDon){
//            model.addAttribute("errBillNull","Vui lòng chọn hóa đơn muốn thêm sản phẩm");
//        }

        // Lấy hoặc tạo mới đối tượng HoaDon
        hoaDon = this.hoaDonRepository.findById(idHoaDon).orElseGet(() -> {
            HoaDon newHoaDon = new HoaDon();
            newHoaDon.setNgayMuaHang(new Date());
            newHoaDon.setIdNhanVien(this.nhanVienRepository.findById(1).orElse(null));
            newHoaDon.setTrangThai(0);
            return this.hoaDonRepository.save(newHoaDon);
        });

        // Lấy thông tin Sản Phẩm Chi Tiết
        SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepository.findById(idSPCT).orElse(null);

        // Kiểm tra và cập nhật số lượng
        if (hoaDon != null && sanPhamChiTiet != null) {
//            Kiểm tra số lượng chi tiết sản phẩm  đó trong kho, nếu hết thì báo lỗi
            if (sanPhamChiTiet.getSoLuong() <= 0) {
                model.addAttribute("errMessage", "Số lượng trong kho không đủ hàng");
            } else {
//              Trừ số lượng sản phẩm trong kho
                sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() - 1);
//              Tìm kiếm hóa đơn chi tiết theo HoaDon và SanPhamChiTiet
                HoaDonChiTiet hoaDonChiTiet = this.hoaDonChiTietRepository.findByHoaDonAndIdSanPhamChiTiet(hoaDon, sanPhamChiTiet);
                if (hoaDonChiTiet != null) {
                    // Trường hợp nếu đã có phẩm phẩm trong giỏ hàng thì cập nhật số lượng
                    hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + 1);
                } else {
//                    Trường hợp chưa có sản phẩm trong giỏ hàng thì thêm mới sản phẩm vào giỏ hàng
                    hoaDonChiTiet = new HoaDonChiTiet();
                    hoaDonChiTiet.setIdSanPhamChiTiet(sanPhamChiTiet);
                    hoaDonChiTiet.setIdHoaDon(hoaDon);
                    hoaDonChiTiet.setSoLuong(1);
                    hoaDonChiTiet.setDonGia(sanPhamChiTiet.getDonGia());
                    hoaDonChiTiet.setThoiGian(new Date());
                    hoaDonChiTiet.setTrangThai(this.hoaDonChiTietRepository.DANG_XU_LY);
                }

                this.hoaDonChiTietRepository.save(hoaDonChiTiet);
                this.sanPhamChiTietRepository.save(sanPhamChiTiet);
            }
        }

        // Lấy danh sách sản phẩm chi tiết theo hóa đơn
        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByHoaDonId(hoaDon.getId());
        model.addAttribute("listHDCT", gioHangTheoHoaDon);

        return "redirect:/ban-hang/detail/" + idHoaDon;
    }


    //Hiển thị sản phẩm trong giỏ hàng theo từng hóa đơn
    @GetMapping("detail/{id}")
    public String HoaDonCT(Model model,
                           @RequestParam("page") Optional<Integer> reqParam,
                           @ModelAttribute("data") HoaDonDTO hoaDonDTO,
                           @PathVariable("id") HoaDon hoaDon,
                           RedirectAttributes redirectAttributes) {

        int page = reqParam.orElse(0);
        Pageable p = PageRequest.of(page, 5);
        Page<SanPhamChiTiet> pageSanPhamChiTiet = this.sanPhamChiTietRepository.findByTrangThai(SanPhamRepository.ACTIVE, p);
        model.addAttribute("pageSanPhamChiTiet", pageSanPhamChiTiet);
        model.addAttribute("listKH", this.khachHangRepository.findAll());
        model.addAttribute("listHD", this.hoaDonRepository.findAllByTrangThai(this.hoaDonRepository.INACTIVE));
        model.addAttribute("data", hoaDon);

        UserInfo userInfo = new UserInfo();
        model.addAttribute("idHoaDon", userInfo.idHoaDon = hoaDon.getId());


//        Lọc danh sách sản phẩm trong giỏ hàng cho hóa đơn được chọn
        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByHoaDonId(hoaDon.getId());
        if (gioHangTheoHoaDon != null) {
            model.addAttribute("listHDCT", gioHangTheoHoaDon);

            // Tính tổng tiền
            BigDecimal tongTien = BigDecimal.ZERO;
            for (HoaDonChiTiet hdct : gioHangTheoHoaDon) {
                int soLuong = hdct.getSoLuong();
                BigDecimal donGia = hdct.getDonGia();
                // Thay đổi cách tính thành phép nhân của BigDecimal
                BigDecimal thanhTien = donGia.multiply(BigDecimal.valueOf(soLuong));
                tongTien = tongTien.add(thanhTien);
//                model.addAttribute("soLuong", hdct.getSoLuong());

            }
            model.addAttribute("tongTien", tongTien);
        }

        if (redirectAttributes.containsAttribute("err")) {
            model.addAttribute("err", redirectAttributes.getAttribute("err"));
        }

        return "admin/ban_hang/banHang";
    }


//    PHương thức thanh toán
@PostMapping("/thanh-toan/{idHD}")
public String thanhToan(@PathVariable("idHD") Integer idHoaDon,

                        @ModelAttribute("idKhachHang") Integer idKhachHang,
                        RedirectAttributes redirectAttributes) {

    // 1. Xác thực dữ liệu (nếu cần)
    // 2. Lấy thông tin hóa đơn từ cơ sở dữ liệu
    HoaDon hoaDon = hoaDonRepository.findById(idHoaDon).orElse(null);
    HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(idHoaDon).orElse(null);

    // Xử lý khi không tìm thấy hóa đơn
    if (hoaDon == null) {
        redirectAttributes.addFlashAttribute("errorMessageBill", "Không tìm thấy hóa đơn");
        return "redirect:/ban-hang/detail/" + idHoaDon;
    }

    // 3. Thực hiện thanh toán
//    BigDecimal tongTien = hoaDonChiTiet.get();
//    if (tienKhachDua.compareTo(tongTien) < 0) {
//        // Xử lý khi số tiền khách hàng đưa không đủ
//        redirectAttributes.addFlashAttribute("errorMessageMoney", "Số tiền khách hàng đưa không đủ");
//        return "redirect:/ban-hang/detail/" + idHoaDon;
//    }

    // 4. Cập nhật trạng thái hóa đơn trong cơ sở dữ liệu
    hoaDon.setTrangThai(HoaDonRepository.ACTIVE);
    KhachHang khachHang = this.khachHangRepository.findById(idKhachHang).orElseGet(null);
    hoaDon.setIdKhachHang(khachHang);
    hoaDonRepository.save(hoaDon);

    // 5. Chuyển hướng và hiển thị kết quả
    redirectAttributes.addFlashAttribute("successMessage", "Thanh toán thành công!");
    return "redirect:/ban-hang/sell";
}


//    Chức năng xóa sản phẩm khỏi giỏ hàng
    @GetMapping("/gio-hang/remove-from-cart/{idSPCT}")
    public String deleteProductToCart(@PathVariable("idSPCT") int idSPCT) {

        UserInfo userInfo = new UserInfo();
        // Lấy ra thông tin hóa đơn hiện tại của người dùng
        HoaDon hoaDon = this.hoaDonRepository.findById(userInfo.idHoaDon).orElse(null);
        // Lấy ra thông tin chi tiết sản phẩm để xóa
        SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepository.findById(idSPCT).orElse(null);

        // Tìm và xóa chi tiết hóa đơn chứa sản phẩm cần xóa
        HoaDonChiTiet hoaDonChiTiet = this.hoaDonChiTietRepository.findByHoaDonAndIdSanPhamChiTiet(hoaDon, sanPhamChiTiet);
        if (hoaDonChiTiet != null) {
            int soLuong = hoaDonChiTiet.getSoLuong(); // Số lượng sản phẩm sẽ được cập nhật lại trong hóa đơn

            // Cập nhật lại số lượng sản phẩm trong bảng sản phẩm
            int soLuongHienTai = sanPhamChiTiet.getSoLuong();
            sanPhamChiTiet.setSoLuong(soLuongHienTai + soLuong);// Trả lại số lượng vào chi tiết sản phẩm trong kho
            this.sanPhamChiTietRepository.save(sanPhamChiTiet);
            this.hoaDonChiTietRepository.delete(hoaDonChiTiet);
        }

        return "redirect:/ban-hang/detail/" + userInfo.idHoaDon;
    }







}
