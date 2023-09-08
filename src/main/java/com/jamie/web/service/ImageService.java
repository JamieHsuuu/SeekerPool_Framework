package com.jamie.web.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class ImageService {
	
	// 圖片的儲存路徑
	private final String SAVE_DIRECTORY = "/uploads/comPicture";
	
	public String storeImage(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			throw new RuntimeException("尚未上傳圖片，請再確認一次！");
		}
		
		// 生成每個圖片的文件名稱
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		String formatDateTime = now.format(formatter);
		String orgFileName = file.getOriginalFilename();
		String extension = orgFileName.substring(orgFileName.lastIndexOf('.'));  // 獲得檔案類型，例如 .jpg
		String fileName = orgFileName + extension;
		
		// 定義文件儲存路徑
		File fsaveDirectory = new File(SAVE_DIRECTORY);
		if (!fsaveDirectory.exists()) {
			fsaveDirectory.mkdirs();  // 檢查檔案目錄是否存在，不存在則用 mkdirs() 建多個資料夾
		}
		
		File destFile = new File(fsaveDirectory, fileName);
		file.transferTo(destFile);  // 使用MultipartFile的transferTo方法保存文件
		
		return SAVE_DIRECTORY + "/" + fileName;
	}

}
