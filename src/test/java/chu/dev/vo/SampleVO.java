package chu.dev.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class SampleVO {
    private String name;
    private Boolean hitSetter = false;

    public void setName(String name) {
        this.hitSetter = true;
        this.name = name;
    }
}
