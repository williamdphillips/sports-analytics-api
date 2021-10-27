package com.phillips.sportsanalytics.response.headtohead;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeadToHeadResponse{

	@JsonProperty("pageCount")
	private int pageCount;

	@JsonProperty("pageIndex")
	private int pageIndex;

	@JsonProperty("count")
	private int count;

	@JsonProperty("pageSize")
	private int pageSize;

	@JsonProperty("items")
	private List<ItemsItem> items;

	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	public int getPageCount(){
		return pageCount;
	}

	public void setPageIndex(int pageIndex){
		this.pageIndex = pageIndex;
	}

	public int getPageIndex(){
		return pageIndex;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}