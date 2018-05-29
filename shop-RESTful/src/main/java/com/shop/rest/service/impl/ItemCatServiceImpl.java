package com.shop.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.TbItemCatMapper;
import com.shop.pojo.TbItemCat;
import com.shop.pojo.TbItemCatExample;
import com.shop.pojo.TbItemCatExample.Criteria;
import com.shop.rest.pojo.CatNode;
import com.shop.rest.pojo.CatResult;
import com.shop.rest.service.inter.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}

	private List<?> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {

			if (tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();

				if (parentId == 0) {
					catNode.setName(String.format("<a href='/products/%d.html'>%s</a>", tbItemCat.getId(),
							tbItemCat.getName()));
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl(String.format("/products/%d.html", tbItemCat.getId()));
				catNode.setItem(getCatList(tbItemCat.getId()));

				resultList.add(catNode);
			} else {

				resultList.add(String.format("/products/%d.html|%s", tbItemCat.getId(), tbItemCat.getName()));
			}
		
		}
		return resultList;
	}
}
