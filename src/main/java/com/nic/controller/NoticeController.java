package com.nic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.model.Notice;
import com.nic.repo.NoticeRepo;
import com.nic.constant.ResponseType;
import com.nic.model.Response;


@RestController
@RequestMapping("/api/notice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoticeController extends BaseController {
	
	@Autowired
    NoticeRepo noticeRepo;

    // Get All Notice
    @GetMapping(path = "/getnotice", produces = "application/json")
    public ResponseEntity<Response> getAllNotices() {
        List<Notice> noticeList = noticeRepo.findAll();
        if (noticeList.isEmpty()) {
            return new ResponseEntity<Response>(getResponse(noticeList, ResponseType.NoData), HttpStatus.OK);
        } else {
            return new ResponseEntity<Response>(getResponse(noticeList, ResponseType.Success), HttpStatus.OK);
        }
    }

    // Create a new Notice
    @PostMapping(path = "/createnotice", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> createNotice(@Valid @RequestBody Notice notice) {
        try {
            return new ResponseEntity<Response>(getResponse(noticeRepo.save(notice), ResponseType.Created),
                    HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<Response>(getResponse(ex.getLocalizedMessage(), ResponseType.Error),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a Single Notice
    @GetMapping(path = "/getnotice/{id}", produces = "application/json")
    public ResponseEntity<Response> getNoticeById(@PathVariable(value = "id") Long userId) {
        return new ResponseEntity<Response>(
                getResponse(noticeRepo.findById(userId), ResponseType.Success),
                HttpStatus.OK);
    }

//    // Update a Note
//    @PutMapping(path = "/updateUser/{id}", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Response> updateUser(@PathVariable(value = "id") Long userId,
//            @Valid @RequestBody User userDetails) {
//
//        try {
//            User user = noticeRepo.findById(userId)
//                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));            
//            User updatedUser = noticeRepo.save(user);
//            return new ResponseEntity<Response>(getResponse(updatedUser, ResponseType.Success), HttpStatus.OK);
//        } catch (Exception ex) {
//           return new ResponseEntity<Response>(getResponse(ex.getLocalizedMessage(), ResponseType.Success), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
