package com.tang.bos.web.controller;

import com.tang.bos.entity.Region;
import com.tang.bos.service.RegionService;
import com.tang.bos.utils.Page;
import com.tang.bos.utils.PinYin4jUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tang on 17-5-19.
 */
@Controller
@RequestMapping("/region/")
public class RegionController extends BaseController<Region>{

    @Autowired
    private RegionService regionService;

    @RequestMapping("show")
    public String show(){
        return "/WEB-INF/views/base/region";
    }

    @ResponseBody
    @RequestMapping("pageList")
    public Page<Region> pageList(@RequestParam int page, @RequestParam int rows){
        pageBean.setCurrentPage(page);
        pageBean.setCount(rows);
        List<Region> list = regionService.findPage(pageBean);
        pageBean.setRows(list);
        return pageBean;
    }

    @RequestMapping("importXls")
    public void importXls(@RequestParam MultipartFile regionFile, HttpSession session){
        List<Region> regionList=new ArrayList<>();
        HSSFWorkbook sheets=null;
        try {
            sheets = new HSSFWorkbook(regionFile.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HSSFSheet sheet1 = sheets.getSheet("Sheet1");
        for(Row row:sheet1){
            int rowNum=row.getRowNum();
            if (rowNum==0){
                continue;
            }
            int id= (int) row.getCell(0).getNumericCellValue();
            String province=row.getCell(1).getStringCellValue();
            String city=row.getCell(2).getStringCellValue();
            String district=row.getCell(3).getStringCellValue();
            String postcode=row.getCell(4).getStringCellValue();

            Region region = new Region();
            region.setId(id);
            region.setProvince(province);
            region.setCity(city);
            region.setDistrict(district);
            region.setPostcode(postcode);

            province = province.substring(0, province.length() - 1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);
            String info = province + city + district;
            String[] headByString = PinYin4jUtils.getHeadByString(info);
            String shortcode = StringUtils.join(headByString);
            //城市编码---->>shijiazhuang
            String citycode = PinYin4jUtils.hanziToPinyin(city, "");

            region.setShortcode(shortcode);
            region.setCitycode(citycode);
            regionList.add(region);
        }

        regionService.addRegions(regionList);
    }

    @ResponseBody
    @RequestMapping("ajaxList")
    public List<Region> ajaxList(){
        return regionService.ajaxList();
    }

    @RequestMapping("add")
    public String addRegion(Region region){
        regionService.add(region);
        return "/WEB-INF/views/base/region";
    }

    @RequestMapping("delete/{ids}")
    public String delete(@PathVariable String ids){
        if(ids!=null&&ids!=""){
            String[] idStrs = ids.split(",");
            for(String idStr:idStrs){
                int id=Integer.valueOf(idStr);
                regionService.delete(id);
            }
        }
        return "/WEB-INF/views/base/region";
    }

    @RequestMapping("editB")
    public String editB(Region region,@RequestParam String ids){
        return "/WEB-INF/views/base/region";
    }
}





















