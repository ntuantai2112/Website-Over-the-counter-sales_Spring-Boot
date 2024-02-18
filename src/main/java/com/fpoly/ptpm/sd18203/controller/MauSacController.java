package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
import com.fpoly.ptpm.sd18203.entities.MauSac;
import com.fpoly.ptpm.sd18203.repositories.MauSacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mau-sac")
@Component
public class MauSacController {


    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("store")
    public String getMauSac(Model model,
                            @RequestParam("page") Optional<Integer> pageParam


    ) {

        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 10);
        Page<MauSac> pageData = mauSacRepository.findAll(p);

        model.addAttribute("pageData", pageData);

        return "admin/ql_mausac/indexMS";
    }


    @GetMapping("create-color")
    public String createColor(Model model) {

        MauSacDTO mauSac = new MauSacDTO();
        model.addAttribute("data", mauSac);
        return "admin/ql_mausac/create";
    }

    @PostMapping("/create-color")
    public String createMS(
            @Valid @ModelAttribute("data") MauSacDTO req,
            BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("Có lỗi");
            return "admin/ql_mausac/create";
        }

//        if(req.getTrangThai().equals("")){
//            return "admin/ql_mausac/create";
//        }

        MauSac mauSac = new MauSac(req.getMa(), req.getTen(), Integer.parseInt(req.getTrangThai()));
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/store";
    }


    @GetMapping("delete-color")
    public String deleteColor(Model model, @RequestParam(name = "id") int idMauSac) {
        System.out.println(idMauSac);
        mauSacRepository.deleteById(idMauSac);
        return "redirect:/mau-sac/store";
    }

    @GetMapping("edit-color/{id}")
    public String editMauSac(Model model, @PathVariable(name = "id") MauSac mauSac) {
        if (mauSac == null) {
            // Handle the case when MauSac with the given ID is not found
            return "redirect:/mau-sac/store";
        }
        model.addAttribute("mauSac", mauSac);
        return "admin/ql_mausac/edit";
    }


    @PostMapping("/edit-color/{id}")
    public String editMS(
            Model model,
            @Valid @ModelAttribute("mauSac") MauSacDTO mauSacDTO,
            BindingResult result,
            @PathVariable(name = "id") MauSac mauSac) {


        if (result.hasErrors()) {
            return "admin/ql_mausac/edit";
        }

        mauSac.setMa(mauSacDTO.getMa());
        mauSac.setTen(mauSacDTO.getTen());
        mauSac.setTrangThai(Integer.parseInt(mauSacDTO.getTrangThai()));

        mauSacRepository.save(mauSac);

        return "redirect:/mau-sac/store";
    }


}
