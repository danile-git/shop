package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.TbItemMapper;
import com.shop.pojo.TbItem;

import com.shop.service.inter.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(Long id) {
		//TbItemExample  创建mybatis 语句查询
		return itemMapper.selectByPrimaryKey(id);
	}

}
