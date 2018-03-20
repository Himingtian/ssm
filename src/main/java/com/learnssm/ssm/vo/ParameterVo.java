package com.learnssm.ssm.vo;

import com.learnssm.ssm.po.Items;

import java.util.List;

public class ParameterVo {
    private Items items;
    private List<Items> list;
    private String[] ids;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Items> getList() {
        return list;
    }

    public void setList(List<Items> list) {
        this.list = list;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
