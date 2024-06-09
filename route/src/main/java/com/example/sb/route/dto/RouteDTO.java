package com.example.sb.route.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RouteDTO {
  private String type;
  private String version;
//  private String generated_timestamp;
  private List<DataDTO> data;
  
  @Getter
  @Builder
  public static class DataDTO{
    private String route;
    private String bound;
  //  private String service_type;
    @JsonProperty(value = "orig_en")
    private String originalEnglishName;
    @JsonProperty(value = "orig_tc")
    private String originalCantoneseName;
  //  @JsonProperty(value = "orig_sc")
  //  private String originalChineseName;
    @JsonProperty(value = "dest_en")
    private String destinationEnglishName;
    @JsonProperty(value = "dest_tc")
    private String destinationCantoneseName;
  //  @JsonProperty(value = "dest_sc")
  //  private String destinationChineseName;
  }
}
