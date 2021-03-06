package com.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.common.util.FtpUtil;
import com.shop.common.util.IDUtil;
import com.shop.service.inter.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;

	@Value("${FTP_SERVER_IP}")
	private String FTP_SERVER_IP;
	@Value("${FTP_SERVER_PORT}")
	private Integer FTP_SERVER_PORT;
	@Value("${FTP_SERVER_USERNAME}")
	private String FTP_SERVER_USERNAME;
	@Value("${FTP_SERVER_PASSWORD}")
	private String FTP_SERVER_PASSWORD;

	@Value("${IMAGE_HTTP_URL}")
	private String IMAGE_HTTP_URL;

	@Override
	public Map uploadFile(MultipartFile uploadFile) {
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "文件上传失败";
		try {
			String oldName = uploadFile.getOriginalFilename();
			String newName = IDUtil.genImageName();
			// String imagePath = new DateTime("/yyyy/MM/dd").toString();
			Date date = new Date();
			String imagePath =new SimpleDateFormat("/yyyy/MM/dd").format(date);
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			boolean flg = FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD,
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			if (flg) {
				result.put("error", 0);
				result.put("url", IMAGE_HTTP_URL + imagePath + "/" + newName);
				return result;
			}

		} catch (Exception ex) {
			message = ex.getMessage();
		}
		result.put("error", 1);
		result.put("message", message);
		return result;

	}

}
