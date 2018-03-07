package sin.glouds.beans;

import java.util.List;

public class PageData {

	private List<?> rows;
	private Long total;

	private PageData(List<?> list, Long totalCount) {
		this.rows = list;
		this.total = totalCount;
	}

	private static PageData pageData;

	public static PageData getData(List<?> data, Long totalCount) {
		if (pageData == null)
			pageData = new PageData(data, totalCount);
		pageData.setList(data);
		pageData.setTotalCount(totalCount);
		return pageData;
	}

	public List<?> getList() {
		return rows;
	}

	public void setList(List<?> list) {
		this.rows = list;
	}

	public Long getTotalCount() {
		return total;
	}

	public void setTotalCount(Long totalCount) {
		this.total = totalCount;
	}
	
	

}
