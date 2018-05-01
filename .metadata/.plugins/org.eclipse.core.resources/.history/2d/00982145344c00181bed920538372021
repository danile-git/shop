package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.pojo.TbItem;
import com.shop.service.inter.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("/item/{itemid}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemid) {
		return itemService.getItemById(itemid);
	}
}
