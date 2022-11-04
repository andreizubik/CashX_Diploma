package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancellationModel {
    private String name;
    private CancellationParams params;
}
