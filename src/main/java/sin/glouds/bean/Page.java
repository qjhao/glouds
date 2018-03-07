package sin.glouds.bean;

import java.util.List;

public class Page {
	private Integer page;
	private Integer total;
	private List<?> rows;
	private Integer records;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public Integer getRecords() {
		return records;
	}
	
}
