package service_test;

import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.service.AdditionalMaterialService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdditionalMaterialServiceTest {
    @Mock
    AdditionalMaterialService materialService;

    @Test
    @DisplayName("Method void showInformAdditionalMaterialTest null test")
    void showInformAdditionalMaterialTestNull() {
        doCallRealMethod().when(materialService).showInformAdditionalMaterial(any(), any());
        Map<Long, List<AdditionalMaterial>> resourceListMap = mock(Map.class);
        Long lectureId = 0L;

        materialService.showInformAdditionalMaterial(lectureId, null);
        materialService.showInformAdditionalMaterial(null, resourceListMap);

        verify(materialService).showInformAdditionalMaterial(lectureId, null);
        verify(materialService).showInformAdditionalMaterial(null, resourceListMap);
    }
}
