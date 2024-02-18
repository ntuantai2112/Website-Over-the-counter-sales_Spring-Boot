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

public class KichThuocDTO {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập vào giá trị Mã")
    private String ma;
    @NotBlank(message = "Vui lòng nhập vào giá trị Tên")
    private String ten;
    @NotBlank(message = "Vui lòng nhập vào giá trị trạng thái")
    private String trangThai;

    public KichThuocDTO(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public KichThuocDTO(String ma, String ten, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }
}
