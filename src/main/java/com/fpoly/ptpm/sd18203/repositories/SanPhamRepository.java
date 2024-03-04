package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.KichThuoc;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {


    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public Page<SanPham> findByTrangThai(int trangThai, Pageable pageable);

    Page<SanPham> findAll(Pageable pageable);
}
