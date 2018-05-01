package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGirdResult;
import com.shop.mapper.TbItemMapper;
import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemExample;
import com.shop.service.inter.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(Long id) {
		// TbItemExample 创建mybatis 语句查询
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public EUDataGirdResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		EUDataGirdResult result = new EUDataGirdResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal((int) pageInfo.getTotal());
		return result;
	}

}
