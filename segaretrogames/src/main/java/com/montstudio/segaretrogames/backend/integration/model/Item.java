package com.montstudio.segaretrogames.backend.integration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="ITEMS")
public class Item {
	
	@Id
	@TableGenerator(name = "ITEM_GENERATOR",
		table = "SECUENCIAS",
		pkColumnName = "SEQ_NAME",
		pkColumnValue = "ITEM_SEQ",
		valueColumnName = "SEQ_NUMBER",
		allocationSize = 10)
	
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ITEM_GENERATOR")
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private Platform platform;
	
	@Enumerated(EnumType.STRING)
    private MediaFormat mediaFormat;
	
	@Enumerated(EnumType.STRING)
    private Region region;

    private String name;
    
    private String description;
    
    @Column(name="COVER_IMAGE")
    private String coverImage;
 
    public Item() {
    	
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

	public MediaFormat getFormat() {
		return mediaFormat;
	}

	public void setFormat(MediaFormat mediaFormat) {
		this.mediaFormat = mediaFormat;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", platform=" + platform + ", mediaFormat=" + mediaFormat + ", region=" + region + ", name="
				+ name + ", description=" + description + ", coverImage=" + coverImage + "]";
	}
 
}
