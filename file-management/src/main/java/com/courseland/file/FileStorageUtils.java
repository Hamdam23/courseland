package com.courseland.file;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileStorageUtils {

    /**
     * Returns the original filename of a multipart file, with spaces(' ') replaced by hyphens('-')
     * and a unique timestamp appended to the end.
     * If the original filename is null or blank, returns a default filename('courseland').
     * @param multipartFile the multipart file to extract the original filename from
     * @return the original filename with spaces replaced by hyphens and a unique timestamp appended
     */
    public static String getOriginalFileName(MultipartFile multipartFile) {

        String originalFilename = multipartFile.getOriginalFilename();

        if (originalFilename == null || originalFilename.isBlank()) {
            originalFilename = "courseland";
        }
        String filenameExtension = StringUtils.getFilenameExtension(originalFilename);

        String fileName = originalFilename.substring(0, originalFilename.indexOf("." + filenameExtension));
        fileName = fileName.replaceAll(" ", "-").concat("-" + System.currentTimeMillis());

        return fileName;
    }

    /**
     * Returns the file size in megabytes, rounded down to the nearest whole number.
     * @param size the file size in bytes
     * @return the file size in megabytes, rounded down to the nearest whole number
     */
    public static long getFileSizeInMB(long size) {
        return size / (1024 * 1024);
    }
}
