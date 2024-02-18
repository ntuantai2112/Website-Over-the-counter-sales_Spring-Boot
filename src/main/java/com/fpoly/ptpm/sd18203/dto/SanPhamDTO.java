package com.fpoly.ptpm.sd18203.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SanPhamDTO {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập vào giá trị Mã")
    private String ma;
    @NotBlank(message = "Vui lòng nhập vào giá trị Tên")
    private String ten;

    @NotNull(message = "Vui lòng nhập vào giá trị trạng thái")
    private Integer trangThai;

    public SanPhamDTO(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public SanPhamDTO(String ma, String ten, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }
}
