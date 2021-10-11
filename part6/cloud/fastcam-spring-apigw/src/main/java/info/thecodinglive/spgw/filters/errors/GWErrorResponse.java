package info.thecodinglive.spgw.filters.errors;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class GWErrorResponse {
    private final String errorMessage;
    private final LocalDateTime localDateTime;
    private final Map<String, Object> addtionInfos = new HashMap<>();

    public GWErrorResponse(String errorMessage, LocalDateTime localDateTime) {
        this.errorMessage = errorMessage;
        this.localDateTime = localDateTime;
    }

    public static GWErrorResponse defaultBuild(String errorMessage) {
        return new GWErrorResponse(errorMessage, LocalDateTime.now());
    }

}
