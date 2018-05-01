package com.shop.service.inter;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
  Map uploadFile(MultipartFile uploadFile);
}
