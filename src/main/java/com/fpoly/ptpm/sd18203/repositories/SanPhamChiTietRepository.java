package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.entities.SanPham;
import com.fpoly.ptpm.sd18203.entities.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {


    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public Page<SanPhamChiTiet> findByTrangThai(int trangThai, Pageable pageable);

    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "WHERE spct.idSanPham.id = :sanPhamId " +
            "AND spct.idMauSac.id = :mauSacId " +
            "AND spct.idKichThuoc.id = :kichThuocId")
    SanPhamChiTiet findBySanPhamAndMauSacAndKichThuoc(@Param("sanPhamId") Integer sanPhamId,
                                                      @Param("mauSacId") Integer mauSacId,
                                                      @Param("kichThuocId") Integer kichThuocId);

    Page<SanPhamChiTiet> findAll(Pageable pageable);
}
