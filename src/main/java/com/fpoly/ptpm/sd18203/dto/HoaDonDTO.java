package com.fpoly.ptpm.sd18203.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HoaDonDTO {
    private Integer id;

    private Integer idNhanVien;

    private Integer idKhachHang;

    @NotNull(message = "Vui lòng chọn vào ngày mua hàng")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayMuaHang;

    @NotNull(message = "Vui lòng nhập vào giá trị trạng thái")
    private Integer trangThai;
}
