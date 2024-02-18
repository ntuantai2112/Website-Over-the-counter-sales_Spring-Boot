package com.fpoly.ptpm.sd18203.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class KhachHangDTO {
    private int id;

    @NotBlank(message = "Vui lòng nhập vào tên khách hàng")
    private String ten;
    @NotBlank(message = "Vui lòng nhập vào sô điện thoại")
//    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải là 10 chữ số")
    private String sdt;
    @NotBlank(message = "Vui lòng nhập vào mã khách hàng")
    private String ma;
    @NotNull(message = "Vui lòng nhập vào trạng thái")
    private Integer trangThai;

}
