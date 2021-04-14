package cl.mobdev.dogceoy2k.application.data.breedImage.datasource;

import cl.mobdev.dogceoy2k.application.data.breedImage.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.configuration.BreedProperties;
import org.springframework.web.client.RestOperations;

public class BreedImagesDataSourceImpl implements BreedImagesDataSource {

    private final RestOperations restOperations;
    private final BreedProperties breedProperties;

    public BreedImagesDataSourceImpl(
            RestOperations restOperations,
            BreedProperties breedProperties
    ){
        this.restOperations = restOperations;
        this.breedProperties = breedProperties;
    }

    @Override
    public BreedImagesEntity getImages(String breed){

        return this.restOperations.getForObject(this.breedProperties.getBreedImagesURL(breed), BreedImagesEntity.class);
    }
}
