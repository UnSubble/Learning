package com.unsubble.mockito._02;

import com.unsubble.mockito_01.LecturerRepository;
import com.unsubble.mockito_01.LecturerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AnnotationTest {
    @Mock
    private LecturerRepository repository;

    @InjectMocks
    private LecturerRepositoryImpl repositoryImpl;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(AnnotationTest.class);
    }

}
