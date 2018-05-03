package sin.glouds.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sin.glouds.bean.Page;

public class BaseService {

	protected void startPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
	}
	
	protected <T> Page<T> findPage(List<T> data) {
		PageInfo<T> pageInfo = new PageInfo<>(data);
		Page<T> page = new Page<>();
		page.setTotal(pageInfo.getTotal());
		page.setEndRow(pageInfo.getEndRow());
		page.setNextPage(pageInfo.getNextPage());
		page.setPrePage(pageInfo.getPrePage());
		page.setPageNumber(pageInfo.getPageNum());
		page.setPages(pageInfo.getPages());
		page.setPageSize(pageInfo.getPageSize());
		page.setRows(pageInfo.getList());
		page.setSize(page.getSize());
		page.setStartRow(pageInfo.getStartRow());
		return page;
	}
	
}
