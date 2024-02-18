package com.fpoly.ptpm.sd18203.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "KichThuoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KichThuoc {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public KichThuoc(String ma, String ten, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }
}
