package com.montstudio.segaretrogames.backend.presentation.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montstudio.segaretrogames.backend.integration.model.Item;
import com.montstudio.segaretrogames.backend.integration.repositories.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(value="/items",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAll(){
		return itemRepository.findAll();
	}
	
	@RequestMapping(value="/items/{code}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Item getByCode(@PathVariable ("code") Long code){
		
		Optional<Item> optional = this.itemRepository.findById(code);
		
		
		return optional.isPresent()? optional.get() : null;
	}

	
	@RequestMapping(value="/items/image/{codigo}",
			method=RequestMethod.GET,
			produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageAsResource(@PathVariable ("codigo") Integer codigo) throws IOException{

		ClassPathResource imgFile = new ClassPathResource("images/" + codigo  + ".png");
			
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
			
		return ResponseEntity.ok().body(bytes);
}
	
}
