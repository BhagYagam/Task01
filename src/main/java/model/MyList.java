package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MyList {
    private String addList;

    public MyList(String addList){

        this.addList = addList;
    }
}
