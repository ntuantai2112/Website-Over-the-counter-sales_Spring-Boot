package com.fpoly.ptpm.sd18203.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SDT")
    private String sdt;


    @Column(name = "TrangThai")
    private Integer trangThai;

    public KhachHang(String ma, String ten, String sdt, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
}
