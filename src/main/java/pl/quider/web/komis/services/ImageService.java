package pl.quider.web.komis.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.quider.web.komis.models.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class ImageService {
    private Logger log = LoggerFactory.getLogger(ImageService.class);

    /**
     *
     * @param file
     * @param car
     */
    public void saveImage(MultipartFile file, Car car) {
        try {
            File imageFile = new File("/home/adrian/IdeaProjects/komis/src/main/resources/static/images/" + car.getId() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
