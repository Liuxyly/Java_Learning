package org.liuxy.rentcar.entity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Lixor(at)live.cn
 * 
 */
public class Page<T> {

	private int rowTotal; // 总记录数
	private int pageSize = 6; // 每页记录数

	private int count; // 当前页码

	private int total; // 总页数
	private int beginIndex; // 起始记录下标
	private int endIndex; // 截止记录下标
	
	private List<T> pageList;
	
	private Map<String, String> message;

	/**
	 * 使用总记录数、当前页码构造
	 * 
	 * @param rowTotal
	 * @param count
	 *            页码，从1开始
	 */
	public Page(int totalRow, int count) {
		this.rowTotal = totalRow;
		this.count = count;
		calculate();
	}
	
	/**
	 * 使用总记录数、当前页码和每页记录数构造
	 * 
	 * @param rowTotal
	 * @param count
	 *            页码，从1开始
	 * @param pageSize
	 *            默认30条
	 */
	public Page(int totalRow, int count, int pageSize) {
		this.rowTotal = totalRow;
		this.count = count;
		this.pageSize = pageSize;
		calculate();
	}

	private void calculate() {
		total = rowTotal / pageSize + ((rowTotal % pageSize) > 0 ? 1 : 0);
		
		if (total == 0) {
			total = 1;
		}
		
		if (count > total) {
			count = total;
		} else if (count < 1) {
			count = 1;
		}

		beginIndex = (count - 1) * pageSize;
		endIndex = beginIndex + pageSize;
		if (endIndex > rowTotal) {
			endIndex = rowTotal;
		}
	}

	public int getCount() {
		return count;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalRow() {
		return rowTotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * @return the pageList
	 */
	public List<T> getPageList() {
		return pageList;
	}

	/**
	 * @param pageList the pageList to set
	 */
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	/**
	 * @return the message
	 */
	public Map<String, String> getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
}
