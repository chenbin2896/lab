package com.ty.lab.controller.excelcontroller;

import com.ty.lab.pojo.TbLabrecord;
import com.ty.lab.pojo.lab.LabRecord;
import com.ty.lab.service.AccountinfoService;
import com.ty.lab.service.LabnameService;
import com.ty.lab.service.LabrecordService;
import com.ty.lab.utils.ExportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class ExcellController {

    @Autowired
    private LabrecordService labrecordService;

    @Autowired
    private LabnameService labnameService;

    @Autowired
    private AccountinfoService accountinfoService;

    /**
     * 导出表
     * @param response
     * @param requestExportExcelUtils
     */
    @RequestMapping("/export")
    public void exportOrder(HttpServletResponse response, HttpServletRequest requestExportExcelUtils) {

        List<LabRecord> labRecords = new ArrayList<>();

        String excelName = "预约记录表";

        List<TbLabrecord> labrecordServiceAll = labrecordService.findAll();

        for (TbLabrecord tbLabrecord  : labrecordServiceAll) {

            LabRecord labRecord = new LabRecord();

            String name = accountinfoService.findOne(Long.valueOf(tbLabrecord.getAccountid())).getRealname();

            String date = new SimpleDateFormat("yyyy-MM-dd").format(tbLabrecord.getDate());

            String time = tbLabrecord.getTimestate();

            String labName = labnameService.findOne(Long.valueOf(tbLabrecord.getLid())).getName();

            labRecord.setName(name);
            labRecord.setLabName(labName);
            labRecord.setDate(date);
            labRecord.setTime(time);

            labRecords.add(labRecord);
        }

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("name", "姓名");
        fieldMap.put("date", "日期");
        fieldMap.put("time", "时间段");
        fieldMap.put("labName", "实验室");

        ExportExcelUtils.export(excelName, labRecords, fieldMap, response);

    }
}
