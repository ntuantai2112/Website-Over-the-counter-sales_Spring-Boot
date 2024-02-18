package com.fpoly.ptpm.sd18203.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "SanPhamChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTiet {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MaSPCT")
    private String maSPCT;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdKichThuoc")
    private KichThuoc idKichThuoc;

    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham idSanPham;


    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
