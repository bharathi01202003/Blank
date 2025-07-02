package com.example.model.finance;

public class FinanceIdentifier {
    private Integer ptyId;
    private String crdsCode;
    private Integer kycId;

    public Integer getPtyId() { return ptyId; }
    public void setPtyId(Integer ptyId) { this.ptyId = ptyId; }

    public String getCrdsCode() { return crdsCode; }
    public void setCrdsCode(String crdsCode) { this.crdsCode = crdsCode; }

    public Integer getKycId() { return kycId; }
    public void setKycId(Integer kycId) { this.kycId = kycId; }
}
