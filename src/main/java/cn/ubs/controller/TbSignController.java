package cn.ubs.controller;

import cn.ubs.POJO.Tbsign;
import cn.ubs.mapper.TbsignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/tbSign")
public class TbSignController {
    @Autowired private TbsignMapper tbsignMapper;

    @GetMapping("/insertBatchTbSign")
    public void insertBatchTbSign(){
        Tbsign tbsign = new Tbsign();
        tbsign.setId(1L);
        tbsign.setUserId(1L);
       // tbsign.setYear(new LocalDate(2023));
       // tbsign.setMonth(new Byte(1));
       // tbsign.setDate(LocalDate.of);
        //tbsign.setIsBackup();


    }


}
