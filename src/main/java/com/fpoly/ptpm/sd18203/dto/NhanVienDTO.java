package com.fpoly.ptpm.sd18203.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienDTO {

    private int id;

    @NotBlank(message = "Vui lòng nhập vào mã nhân viên")
    private String ma;

    @NotBlank(message = "Vui lòng nhập vào tên nhân viên")
    private String ten;

    @NotBlank(message = "Vui lòng nhập vào username")
    private String tenDangNhap;

    @NotBlank(message = "Vui lòng nhập vào password")
    private String matKhau;

    @NotNull(message = "Vui lòng nhập vào trạng thái")
    private Integer trangThai;

}
