package com.tencent.util;

import java.util.List;

public class Pager {
	protected int curPageNo;
	protected int rowCount;
	protected int pageCount;
	protected int startIndex;
	protected int endIndex;
	protected int[] arrayPage;
	protected int pageSize;
	protected List<?> resultList = null;

	public Pager() {

	}

	public Pager(int pageSize, int pageNo, int rowCount, int pageCount,
			int startIndex, int endIndex, List<?> resultList) {
		this.pageSize = pageSize;
		this.curPageNo = pageNo;
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.resultList = resultList;
		this.startIndex = startIndex;
		this.endIndex = endIndex;

		this.initArrayPage(pageNo, pageCount);
	}

	public int[] initArrayPage(int pageNo, int pageCount) {
		if (pageCount <= 7) {
			arrayPage = new int[pageCount];
			for (int i = 0; i < pageCount; i++)
				arrayPage[i] = i + 1;
		} else if (this.curPageNo <= 4) {
			arrayPage = new int[7];
			for (int i = 0; i < 7; i++)
				arrayPage[i] = i + 1;
		} else if (this.curPageNo <= this.pageCount - 4) {
			arrayPage = new int[7];
			arrayPage[3] = this.curPageNo;
			for (int i = 1; i <= 3; i++) {
				arrayPage[3 - i] = this.curPageNo - 1;
				arrayPage[3 + i] = this.curPageNo + 1;
			}
		} else {
			arrayPage = new int[7];
			for (int i = 0; i < 7; i++)
				arrayPage[i] = this.pageCount - 6 + i;
		}
		return arrayPage;
	}

	public int getCurPageNo() {
		return curPageNo;
	}

	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int[] getArrayPage() {
		return arrayPage;
	}

	public void setArrayPage(int[] arrayPage) {
		this.arrayPage = arrayPage;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

}
