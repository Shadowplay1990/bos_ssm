package com.tang.bos.web.controller;

import com.tang.bos.entity.Region;
import com.tang.bos.entity.Subarea;
import com.tang.bos.service.RegionService;
import com.tang.bos.service.SubareaService;
import com.tang.bos.utils.FileUtils;
import com.tang.bos.utils.Page;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tang on 17-5-20.
 */
@Controller
@RequestMapping("/subarea/")
public class SubareaController extends BaseController<Subarea>{

    @Autowired
    private SubareaService service;
    @Autowired
    private RegionService regionService;

    @RequestMapping("show")
    public String show(){
        return "/WEB-INF/views/base/subarea";
    }

    @ResponseBody
    @RequestMapping("pageQuery")
    public Page<Subarea> pageQuery
            (@RequestParam int page,@RequestParam int rows,Subarea subarea){
        pageBean.setCurrentPage(page);
        pageBean.setCount(rows);
        Page<Subarea> pageQuery = service.pageQuery(pageBean,subarea);
        return pageQuery;
    }

    @RequestMapping("add")
    public String addA(Subarea subarea){
        service.addSub(subarea);
        return "/WEB-INF/views/base/subarea";
    }

    @RequestMapping("edit")
    public String editB(@RequestParam String ids,Subarea subarea){
        service.updateB(subarea,ids);
        return "/WEB-INF/views/base/subarea";
    }

    @RequestMapping("del/{ids}")
    public String del(@PathVariable String ids){
        service.delB(ids);
        return "/WEB-INF/views/base/subarea";
    }

    @RequestMapping("exportXls")
    public void export(HttpServletRequest request, HttpServletResponse response){
        List<Subarea> list = service.findAll();
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFSheet sheet = sheets.createSheet("分区数据");
        HSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("分区编号");
        headRow.createCell(1).setCellValue("开始编号");
        headRow.createCell(2).setCellValue("结束编号");
        headRow.createCell(3).setCellValue("位置信息");
        headRow.createCell(4).setCellValue("省市区");

        for(Subarea subarea:list){
            HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
            Region region = subarea.getRegion();
            String info=region.getProvince()+region.getCity()+region.getDistrict();
            row.createCell(0).setCellValue(subarea.getId());
            row.createCell(1).setCellValue(subarea.getStartnum());
            row.createCell(2).setCellValue(subarea.getEndnum());
            row.createCell(3).setCellValue(subarea.getPosition());
            row.createCell(4).setCellValue(info);
        }

        String filename="分区数据表.xls";
        response.setContentType("application/excel");
        try {
            ServletOutputStream out = response.getOutputStream();
            String agent = request.getHeader("User-Agent");
            filename= FileUtils.encodeDownloadFilename(filename,agent);
            response.setHeader("content-disposition", "attachment;filename="+filename);
            sheets.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("importXls")
    public String importXls(@RequestParam MultipartFile subareaFile, HttpSession session){
        List<Subarea> list=new ArrayList<>();
        HSSFWorkbook sheets=null;
        try {
            sheets=new HSSFWorkbook(subareaFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet sheet1 = sheets.getSheet("Sheet1");
        for(Row row:sheet1){
            if(row.getRowNum()==0) continue;

            int id= (int) row.getCell(0).getNumericCellValue();
            int regionId= (int) row.getCell(1).getNumericCellValue();
            String key = row.getCell(2).getStringCellValue();
            String startNum = row.getCell(3).getStringCellValue();
            String endNum = row.getCell(4).getStringCellValue();
            String single = row.getCell(5).getStringCellValue();
            String position = row.getCell(6).getStringCellValue();

            Subarea subarea = new Subarea();
            subarea.setId(id);
            Region region = regionService.findById(regionId);
            subarea.setRegion(region);
            subarea.setAddresskey(key);
            subarea.setStartnum(startNum);
            subarea.setEndnum(endNum);
            subarea.setPosition(position);
            subarea.setSingle(single);

            list.add(subarea);
        }

        for(Subarea s:list){
            service.addSub(s);
        }

        return "/WEB-INF/views/base/subarea";
    }
}
















