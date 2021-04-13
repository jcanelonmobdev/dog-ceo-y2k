package cl.mobdev.dogceoy2k.configuration;

import cl.mobdev.dogceoy2k.application.data.info.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.info.datasource.BreedImagesDataSourceImpl;
import cl.mobdev.dogceoy2k.application.data.info.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.info.datasource.SubBreedsDataSourceImpl;
import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.data.info.mapper.BreedImagesModelToBreedImagesEntityMapper;
import cl.mobdev.dogceoy2k.application.data.info.mapper.SubBreedsModelToSubBreedsEntityMapper;
import cl.mobdev.dogceoy2k.application.data.info.repository.*;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedImagesUseCase;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedImagesUseCaseImpl;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedInfoUseCase;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedInfoUseCaseImpl;
import cl.mobdev.dogceoy2k.application.presentation.BreedDetailController;
import cl.mobdev.dogceoy2k.application.presentation.BreedDetailControllerImpl;
import cl.mobdev.dogceoy2k.application.presentation.BreedImagesController;
import cl.mobdev.dogceoy2k.application.presentation.BreedImagesControllerImpl;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BreedConfiguration {

    // Presentation

    @Bean
    BreedDetailController breedDetailController(BreedInfoUseCase breedInfoUseCase){
        return new BreedDetailControllerImpl(breedInfoUseCase);
    }

    @Bean
    BreedImagesController breedImagesController(BreedImagesUseCase breedImagesUseCase){
        return new BreedImagesControllerImpl(breedImagesUseCase);
    }

    // Domain.useCase

    @Bean
    BreedInfoUseCase breedInfoUseCase(
            BreedInfoRepository breedImagesRepository
    ){
        return new BreedInfoUseCaseImpl(breedImagesRepository);
    }

    @Bean
    BreedImagesUseCase breedImagesUseCase(
            BreedImagesRepository breedImagesRepository
    ){
        return new BreedImagesUseCaseImpl(breedImagesRepository);
    }

    // Data.repository

    @Bean
    SubBreedsRepository subBreedsRepository(
            Mapper<SubBreedsModel, SubBreedsEntity> subBreedsModelSubBreedsEntityMapper,
            SubBreedsDataSource subBreedsDataSource
    ){
        return new SubBreedsRepositoryImpl(subBreedsModelSubBreedsEntityMapper, subBreedsDataSource);
    }

    @Bean
    BreedImagesRepository breedImagesRepository(
            Mapper<BreedImagesModel, BreedImagesEntity> breedImagesModelBreedImagesEntityMapper,
            BreedImagesDataSource breedImagesDataSource
    ) {
        return new BreedImagesRepositoryImpl(breedImagesModelBreedImagesEntityMapper, breedImagesDataSource);
    }

    @Bean
    BreedInfoRepository breedInfoRepository(
            BreedImagesRepository breedImagesRepository,
            SubBreedsRepository subBreedsRepository
    ){
        return new BreedInfoRepositoryImpl(breedImagesRepository, subBreedsRepository);
    }

    // Data.mapper

    @Bean
    Mapper<SubBreedsModel, SubBreedsEntity> subBreedsModelSubBreedsEntityMapper(){
        return new SubBreedsModelToSubBreedsEntityMapper();
    }

    @Bean
    Mapper<BreedImagesModel, BreedImagesEntity> breedImagesModelBreedImagesEntityMapper(){
        return new BreedImagesModelToBreedImagesEntityMapper();
    }

    // Data.datasource

    @Bean
    SubBreedsDataSource breedsDataSource(
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
    BreedProperties BreedProperties() {

        return new BreedProperties();
    }

    // FrameWorks

    @Bean
    RestOperations restOperations() {

        return new RestTemplate();
    }
}