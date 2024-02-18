//package com.fpoly.ptpm.sd18203.serviceImpl;
//
//import com.fpoly.ptpm.sd18203.dto.KichThuocDTO;
//import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
//import com.fpoly.ptpm.sd18203.dto.SanPhamChiTietDTO;
//import com.fpoly.ptpm.sd18203.dto.SanPhamDTO;
//import com.fpoly.ptpm.sd18203.service.ProductService;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    private List<SanPhamDTO> listSP;
//    private List<SanPhamChiTietDTO> listProductDetail;
//    private Map<Integer, KichThuocDTO> kichThuocMap;
//    private Map<Integer, MauSacDTO> mauSacMap;
//
//    public ProductServiceImpl() {
//        listSP = getAllSanPham();
//        kichThuocMap = getAllSize();
//        mauSacMap = getAllColor();
//        listProductDetail = getAllSanPhamChiTiet();
//    }
//
//    // Danh sách Kích thước
//    public Map<Integer, KichThuocDTO> getAllSize() {
//
//        kichThuocMap = new HashMap<>();
//        kichThuocMap.put(1, new KichThuocDTO(1, "KT001", "XL", "Action"));
//        kichThuocMap.put(2, new KichThuocDTO(2, "KT002", "M", "Action"));
//        kichThuocMap.put(3, new KichThuocDTO(3, "KT003", "S", "Action"));
//        kichThuocMap.put(4, new KichThuocDTO(4, "KT004", "L", "Action"));
//        kichThuocMap.put(5, new KichThuocDTO(5, "KT005", "XXL", "Action"));
//
//        return kichThuocMap;
//    }
//
//    // Danh sách màu sắc
//    public Map<Integer, MauSacDTO> getAllColor() {
//
//        mauSacMap = new HashMap<>();
//        mauSacMap.put(1, new MauSacDTO(1, "MS001", "Black", "Action"));
//        mauSacMap.put(2, new MauSacDTO(2, "MS002", "Blue", "Action"));
//        mauSacMap.put(3, new MauSacDTO(3, "MS003", "Red", "Action"));
//        mauSacMap.put(4, new MauSacDTO(4, "MS004", "Yellow", "Action"));
//        mauSacMap.put(5, new MauSacDTO(5, "MS005", "White", "Action"));
//        return mauSacMap;
//    }
//
//
//
//    @Override
//    public List<SanPhamDTO> getAllSanPham() {
//        List<SanPhamDTO> listSP = new ArrayList<>();
//        listSP.add(new SanPhamDTO(1, "SP001", "Quần Jean", "Active"));
//        listSP.add(new SanPhamDTO(2, "SP002", "Áo Len", "Inactive"));
//        listSP.add(new SanPhamDTO(3, "SP003", "Áo Khoác", "Active"));
//        listSP.add(new SanPhamDTO(4, "SP004", "Áo gió", "Inactive"));
//        listSP.add(new SanPhamDTO(5, "SP005", "Quần bò", "Inactive"));
//
//        return listSP;
//    }
//
//    @Override
//    public SanPhamDTO getSanPhamById(int id) {
//
//        for (SanPhamDTO sanPhamDTO : listSP) {
//            if (sanPhamDTO.getId() == id) {
//                return sanPhamDTO;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<SanPhamChiTietDTO> getAllSanPhamChiTiet() {
//        listProductDetail  = new ArrayList<>();
//        listProductDetail.add(new SanPhamChiTietDTO(1, kichThuocMap.get(1), mauSacMap.get(1), listSP.get(0), 10, 20.5, "Available"));
//        listProductDetail.add(new SanPhamChiTietDTO(2, kichThuocMap.get(2), mauSacMap.get(2), listSP.get(1), 20, 30.5, "Available"));
//        listProductDetail.add(new SanPhamChiTietDTO(3, kichThuocMap.get(3), mauSacMap.get(3), listSP.get(2), 30, 40.5, "Available"));
//        listProductDetail.add(new SanPhamChiTietDTO(4, kichThuocMap.get(4), mauSacMap.get(4), listSP.get(3), 40, 50.5, "Available"));
//        listProductDetail.add(new SanPhamChiTietDTO(5, kichThuocMap.get(5), mauSacMap.get(5), listSP.get(4), 50, 60.5, "Available"));
//
//
//        return listProductDetail;
//    }
//
//    @Override
//    public SanPhamChiTietDTO getSanPhamChiTietById(int id) {
//
//        for (SanPhamChiTietDTO sanPhamChiTietDTO : listProductDetail) {
//            if (sanPhamChiTietDTO.getId() == id) {
//                return sanPhamChiTietDTO;
//            }
//        }
//        return null;
//    }
//}
