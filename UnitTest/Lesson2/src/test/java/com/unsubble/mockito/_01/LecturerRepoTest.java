package com.unsubble.mockito._01;

import static org.assertj.core.api.Assertions.*;

import com.unsubble.mockito_01.LecturerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LecturerRepoTest {

    @Test
    void findLecturer() {
        LecturerRepository repo = Mockito.mock(LecturerRepository.class);
        Mockito.when(repo.findLecturer()).thenReturn(true);
        assertThat(repo.findLecturer()).isEqualTo(true);
        Mockito.verify(repo, Mockito.times(1)).findLecturer();
    }

    @Test
    void findLecturer2() {
        LecturerRepository repo = Mockito.mock(LecturerRepository.class);
        Mockito.when(repo.findLecturer()).thenReturn(true).thenReturn(false);
        assertThat(repo.findLecturer()).isEqualTo(true);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
    }

    @Test
    void findLecturer3() {
        LecturerRepository repo = Mockito.mock(LecturerRepository.class);
        Mockito.when(repo.findLecturer()).thenReturn(true).thenReturn(false);
        assertThat(repo.findLecturer()).isEqualTo(true);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
        assertThat(repo.findLecturer()).isEqualTo(false);
        Mockito.verify(repo, Mockito.atLeast(5)).findLecturer();
    }
}
