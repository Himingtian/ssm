package com.learnssm.ssm.service;

import com.learnssm.ssm.exception.SsmException;
import com.learnssm.ssm.po.Items;

import java.util.List;

public interface ItemsService {
    List<Items> getItems();
    Items itemEdit(Integer id);
    void updateitem(Items items);
}
