package com.fpoly.ptpm.sd18203.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien idNhanVien;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang idKhachHang;

    @Column(name = "NgayMuaHang")
    @Temporal(TemporalType.DATE)
    private Date ngayMuaHang;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
