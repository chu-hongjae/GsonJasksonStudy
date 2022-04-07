
# Json 
```
JSON (JavaScript Object Notation) 

```
# GSON 
```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.9.1</version>
    </dependency>
```

# Jackson 
```xml
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
    </dependency>
```

# Gson vs Jackson 
```
Jaskson 은 Object로 [Getter/Setter] 를 사용하지만 Gson은 [Getter/Setter]를 사용하지 않는다.
``` 


# 결론

```
SpringFramework 에서 MessageConverter를 Gson으로 사용 할 경우 Setter에 등록된 로직은 실행되지 않는다.

```

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingVO {

    private int pageNo;
    private int perPage = 20;
    private int startRowNum = 0;
    private int endRowNum = 0;
    
    // Gson 에서는 실행되지 않는다. 
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.startRowNum  = (this.pageNo * this.perPage) + 1;
        this.endRowNum = (this.startRowNum + perPage);
    }
}



```