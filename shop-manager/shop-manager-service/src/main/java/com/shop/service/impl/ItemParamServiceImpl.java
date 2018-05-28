package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.common.pojo.ShopResult;

import com.shop.mapper.TbItemParamMapper;
import com.shop.pojo.TbItemParam;
import com.shop.pojo.TbItemParamExample;
import com.shop.pojo.TbItemParamExample.Criteria;
import com.shop.service.inter.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {
	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public ShopResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExample(example);
		if (list != null && list.size() > 0)
			return ShopResult.ok(list.get(0));
		return ShopResult.ok();
	}

	@Override
	public ShopResult insertItemParam(TbItemParam tbItemParam) {
		tbItemParam.setCreated(new Date());
		tbItemParam.setUpdated(new Date());
		itemParamMapper.insert(tbItemParam);
		return ShopResult.ok();
	}

}
