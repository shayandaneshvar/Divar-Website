package ir.ac.kntu.divar.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class UploadUtil {
    public static final String UPLOAD_DIRECTORY = "./src/main" +
            "/resources/static/pictures";

    @Loggable
    public static String handleUpload(MultipartFile file) throws IOException {
        String fileName = null;
        if (file != null && !file.isEmpty() && file.getSize() > 0 &&
                file.getName().length() > 0) {
            fileName = "/" + (int) Math.abs(Math.random() * 10000000) +
                    file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIRECTORY, fileName);
            Files.write(path, file.getBytes());
        }
        return fileName;
    }
}
