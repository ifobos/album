/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://beta.skaffolder.com/#!/register?friend=5cc4adb8fe21c354b568ed16
*
* You will get 10% discount for each one of your friends
* 
*/
package com.album.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.album.db.album_db.service.AlbumService;
import com.album.db.album_db.entity.Album;

//IMPORT RELATIONS
import com.album.db.album_db.entity.Album;
import com.album.db.album_db.entity.Photo;

public class AlbumBaseController {
    
    @Autowired
	AlbumService albumService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/album", method = RequestMethod.POST, headers = "Accept=application/json")
	public Album insert(@RequestBody Album obj) {
		Album result = albumService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/album/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		albumService.delete(id);
	}
	

    //CRUD - FIND BY Photo
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/album/findByPhoto/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Album> findByPhoto(@PathVariable("key") Long idPhoto) {
		List<Album> list = albumService.findByPhoto(idPhoto);
		return list;
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Album get(@PathVariable Long id) {
		Album obj = albumService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/album", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Album> getList() {
		return albumService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/album/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Album update(@RequestBody Album obj, @PathVariable("id") Long id) {
		Album result = albumService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
