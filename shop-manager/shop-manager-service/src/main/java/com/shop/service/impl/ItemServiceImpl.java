package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGirdResult;
import com.shop.common.pojo.ShopResult;
import com.shop.common.util.IDUtil;
import com.shop.mapper.TbItemDescMapper;
import com.shop.mapper.TbItemMapper;
import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemDesc;
import com.shop.pojo.TbItemExample;
import com.shop.service.inter.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;
	@Autowired
	TbItemDescMapper tbItemDescMapper;

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

	@Override
	public ShopResult createItem(TbItem item, String desc) throws Exception {
		// 生成商品id
		Long itemId = IDUtil.genItemId();
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		ShopResult sResult = insertItemDesc(itemId, desc);
		if (sResult.getStatus() != 200) {
			throw new Exception();
		}
		return ShopResult.ok();
	}

	private ShopResult insertItemDesc(Long itemId, String desc) {
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		tbItemDescMapper.insert(tbItemDesc);
		return ShopResult.ok();
	}

}
