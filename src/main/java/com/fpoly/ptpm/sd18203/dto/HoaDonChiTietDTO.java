package com.fpoly.ptpm.sd18203.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietDTO {
    private int id;

    private Integer idHoaDon;

    private Integer idSanPhamChiTiet;

    @NotNull(message = "Vui lòng nhập vào số lượng")
    private int soLuong;
    @NotNull(message = "Vui lòng nhập vào đơn giá")
    private BigDecimal donGia;

    @NotNull(message = "Vui lòng chọn vào ngày mua hàng")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoiGian;

    @NotNull(message = "Vui lòng nhập vào trạng thái")
    private Integer trangThai;
}
