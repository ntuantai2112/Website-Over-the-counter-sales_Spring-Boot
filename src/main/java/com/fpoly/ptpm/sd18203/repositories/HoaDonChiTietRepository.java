package com.fpoly.ptpm.sd18203.repositories;

import com.fpoly.ptpm.sd18203.entities.HoaDon;
import com.fpoly.ptpm.sd18203.entities.HoaDonChiTiet;
import com.fpoly.ptpm.sd18203.entities.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet,Integer> {

    public static  final  int DANG_XU_LY = 1;
    public static  final  int CHUA_XU_LY = 0;
    public static  final  int DA_XU_LY = 2;

    public Page<HoaDonChiTiet> findByTrangThai(int trangThai, Pageable pageable);
    Page<HoaDonChiTiet> findAll(Pageable pageable);

    @Query("SELECT h FROM HoaDonChiTiet h WHERE h.idHoaDon.id = :idHoaDon")
    List<HoaDonChiTiet> findByHoaDonId(@Param("idHoaDon") Integer idHoaDon);

    @Query("SELECT h FROM HoaDonChiTiet h WHERE h.idHoaDon = :hoaDon AND h.idSanPhamChiTiet = :sanPhamChiTiet")
    HoaDonChiTiet findByHoaDonAndIdSanPhamChiTiet(@Param("hoaDon") HoaDon hoaDon, @Param("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet);


}
