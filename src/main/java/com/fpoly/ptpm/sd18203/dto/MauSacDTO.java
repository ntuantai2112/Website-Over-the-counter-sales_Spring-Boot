package com.fpoly.ptpm.sd18203.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Component
public class MauSacDTO {


    private Integer id;
    @NotBlank(message = "Vui lòng nhập vào giá trị Mã")
    private String ma;
    @NotBlank(message = "Vui lòng nhập vào giá trị Tên")
    private String ten;

    @NotBlank(message = "Vui lòng nhập vào giá trị trạng thái")
    private String trangThai;

    public MauSacDTO(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public MauSacDTO(String ma, String ten, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }


}
