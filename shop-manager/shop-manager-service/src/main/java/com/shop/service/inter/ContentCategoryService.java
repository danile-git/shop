package com.shop.service.inter;

import java.util.List;

import com.shop.common.pojo.EUTreeNode;

public interface ContentCategoryService {
	List<EUTreeNode> getCategoryList(long parentId);
}
