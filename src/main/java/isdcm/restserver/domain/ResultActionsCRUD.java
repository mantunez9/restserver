package isdcm.restserver.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultActionsCRUD {
    private String missatge;
    private boolean isOk;
}