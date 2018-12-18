package com.car.cleaning.bo;

import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Flow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlowBo {

    private Flow flow;
    private Facility facility;

}
