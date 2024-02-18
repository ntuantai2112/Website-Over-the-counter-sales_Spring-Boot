package com.fpoly.ptpm.sd18203.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTietDTO {

    private Integer id;

    @NotBlank(message = "Vui lòng nhập vào giá trị mã sản phẩm chi tiết")
    private String maSPCT;

    private Integer idKichThuoc;

    private Integer idMauSac;

    private Integer idSanPham;

    @NotNull(message = "Vui lòng nhập vào giá trị số lượng sản phẩm")
    private int soLuong;

    @NotNull(message = "Vui lòng nhập vào giá sản phẩm")
    private BigDecimal donGia;

    @NotNull(message = "Vui lòng nhập vào giá trạng thái")
    private Integer trangThai;


}
