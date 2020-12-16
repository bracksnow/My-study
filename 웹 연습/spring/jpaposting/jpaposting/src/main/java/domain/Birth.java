package domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Getter // 값타입이기 때문에 @Setter은 사용X
@Embeddable
public class Birth {

    private String year;

    private String month;

    private String date;

    protected Birth(){ }//Embeddable를 사용하려면 접근제어자를 public나 protected 둘 중 하나로 선택해야한다

    public Birth(String year, String month, String date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }
}
