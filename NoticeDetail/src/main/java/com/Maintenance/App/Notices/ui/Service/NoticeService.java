package com.Maintenance.App.Notices.ui.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maintenance.App.Notices.ui.Exception.NoticeNotFoundException;
import com.Maintenance.App.Notices.ui.Model.Notice;
import com.Maintenance.App.Notices.ui.Repository.NoticeRepository;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	public Notice createNotice(Notice notice) {
		return noticeRepository.save(notice);
	}

	public List<Notice> getNoticeData() {
		return noticeRepository.findAll();
	}

	public Optional<Notice> getByNoticeId(Long id) {
		Optional<Notice> notice=noticeRepository.findById(id);
		if (!notice.isPresent()) {
			throw new NoticeNotFoundException("Notice Not Found with Id "+id);
		}
		else {
			return notice;
		}
	}

	public void deleteByNoticeId(Long id) {
		Optional<Notice> notice=noticeRepository.findById(id);
		if (!notice.isPresent()) {
			throw new NoticeNotFoundException("Notice Not Found with Id "+id);
		}
		else {
			noticeRepository.deleteById(id);
		}
	}

	public Notice updateByNoticeId(Notice notice) {
		return noticeRepository.save(notice);
	}

}
