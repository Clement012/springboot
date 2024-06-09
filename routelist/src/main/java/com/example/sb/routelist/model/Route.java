package com.example.sb.routelist.model;

import java.util.List;
import lombok.Getter;

@Getter
public class Route {
  private String type;
  private String version;
  private String generated_timestamp;
  private List<Data> data;
  
  @Getter
  public static class Data{
    private String route;
    private String bound;
    private String service_type;
    private String orig_en;
    private String orig_tc;
    private String orig_sc;
    private String dest_en;
    private String dest_tc;
    private String dest_sc;
  }
}
