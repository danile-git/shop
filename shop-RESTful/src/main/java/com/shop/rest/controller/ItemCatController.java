package com.shop.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.common.util.JsonUtil;
import com.shop.rest.pojo.CatResult;
import com.shop.rest.service.inter.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		String json = JsonUtil.objectToJson(catResult);
		String result = String.format("%s(%s);", callback, json);

		return result;
	}
}
