package com.jiangqi.crm.query;

import com.jiangqi.crm.base.BaseQuery;

/**

 */
public class CustomerOrderQuery extends BaseQuery {

    private Integer cusId;  // 客户ID

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }
}
