package com.shop.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TbItemMapper;
import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemExample;

public class TestPageHelper {
	
//	public void testpage() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//				"classpath:spring/applicationContext-*");
//		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
//		TbItemExample example = new TbItemExample();
//		PageHelper.startPage(1, 10);
//		List<TbItem> list = mapper.selectByExample(example);
//		for (TbItem tbItem : list) {
//			System.out.println(tbItem.getTitle());
//		}
//		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
//		long total = pageInfo.getTotal();
//		System.out.println("total : " + total);
//	}
	
}
