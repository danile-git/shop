package com.shop.service.inter;

import com.shop.common.pojo.ShopResult;
import com.shop.pojo.TbItemParam;

public interface ItemParamService {
	ShopResult getItemParamByCid(long cid);
	ShopResult insertItemParam(TbItemParam tbItemParam);
}
