package com.fpoly.ptpm.sd18203.service;

import com.fpoly.ptpm.sd18203.dto.KichThuocDTO;
import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamDTO;
import com.fpoly.ptpm.sd18203.dto.SanPhamChiTietDTO;

import java.util.List;
import java.util.Map;


public interface ProductService {

     Map<Integer, KichThuocDTO> getAllSize();

    Map<Integer, MauSacDTO> getAllColor();

    List<SanPhamDTO> getAllSanPham();

    SanPhamDTO getSanPhamById(int id);
    List<SanPhamChiTietDTO> getAllSanPhamChiTiet();
    SanPhamChiTietDTO getSanPhamChiTietById(int id);



}
