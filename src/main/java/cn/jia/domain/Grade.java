package cn.jia.domain;
import lombok.Data;

@Data
public class Grade {
    private Integer id;

    private Integer userId;

    private Float score;

    private String classify;

    private String origQuest;

    private String scoreDetail;

    public Grade(Integer id, Integer userId, Float score,String classify) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.classify = classify;
    }

    public Grade() {
        super();
    }



}