package com.learnssm.ssm.controller;

import com.learnssm.ssm.exception.SsmException;
import com.learnssm.ssm.po.Items;
import com.learnssm.ssm.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {
    @Resource(name = "itemsServiceImpl")
    private ItemsService itemsService;

    @RequestMapping("/itemList")
    public ModelAndView getItemList() {
        List<Items> list = itemsService.getItems();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit")
    public String itemEdit(Integer id, Model model) throws SsmException {
        Items item = itemsService.itemEdit(id);
        if(item == null){
            throw new SsmException("异常测试");
        }
        model.addAttribute("item",item);
        return "editItem";
    }

    @RequestMapping("/updateitem")
    public String updateitem(Items items){

        try
        {
            itemsService.updateitem(items);
            return "success";
        } catch (Exception e)
        {
            e.printStackTrace();
            return "success";
        }
    }
    @RequestMapping("/item/queryitem")
    public String testIds(String[] ids){
        for (String s:ids) {
            System.out.println(s);
        }
        return "success";
    }


    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Items items,MultipartFile multipartFile) throws Exception {

        //获取源文件名
        String oldFileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()+oldFileName.substring(oldFileName.lastIndexOf("."));

        File file = new File("D:\\LearnWeb01\\images\\" + newFileName);
        multipartFile.transferTo(file);

        items.setPic(newFileName);
        itemsService.updateitem(items);
        return "success";
    }
}
