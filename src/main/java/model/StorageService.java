package model;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

/**
 * Created by reneschollmeyer, evoila on 09.10.18.
 */
public interface StorageService {

    String store(MultipartFile file);

    Resource loadAsResource(String filename) throws MalformedURLException;
}
