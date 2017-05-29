package com.avanzarit.apps.gst.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SPADHI on 5/4/2017.
 */
@Entity
@Table(name = "customer")
public class Customer {


    private String customerId;
    private String customerName1;
    private String customerName2;
    private String customerName3;
    private String contactPerson;
    private String telephoneNumberExtn;
    private String telephoneNumber;
    private String telephoneExtn;
    private String mobileNo;
    private String email;
    private String faxNumber;
    private String faxExtn;
    private String faxNumberExtn;
    private String buildingNo;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String city;
    private String postCode;
    private String region;
    private String country;
    private String pan;
    private String gstRegistrationStatus;
    private String noOfGstRegistration;
    private String state;
    private String gstNumber;
    private String submityn = "N";
    private CustomerStatusEnum customerStatus;
    private String modifiedBy;
    private Date lastModifiedOn;
    private String submittedBy;
    private Date lastSubmittedOn;
    private String approvedBy;
    private Date lastApprovedOn;
    private String rejectedBy;
    private Date lastRejectedOn;
    private String lastRevertedBy;
    private Date lastRevertedOevertedOn;
    private int revertCount;
    private String rejectReason;
    private String revertReason;
    private String acceptTermsAndCondition;
    private String tncAcceptBy;
    private Date tncAcceptedOn;
    private Date sapSyncDate;


