package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.KhachHang;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {


    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public Page<HoaDon> findByTrangThai(int trangThai, Pageable pageable);

    public List<HoaDon> findAllByTrangThai(int trangThai);

    Page<HoaDon> findAll(Pageable pageable);
}
