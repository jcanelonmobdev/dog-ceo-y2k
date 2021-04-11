package cl.mobdev.dogceoy2k.configuration;

import org.springframework.beans.factory.annotation.Value;

public class BreedProperties {

    @Value("${dog-ceo_api.base_url}")
    private String baseURL;

    @Value("${dog-ceo_api.endpoints.sub_breed}")
    private String subBreedEndPoint;

    @Value("${dog-ceo_api.endpoints.images_breed}")
    private String imagesBreedEndPoint;

    public String getSubBreedsURL(String breed) {
        return this.baseURL.concat(subBreedEndPoint).replace("{breed_name}", breed);
    }

    public String getBreedImagesURL(String breed) {
        return this.baseURL.concat(imagesBreedEndPoint).replace("{breed_name}", breed);
    }
}
