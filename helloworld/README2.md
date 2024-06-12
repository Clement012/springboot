### Spring Boot
  - @SpringBootApplication
  - @ComponentScan
  - @Component, @Service (interface), @Controller (interface), @Configuration
  - @Bean
  - @Autowired / @Qualifier
  - @PostMapping, @GetMapping
  - @PathVariable, @RequestParam
  - @JsonProperty (DTO)
  - @RestController (@ResponseBody + @Controller)
  - @PostConstruct (right after bean creation, before the server start completed)
  - @RestControllerAdvice (@ControllerAdvice + @Response)
  - @ExceptionHandler
  - @SpringBootTest, @WebMvcTest, @MockBean, @SpyBean
  - mockMvc.perform(), andExpect()
  - @Value

### Maven Project Java/SpringBoot
#### Lombok
  - @Data
  - @Getter
  - @Setter
  - @AllargsConstructor
  - @NoArgsConstructor
  - @EqualsAndHashCode

#### Others
  - Custom Library (infra folder)
    - ApiResp.class 
    - UriBuilder.class
    - BusinessRuntimeException.class , Syscode.class
    - GlobalExceptionHandler.class
  - Mockito, Junit5 , Hamcrest
  - @Mock, @Spy, @InjectMock, @BeforeAll, @BeforeEach, @AfterAll, @AfterEach
  - Mockito.when().thenResult() , verify() , assertThat, etc
  - RestTemplate

### Spring boot (Spring) vs Java
 - Spring Context & Bean, DI & IOC (Dependency Injection & Inversion of Control)
 - DI // ~Autowired definition
 - IOC // 
 - Global Exception Handling (Parent Concept - Exception.class/run)
 - Auto Deserialzation(Json -> JAVAObject) & Serialzation (JavaObject to JSON) (Object.mapper)
 - application.yml
 - Data Transfer Object(DTO in/DTO out)