    @Id
    @Column(name = "customerid")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "customername1")
    public String getCustomerName1() {
        return customerName1;
    }

    public void setCustomerName1(String customerName1) {
        this.customerName1 = customerName1;
    }

    @Column(name = "customername2")
    public String getCustomerName2() {
        return customerName2;
    }

    public void setCustomerName2(String customerName2) {
        this.customerName2 = customerName2;
    }

    @Column(name = "customername3")
    public String getCustomerName3() {
        return customerName3;
    }

    public void setCustomerName3(String customerName3) {
        this.customerName3 = customerName3;
    }

    @Column(name = "contactperson")
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Column(name = "telephonenumberextn")
    public String getTelephoneNumberExtn() {
        return telephoneNumberExtn;
    }

    public void setTelephoneNumberExtn(String telephoneNumberExtn) {
        this.telephoneNumberExtn = telephoneNumberExtn;
    }

    @Column(name = "mobileno")
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "faxnumberextn")
    public String getFaxNumberExtn() {
        return faxNumberExtn;
    }

    public void setFaxNumberExtn(String faxNumberExtn) {
        this.faxNumberExtn = faxNumberExtn;
    }

    @Column(name = "buildingno")
    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Column(name = "address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name = "address3")
    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Column(name = "address4")
    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    @Column(name = "address5")
    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "postcode")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "pan")
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Column(name = "gstregistrationstatus")
    public String getGstRegistrationStatus() {
        return gstRegistrationStatus;
    }

    public void setGstRegistrationStatus(String gstRegistrationStatus) {
        this.gstRegistrationStatus = gstRegistrationStatus;
    }

    @Column(name = "noofgstregistration")
    public String getNoOfGstRegistration() {
        return noOfGstRegistration;
    }

    public void setNoOfGstRegistration(String noOfGstRegistration) {
        this.noOfGstRegistration = noOfGstRegistration;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "gstnumber")
    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }


    @Column(name = "submityn")
    public String getSubmityn() {
        return submityn;
    }

    public void setSubmityn(String submityn) {
        this.submityn = submityn;
    }

    @Transient
    public String getTelephoneNumber() {
        if (telephoneNumberExtn != null && telephoneNumberExtn.contains("-")) {
            telephoneNumber = telephoneNumberExtn.substring(0, telephoneNumberExtn.indexOf("-"));
        } else {
            telephoneNumber = telephoneNumberExtn;
        }
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Transient
    public String getTelephoneExtn() {
        if (telephoneNumberExtn != null && telephoneNumberExtn.contains("-")) {
            telephoneExtn = telephoneNumberExtn.substring(telephoneNumberExtn.indexOf("-") + 1, telephoneNumberExtn.length());
        }
        return telephoneExtn;
    }

    public void setTelephoneExtn(String telephoneExtn) {
        this.telephoneExtn = telephoneExtn;
    }

    @Transient
    public String getFaxNumber() {

        if (faxNumberExtn != null && faxNumberExtn.contains("-")) {
            faxNumber = faxNumberExtn.substring(0, faxNumberExtn.indexOf("-"));
        } else {
            faxNumber = faxNumberExtn;
        }
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Transient
    public String getFaxExtn() {

        if (faxNumberExtn != null && faxNumberExtn.contains("-")) {
            faxExtn = faxNumberExtn.substring(faxNumberExtn.indexOf("-") + 1, faxNumberExtn.length());
        }
        return faxExtn;

    }

    public void setFaxExtn(String faxExtn) {
        this.faxExtn = faxExtn;
    }



    @Column(name = "customerstatus")
    public CustomerStatusEnum getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatusEnum customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Column(name = "modifiedby")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name = "modifiedon")
    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Column(name = "submittedby")
    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Column(name = "lastsubmittedon")
    public Date getLastSubmittedOn() {
        return lastSubmittedOn;
    }

    public void setLastSubmittedOn(Date lastSubmittedOn) {
        this.lastSubmittedOn = lastSubmittedOn;
    }

    @Column(name = "approvedby")
    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Column(name = "lastapprovedon")
    public Date getLastApprovedOn() {
        return lastApprovedOn;
    }

    public void setLastApprovedOn(Date lastApprovedOn) {
        this.lastApprovedOn = lastApprovedOn;
    }

    @Column(name = "rejectedby")
    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    @Column(name = "lastrejectedon")
    public Date getLastRejectedOn() {
        return lastRejectedOn;
    }

    public void setLastRejectedOn(Date lastRejectedOn) {
        this.lastRejectedOn = lastRejectedOn;
    }

    @Column(name = "lastrevertedby")
    public String getLastRevertedBy() {
        return lastRevertedBy;
    }

    public void setLastRevertedBy(String lastRevertedBy) {
        this.lastRevertedBy = lastRevertedBy;
    }

    @Column(name = "lastrevertedon")
    public Date getLastRevertedOevertedOn() {
        return lastRevertedOevertedOn;
    }

    public void setLastRevertedOevertedOn(Date lastRevertedOevertedOn) {
        this.lastRevertedOevertedOn = lastRevertedOevertedOn;
    }

    @Column(name = "revertcount")
    public int getRevertCount() {
        return revertCount;
    }

    public void setRevertCount(int revertCount) {
        this.revertCount = revertCount;
    }

    @Column(name = "rejectreason")
    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Column(name = "revertreason")
    public String getRevertReason() {
        return revertReason;
    }

    public void setRevertReason(String revertReason) {
        this.revertReason = revertReason;
    }

    @Column(name = "isaccepttnc")
    public String isAcceptTermsAndCondition() {
        return acceptTermsAndCondition;
    }

    public void setAcceptTermsAndCondition(String acceptTermsAndCondition) {
        this.acceptTermsAndCondition = acceptTermsAndCondition;
    }

    @Column(name = "tncacceptedby")
    public String getTncAcceptBy() {
        return tncAcceptBy;
    }

    public void setTncAcceptBy(String tncAcceptBy) {
        this.tncAcceptBy = tncAcceptBy;
    }

    @Column(name = "tncacceptedon")
    public Date getTncAcceptedOn() {
        return tncAcceptedOn;
    }

    public void setTncAcceptedOn(Date tncAcceptedOn) {
        this.tncAcceptedOn = tncAcceptedOn;
    }

    @Column(name = "sapsyncdate")
    public Date getSapSyncDate() {
        return sapSyncDate;
    }

    public void setSapSyncDate(Date sapSyncDate) {
        this.sapSyncDate = sapSyncDate;
    }
}
