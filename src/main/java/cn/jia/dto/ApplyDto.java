package cn.jia.dto;

import cn.jia.domain.Apply;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ApplyDto {
    private Integer applyId;
    private String  positionName;
    private String userName;
    private Integer state;
    private String stateTrans;

    public String getStateTrans(){
        if(state == null){
            return "";
        }
        if(state.intValue() == Apply.ApplyState.DCK.value){
            return "待查看";
        }
        if(state.intValue() == Apply.ApplyState.YM.value){
            return "一面";
        }
        if(state.intValue() == Apply.ApplyState.EM.value){
            return "二面";
        }
        if(state.intValue() == Apply.ApplyState.TG.value){
            return "通过";
        }else{
            return "淘汰";
        }
    }
}
