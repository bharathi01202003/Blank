package com.example.dto;

import com.example.model.finance.FinanceEntity;
import com.example.model.kyc.KycData;

public class MergedResult {
    private Integer kycId;
    private FinanceEntity financeEntity;
    private KycData kycData;

    public MergedResult(Integer kycId, FinanceEntity financeEntity, KycData kycData) {
        this.kycId = kycId;
        this.financeEntity = financeEntity;
        this.kycData = kycData;
    }

    public Integer getKycId() {
        return kycId;
    }

    public void setKycId(Integer kycId) {
        this.kycId = kycId;
    }

    public FinanceEntity getFinanceEntity() {
        return financeEntity;
    }

    public void setFinanceEntity(FinanceEntity financeEntity) {
        this.financeEntity = financeEntity;
    }

    public KycData getKycData() {
        return kycData;
    }

    public void setKycData(KycData kycData) {
        this.kycData = kycData;
    }
}
