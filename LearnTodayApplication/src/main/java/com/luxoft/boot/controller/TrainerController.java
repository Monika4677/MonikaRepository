package com.luxoft.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.boot.model.AuthData;
import com.luxoft.boot.model.TrainerModel;
import com.luxoft.boot.service.TrainerService;

@RestController
@RequestMapping("api/trainerSingUp")
public class TrainerController {
	@Autowired
	private TrainerService trainerService ;
	
@PostMapping("/trainerSignUp")
public ResponseEntity<TrainerModel> trainerSignUp(@RequestBody TrainerModel trainerModel){
		TrainerModel trainerSignUp	=trainerService.trainerSignUp(trainerModel);
		return new ResponseEntity<TrainerModel>(trainerSignUp,HttpStatus.CREATED);
		}
	
@PutMapping("/updatePassword")	
public ResponseEntity<TrainerModel> updatePassword(@RequestBody AuthData auth,Integer trainerId){
	   TrainerModel updated= trainerService.updatePassword(auth,trainerId);
	   return new ResponseEntity<TrainerModel>(updated, HttpStatus.OK);
	
}

}
