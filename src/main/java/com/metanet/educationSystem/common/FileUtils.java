package com.metanet.educationSystem.common;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.NoticeFileVO;

@Component
public class FileUtils {
	public List<NoticeFileVO> parseFileInfo(String noticeNO, HttpServletRequest request,
			MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}

		List<NoticeFileVO> fileList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = "noticeFile/" + current.format(format);

		File file = new File(path);

		if (file.exists() == false) {
			file.mkdirs();
		}
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		String newFileName, originalFileExtension, contentType;

		while (iterator.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());

			for (MultipartFile multipartFile : list) {
				if (multipartFile.isEmpty() == false) {
					contentType = multipartFile.getContentType();
					if (ObjectUtils.isEmpty(contentType)) {

						break;
					} else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else if (contentType.contains("text/plain")) {
							originalFileExtension = ".txt";
						} else if (contentType.contains("application/x-zip-compressed")) {
							originalFileExtension = ".zip";
						} else {
							break;
						}
					}
					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					NoticeFileVO noticeFile = new NoticeFileVO();
					noticeFile.setNoticeNO(noticeNO);
					noticeFile.setFileSize(multipartFile.getSize());
					noticeFile.setOriginFileName(multipartFile.getOriginalFilename());
					noticeFile.setStoredFilePath(path + "/" + newFileName);
					fileList.add(noticeFile);

					file = new File(noticeFile.getStoredFilePath());

					multipartFile.transferTo(file.getAbsoluteFile()); // 파일을 위에 지정 경로로 업로드
				}
			}
		}
		return fileList;
	}
}
