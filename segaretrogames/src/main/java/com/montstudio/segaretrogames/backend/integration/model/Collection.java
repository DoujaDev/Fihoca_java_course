package com.montstudio.segaretrogames.backend.integration.model;

import java.util.List;

public class Collection {

	private Long id;
    private Platform platform;
    private int size;
    private List<Item> ownedItemsList;
    private List<Item> wantedItemsList;
    
    public Collection() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Item> getOwnedItemsList() {
		return ownedItemsList;
	}

	public void setOwnedItemsList(List<Item> ownedItemsList) {
		this.ownedItemsList = ownedItemsList;
	}

	public List<Item> getWantedItemsList() {
		return wantedItemsList;
	}

	public void setWantedItemsList(List<Item> wantedItemsList) {
		this.wantedItemsList = wantedItemsList;
	}

	@Override
	public String toString() {
		return "Collection [id=" + id + ", platform=" + platform + ", size=" + size + ", ownedItemsList="
				+ ownedItemsList + ", wantedItemsList=" + wantedItemsList + "]";
	}
    

}
