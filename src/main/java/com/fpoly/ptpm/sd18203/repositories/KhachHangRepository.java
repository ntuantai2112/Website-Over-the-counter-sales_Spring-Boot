package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.KhachHang;
import com.fpoly.ptpm.sd18203.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {


    public static  final  int ACTIVE = 1;
    public static  final  int INACTIVE = 0;

    public Page<KhachHang> findByTrangThai(int trangThai, Pageable pageable);
    Page<KhachHang> findAll(Pageable pageable);
}
