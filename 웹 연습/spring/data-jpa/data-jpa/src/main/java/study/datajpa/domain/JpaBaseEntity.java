package study.datajpa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@MappedSuperclass//DB의 상속관계는 아님
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime localDate;//DB에서 변경X

    private LocalDateTime updateDate;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.localDate = now;
        this.updateDate = now;
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
