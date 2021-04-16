package cl.mobdev.dogceoy2k.configuration;

import cl.mobdev.dogceoy2k.application.data.breedDetail.mapper.BreedDetailMapper;
import cl.mobdev.dogceoy2k.application.data.breedDetail.repository.BreedDetailRepositoryImpl;
import cl.mobdev.dogceoy2k.application.data.breedImage.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.breedImage.datasource.BreedImagesDataSourceImpl;
import cl.mobdev.dogceoy2k.application.data.subBreed.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.subBreed.datasource.SubBreedsDataSourceImpl;
import cl.mobdev.dogceoy2k.application.data.breedImage.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedDetailRepository;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
import cl.mobdev.dogceoy2k.application.presentation.BreedDetailController;
import cl.mobdev.dogceoy2k.application.presentation.BreedDetailControllerImpl;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BreedConfiguration {

    // Presentation

    @Bean
    BreedDetailController breedDetailController(BreedDetailUseCase breedDetailUseCase){
        return new BreedDetailControllerImpl(breedDetailUseCase);
    }

    // Domain.useCase

    @Bean
    BreedDetailUseCase breedDetailUseCase(
            BreedDetailRepository breedDetailRepository
    ){
        return new BreedDetailUseCase(breedDetailRepository);
    }

    // Data.repository

    @Bean
    BreedDetailRepository breedDetailRepository(
            BreedImagesDataSource breedImagesDataSource,
            SubBreedsDataSource subBreedsDataSource,
            Mapper<BreedDetailModel, String> breedDetailModelStringMapper
    ){
        return new BreedDetailRepositoryImpl(
                breedImagesDataSource, subBreedsDataSource, breedDetailModelStringMapper);
    }

    // Data.mapper

    @Bean
    Mapper<BreedDetailModel, String> breedDetailModelStringMapper(){
        return new BreedDetailMapper();
    }

    // Data.datasource

    @Bean
    SubBreedsDataSource subBreedsDataSource(
            RestOperations restOperations,
            BreedProperties breedProperties
    ){
        return new SubBreedsDataSourceImpl(restOperations, breedProperties);
    }

    @Bean
    BreedImagesDataSource breedImagesDataSource(
            RestOperations restOperations,
            BreedProperties breedProperties
    ){
        return new BreedImagesDataSourceImpl(restOperations, breedProperties);
    }

    // Configuration

    @Bean
    BreedProperties breedProperties() {

        return new BreedProperties();
    }

    // FrameWorks

    @Bean
    RestOperations restOperations() {

        return new RestTemplate();
    }
}