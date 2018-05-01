package com.shop.service.inter;

import java.util.List;

import com.shop.common.pojo.EUDataGirdResult;
import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemCat;

public interface ItemCatService {
	List<TbItemCat> getItemCatList(Long parentId);

}
