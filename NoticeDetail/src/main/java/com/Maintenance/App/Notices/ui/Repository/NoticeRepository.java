package com.Maintenance.App.Notices.ui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maintenance.App.Notices.ui.Model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
