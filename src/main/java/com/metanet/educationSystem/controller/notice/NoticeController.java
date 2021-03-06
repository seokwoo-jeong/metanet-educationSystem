package com.metanet.educationSystem.controller.notice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.notice.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("")
	public String notice(HttpServletRequest request) throws Exception {

		List<NoticeVO> noticeList = noticeService.getNoticeList();
		System.out.println(noticeList);
		request.setAttribute("noticeVOList", noticeList);
		return "/notice/NoticeList";
	}

	@RequestMapping("/detail")
	public String noticeDetail(HttpServletRequest request, @RequestParam(value = "no") String noticeNO)
			throws Exception {

		NoticeVO noticeVO = new NoticeVO();
		noticeVO = noticeService.getNoticedetail(noticeNO);
		request.setAttribute("noticeVO", noticeVO);
		request.setAttribute("noticeFileList", this.noticeService.getNoticeFile(noticeNO));
		return "/notice/NoticeDetail";
	}

	@ResponseBody
	@RequestMapping("/imageUpload")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception {
		// ?????? ?????? ??????
		UUID uid = UUID.randomUUID();
		OutputStream out = null;
		PrintWriter printWriter = null;
		// ?????????
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// ?????? ?????? ????????????
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			// ????????? ?????? ??????
			String path = "noticeFileUpload/ckImage/";
			// fileDir??? ?????? ????????? ?????? ????????? ?????? ??????????????? ??????.
			String ckUploadPath = path + uid + "_" + fileName;
			File folder = new File(path);
			// ?????? ???????????? ??????
			if (!folder.exists()) {
				try {
					folder.mkdirs();
					// ?????? ??????
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			// outputStram??? ????????? ???????????? ???????????? ?????????
			String callback = request.getParameter("CKEditorFuncNum");
			printWriter = response.getWriter();
			String fileUrl = "/notice/ckImgSubmit?uid=" + uid + "&fileName=" + fileName;
			// ????????????
			// ???????????? ????????? ??????
			printWriter.println("{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	@RequestMapping(value = "/ckImgSubmit")
	public void ckSubmit(@RequestParam(value = "uid") String uid, @RequestParam(value = "fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ????????? ????????? ????????? ??????
		String path = "noticeFileUpload/ckImage/";
		String sDirPath = path + uid + "_" + fileName;
		File imgFile = new File(sDirPath);
		// ?????? ????????? ?????? ????????? ?????? ??????????????? ??? ????????? ????????? ????????????.
		if (imgFile.isFile()) {
			byte[] buf = new byte[1024];
			int readByte = 0;
			int length = 0;
			byte[] imgBuf = null;
			FileInputStream fileInputStream = null;
			ByteArrayOutputStream outputStream = null;
			ServletOutputStream out = null;
			try {
				fileInputStream = new FileInputStream(imgFile);
				outputStream = new ByteArrayOutputStream();
				out = response.getOutputStream();
				while ((readByte = fileInputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, readByte);
				}
				imgBuf = outputStream.toByteArray();
				length = imgBuf.length;
				out.write(imgBuf, 0, length);
				out.flush();
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				outputStream.close();
				fileInputStream.close();
				out.close();
			}
		}
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam(value = "noticeNO") String noticeNO)
			throws Exception {

		int result = noticeService.deleteNotice(noticeNO);
		return "redirect:";
	}

	@RequestMapping("/downloadNoticeFile")
	public String downloadNoticeFile(HttpServletResponse response, HttpServletRequest request) throws Exception {
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileNO(request.getParameter("fileNO"));
		noticeFileVO.setNoticeNO(request.getParameter("noticeNO"));

		noticeFileVO = this.noticeService.downloadNoticeFile(noticeFileVO);

		if (ObjectUtils.isEmpty(noticeFileVO) == false) {
			String fileName = noticeFileVO.getOriginFileName();

			byte[] files = FileUtils.readFileToByteArray(new File(noticeFileVO.getStoredFilePath()));

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");

			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		return "redirect:detail";
	}

}