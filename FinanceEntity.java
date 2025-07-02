package com.example.model.finance;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "identifiers", "legalName", "shortName"
})
public class FinanceEntity {
    private FinanceIdentifier identifiers;
    private String legalName;
    private String shortName;

    public FinanceIdentifier getIdentifiers() { return identifiers; }
    public void setIdentifiers(FinanceIdentifier identifiers) { this.identifiers = identifiers; }

    public String getLegalName() { return legalName; }
    public void setLegalName(String legalName) { this.legalName = legalName; }

    public String getShortName() { return shortName; }
    public void setShortName(String shortName) { this.shortName = shortName; }
}
