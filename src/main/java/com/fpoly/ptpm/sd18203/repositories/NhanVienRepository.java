package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.entities.NhanVien;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {


    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public Page<NhanVien> findByTrangThai(int trangThai, Pageable pageable);

    Page<NhanVien> findAll(Pageable pageable);

}
