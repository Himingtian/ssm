package com.learnssm.ssm.service.impl;

import com.learnssm.ssm.exception.SsmException;
import com.learnssm.ssm.mapper.ItemsMapper;
import com.learnssm.ssm.po.Items;
import com.learnssm.ssm.po.ItemsExample;
import com.learnssm.ssm.service.ItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Resource(name = "itemsMapper")
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> getItems() {
        ItemsExample example = new ItemsExample();
        return itemsMapper.selectByExample(example);
    }

    @Override
    public Items itemEdit(Integer id){
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateitem(Items items) {

        itemsMapper.updateByPrimaryKey(items);
    }
}
