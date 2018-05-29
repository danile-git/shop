package com.shop.service.inter;

import com.shop.common.pojo.EUDataGirdResult;
import com.shop.common.pojo.ShopResult;
import com.shop.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(Long id);

	EUDataGirdResult getItemList(int page, int rows);

	ShopResult createItem(TbItem item,String desc) throws Exception;
}
