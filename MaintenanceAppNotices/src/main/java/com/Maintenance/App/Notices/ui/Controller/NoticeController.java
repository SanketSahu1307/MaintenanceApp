package com.Maintenance.App.Notices.ui.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Maintenance.App.Notices.ui.Model.Notice;
import com.Maintenance.App.Notices.ui.Service.NoticeService;

@RestController
@RequestMapping(path = "/notices")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping(path = "/create",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Notice> saveNotice(@Valid @RequestBody Notice notice) {
		return new ResponseEntity<Notice>(noticeService.createNotice(notice),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/read",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Notice>> getNotice() {
		return new ResponseEntity<List<Notice>>(noticeService.getNoticeData(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/read/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Optional<Notice>> getNoticeById(@PathVariable("id") Long id) {
		return new ResponseEntity<Optional<Notice>>(noticeService.getByNoticeId(id),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> deleteNoticeById(@PathVariable("id")Long id) {
		noticeService.deleteByNoticeId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Notice> updateNoticeById(@Valid @RequestBody Notice notice) {
		return new ResponseEntity<Notice>(noticeService.updateByNoticeId(notice),HttpStatus.ACCEPTED);
	}
	
	
}
