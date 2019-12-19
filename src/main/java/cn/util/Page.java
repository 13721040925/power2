package cn.util;

import java.util.List;

/**
 * 分页类
 * 
 * @author Lenovo
 *
 */
public class Page<T> {
	private Integer pageNum;// 当前的页码
	private Integer totalCount;// 总条数，总记录数
	private Integer totalPage;// 总页数
	public final static int pageCount = 15;// 每页15条  
	private Integer rowNum;// 当前页起始行号 
	private List<T> list;// 当前页的内容
	// Page类的设置顺序：
	// 1、setTotalCount()
	// 2、setTotalPage()
	// 3、setPageNum()
	// 4、setRowNum()

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageNum < 1) {
			pageNum = 1;
		}
		if (pageNum > totalPage) {
			pageNum = totalPage;
		}
		if (totalPage == 0) {
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		if (totalCount % pageCount == 0) {
			this.totalPage = totalCount / pageCount;
		} else {
			this.totalPage = totalCount / pageCount + 1;
		}
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum() {
		this.rowNum = (pageNum - 1) * pageCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", rowNum="
				+ rowNum + ", list=" + list + "]";
	}

	public void init(int totalCount, Integer pageNum) {
		setTotalCount(totalCount);
		setTotalPage();
		setPageNum(pageNum);
		setRowNum();
	}
}
